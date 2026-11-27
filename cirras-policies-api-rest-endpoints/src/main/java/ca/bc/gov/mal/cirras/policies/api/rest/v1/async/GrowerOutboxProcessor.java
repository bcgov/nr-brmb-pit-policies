package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.nrs.wfone.common.service.api.ServiceException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class GrowerOutboxProcessor extends OutboxProcessor {

	public static final String GROWER_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.grower.enabled";
	public static final String GROWER_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.grower.seconds.frequency";
	public static final String GROWER_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.grower.max.records";
	public static final String GROWER_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.grower.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(GrowerOutboxProcessor.class);
	
	
	public GrowerOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}

	@Override
	protected String getOutboxClassName() {
		return GrowerOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return GROWER_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return GROWER_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return GROWER_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return GROWER_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextGrowerOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		GrowerOutbox growerOutbox = (GrowerOutbox)outbox;
		cirrasPolicyService.processGrowerOutbox(growerOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
