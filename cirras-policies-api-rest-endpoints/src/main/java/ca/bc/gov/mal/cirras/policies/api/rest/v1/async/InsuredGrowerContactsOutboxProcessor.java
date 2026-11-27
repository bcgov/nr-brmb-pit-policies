package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrowerContactsOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public class InsuredGrowerContactsOutboxProcessor extends OutboxProcessor {

	public static final String INSURED_GROWER_CONTACTS_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.insured_grower_contacts.enabled";
	public static final String INSURED_GROWER_CONTACTS_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.insured_grower_contacts.seconds.frequency";
	public static final String INSURED_GROWER_CONTACTS_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.insured_grower_contacts.max.records";
	public static final String INSURED_GROWER_CONTACTS_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.insured_grower_contacts.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(InsuredGrowerContactsOutboxProcessor.class);
	
	
	public InsuredGrowerContactsOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}
	
	@Override
	protected String getOutboxClassName() {
		return InsuredGrowerContactsOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return INSURED_GROWER_CONTACTS_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return INSURED_GROWER_CONTACTS_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return INSURED_GROWER_CONTACTS_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return INSURED_GROWER_CONTACTS_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextInsuredGrowerContactsOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		InsuredGrowerContactsOutbox insuredGrowerContactsOutbox = (InsuredGrowerContactsOutbox)outbox;
		cirrasPolicyService.processInsuredGrowerContactsOutbox(insuredGrowerContactsOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
