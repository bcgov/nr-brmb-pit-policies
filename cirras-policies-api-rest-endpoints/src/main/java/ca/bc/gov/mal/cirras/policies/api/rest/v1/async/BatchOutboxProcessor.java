package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.OutboxTransactionTypes;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public class BatchOutboxProcessor extends OutboxProcessor {

	private static final Logger logger = LoggerFactory.getLogger(BatchOutboxProcessor.class);

	// batchName is used to distinguish between multiple BatchOutboxProcessors if
	// any.
	private String batchName;

	// List of OutboxProcessors included in this batch. Ordering indicates the order
	// in which outboxes will be processed for an INSERT or UPDATE
	// operation. DELETE operations will be processed in reverse order.
	private List<OutboxProcessor> outboxProcessorList;

	// Maps outbox model class name to index in outboxProcessorList.
	private Map<String, Integer> outboxModelToProcessorIndexMap;

	public BatchOutboxProcessor(Properties applicationProperties, String batchName,
			List<OutboxProcessor> outboxProcessorList) {
		super(applicationProperties);

		this.batchName = batchName;
		this.outboxProcessorList = outboxProcessorList;
		Map<String, Integer> outboxModelToProcessorIndexMap = new HashMap<String, Integer>();

		for (int i = 0; i < outboxProcessorList.size(); i++) {
			OutboxProcessor op = outboxProcessorList.get(i);
			outboxModelToProcessorIndexMap.put(op.getOutboxClassName(), i);
		}

		this.outboxModelToProcessorIndexMap = outboxModelToProcessorIndexMap;
	}

	@Override
	protected String getOutboxClassName() {
		return BaseOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return "polling.outbox.batch.enabled";
	}

	@Override
	protected String getFrequencyPropertyKey() {
		return "polling.outbox.batch.seconds.frequency";
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return "polling.outbox.batch.max.records";
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return "polling.outbox.batch.max.iterations";
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication,
			CirrasPolicyService cirrasPolicyService) throws ServiceException {

		logger.debug("<getNextOutboxes");

		List<BaseOutbox> outboxList = new ArrayList<BaseOutbox>();

		int maxRecordsRemaining = maxRecords;
		Iterator<OutboxProcessor> it = outboxProcessorList.iterator();
		while (maxRecordsRemaining > 0 && it.hasNext()) {
			OutboxProcessor op = it.next();
			List<? extends BaseOutbox> obs = op.getNextOutboxes(maxRecordsRemaining, authentication, cirrasPolicyService);
			if(obs != null) {
				outboxList.addAll(obs);
				maxRecordsRemaining = maxRecordsRemaining - obs.size();
			}
		}

		// Sort the list so they are processed in (more or less) chronological order.
		outboxList.sort(new Comparator<BaseOutbox>() {
			@Override
			public int compare(BaseOutbox o1, BaseOutbox o2) {

				int result = o1.getEntryTimestamp().compareTo(o2.getEntryTimestamp());

				if (result == 0) {

					String o1ClassName = o1.getClass().getName();
					String o2ClassName = o2.getClass().getName();

					if (o1ClassName.equals(o2ClassName)) {
						// Order by outbox id.
						result = o1.getOutboxKey().compareTo(o2.getOutboxKey());
					} else {
						// If the transaction is INSERTED or UPDATED then order according to
						// outboxProcessorList. If the transaction is DELETED, then
						// reverse the order.

						Boolean o1Deleted = o1.getTransactionType().equals(OutboxTransactionTypes.Deleted);
						Boolean o2Deleted = o2.getTransactionType().equals(OutboxTransactionTypes.Deleted);

						result = o1Deleted.compareTo(o2Deleted);

						if (result == 0) {
							Integer o1Idx = outboxModelToProcessorIndexMap.get(o1ClassName);
							Integer o2Idx = outboxModelToProcessorIndexMap.get(o2ClassName);

							if (o1Idx == null) {
								throw new ServiceException("Outbox type " + o1ClassName
										+ " is not supported by this BatchOutboxProcessor");
							} else if (o2Idx == null) {
								throw new ServiceException("Outbox type " + o2ClassName
										+ " is not supported by this BatchOutboxProcessor");
							}

							if (o1Deleted) {
								result = o2Idx.compareTo(o1Idx);
							} else {
								result = o1Idx.compareTo(o2Idx);
							}
						}
					}
				}

				return result;
			}
		});

		logger.debug(">getNextOutboxes");

		return outboxList;
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication,
			CirrasPolicyService cirrasPolicyService) throws ServiceException {

		logger.debug("<processOutbox");

		// Retrieve the OutboxProcessor for the given outbox type.
		Integer opIdx = outboxModelToProcessorIndexMap.get(outbox.getClass().getName());

		if (opIdx == null) {
			throw new ServiceException(
					"Outbox type " + outbox.getClass().getName() + " is not supported by this BatchOutboxProcessor");
		}

		OutboxProcessor op = outboxProcessorList.get(opIdx);
		op.processOutbox(outbox, doPublishEvent, authentication, cirrasPolicyService);

		logger.debug(">processOutbox");
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
