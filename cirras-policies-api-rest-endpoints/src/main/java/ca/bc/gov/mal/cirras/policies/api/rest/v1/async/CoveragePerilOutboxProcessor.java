package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CoveragePerilOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public class CoveragePerilOutboxProcessor extends OutboxProcessor {

	public static final String COVERAGE_PERIL_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.coverage_peril.enabled";
	public static final String COVERAGE_PERIL_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.coverage_peril.seconds.frequency";
	public static final String COVERAGE_PERIL_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.coverage_peril.max.records";
	public static final String COVERAGE_PERIL_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.coverage_peril.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(CoveragePerilOutboxProcessor.class);
	
	
	public CoveragePerilOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}
	
	@Override
	protected String getOutboxClassName() {
		return CoveragePerilOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return COVERAGE_PERIL_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return COVERAGE_PERIL_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return COVERAGE_PERIL_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return COVERAGE_PERIL_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextCoveragePerilOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		CoveragePerilOutbox coveragePerilOutbox = (CoveragePerilOutbox)outbox;
		cirrasPolicyService.processCoveragePerilOutbox(coveragePerilOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
