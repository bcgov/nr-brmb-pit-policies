package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.EmailsOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public class EmailsOutboxProcessor extends OutboxProcessor {

	public static final String EMAILS_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.emails.enabled";
	public static final String EMAILS_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.emails.seconds.frequency";
	public static final String EMAILS_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.emails.max.records";
	public static final String EMAILS_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.emails.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(EmailsOutboxProcessor.class);
	
	
	public EmailsOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}
	
	@Override
	protected String getOutboxClassName() {
		return EmailsOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return EMAILS_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return EMAILS_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return EMAILS_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return EMAILS_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextEmailsOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		EmailsOutbox emailsOutbox = (EmailsOutbox)outbox;
		cirrasPolicyService.processEmailsOutbox(emailsOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
