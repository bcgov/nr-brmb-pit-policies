package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.ContactsOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.nrs.wfone.common.service.api.ServiceException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class ContactsOutboxProcessor extends OutboxProcessor {

	public static final String CONTACTS_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.contacts.enabled";
	public static final String CONTACTS_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.contacts.seconds.frequency";
	public static final String CONTACTS_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.contacts.max.records";
	public static final String CONTACTS_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.contacts.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(ContactsOutboxProcessor.class);
	
	
	public ContactsOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}
	
	@Override
	protected String getOutboxClassName() {
		return ContactsOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return CONTACTS_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return CONTACTS_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return CONTACTS_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return CONTACTS_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextContactsOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		ContactsOutbox contactsOutbox = (ContactsOutbox)outbox;
		cirrasPolicyService.processContactsOutbox(contactsOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
