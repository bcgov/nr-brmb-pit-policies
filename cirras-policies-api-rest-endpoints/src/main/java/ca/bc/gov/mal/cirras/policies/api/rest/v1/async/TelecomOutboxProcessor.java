package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.TelecomOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public class TelecomOutboxProcessor extends OutboxProcessor {

	public static final String TELECOM_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.telecom.enabled";
	public static final String TELECOM_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.telecom.seconds.frequency";
	public static final String TELECOM_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.telecom.max.records";
	public static final String TELECOM_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.telecom.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(TelecomOutboxProcessor.class);
	
	
	public TelecomOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}
	
	@Override
	protected String getOutboxClassName() {
		return TelecomOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return TELECOM_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return TELECOM_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return TELECOM_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return TELECOM_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextTelecomOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		TelecomOutbox telecomOutbox = (TelecomOutbox)outbox;
		cirrasPolicyService.processTelecomOutbox(telecomOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
