package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CodeOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.nrs.wfone.common.service.api.ServiceException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class CodeOutboxProcessor extends OutboxProcessor {

	public static final String CODE_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.code.enabled";
	public static final String CODE_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.code.seconds.frequency";
	public static final String CODE_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.code.max.records";
	public static final String CODE_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.code.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(CodeOutboxProcessor.class);
	
	
	public CodeOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}
	
	@Override
	protected String getOutboxClassName() {
		return CodeOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return CODE_OUTBOX_POLLING_ENABLED_KEY;
	}
		
	@Override
	protected String getFrequencyPropertyKey() {
		return CODE_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return CODE_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return CODE_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextCodeOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		CodeOutbox codeOutbox = (CodeOutbox)outbox;
		cirrasPolicyService.processCodeOutbox(codeOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
