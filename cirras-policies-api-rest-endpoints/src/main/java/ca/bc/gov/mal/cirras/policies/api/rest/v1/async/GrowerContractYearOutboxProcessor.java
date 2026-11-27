package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerContractYearOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public class GrowerContractYearOutboxProcessor extends OutboxProcessor {

	public static final String GROWER_CONTRACT_YEAR_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.grower_contract_year.enabled";
	public static final String GROWER_CONTRACT_YEAR_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.grower_contract_year.seconds.frequency";
	public static final String GROWER_CONTRACT_YEAR_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.grower_contract_year.max.records";
	public static final String GROWER_CONTRACT_YEAR_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.grower_contract_year.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(GrowerContractYearOutboxProcessor.class);
	
	
	public GrowerContractYearOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}

	@Override
	protected String getOutboxClassName() {
		return GrowerContractYearOutbox.class.getName();
	}
	
	@Override
	protected String getEnabledPropertyKey() {
		return GROWER_CONTRACT_YEAR_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return GROWER_CONTRACT_YEAR_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return GROWER_CONTRACT_YEAR_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return GROWER_CONTRACT_YEAR_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextGrowerContractYearOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		GrowerContractYearOutbox growerContractYearOutbox = (GrowerContractYearOutbox)outbox;
		cirrasPolicyService.processGrowerContractYearOutbox(growerContractYearOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
