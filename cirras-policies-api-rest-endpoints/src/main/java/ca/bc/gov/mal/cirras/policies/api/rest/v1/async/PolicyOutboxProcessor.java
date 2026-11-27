package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.PolicyOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.nrs.wfone.common.service.api.ServiceException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class PolicyOutboxProcessor extends OutboxProcessor {

	public static final String POLICY_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.policy.enabled";
	public static final String POLICY_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.policy.seconds.frequency";
	public static final String POLICY_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.policy.max.records";
	public static final String POLICY_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.policy.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(PolicyOutboxProcessor.class);
	
	
	public PolicyOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}

	@Override
	protected String getOutboxClassName() {
		return PolicyOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return POLICY_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return POLICY_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return POLICY_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return POLICY_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextPolicyOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		PolicyOutbox policyOutbox = (PolicyOutbox)outbox;
		cirrasPolicyService.processPolicyOutbox(policyOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
