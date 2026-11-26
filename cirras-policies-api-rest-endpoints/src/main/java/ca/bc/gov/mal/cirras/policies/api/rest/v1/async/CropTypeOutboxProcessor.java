package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CropTypeOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.nrs.wfone.common.service.api.ServiceException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class CropTypeOutboxProcessor extends OutboxProcessor {

	public static final String CROP_TYPE_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.crop_type.enabled";
	public static final String CROP_TYPE_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.crop_type.seconds.frequency";
	public static final String CROP_TYPE_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.crop_type.max.records";
	public static final String CROP_TYPE_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.crop_type.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(CropTypeOutboxProcessor.class);
	
	
	public CropTypeOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}

	@Override
	protected String getOutboxClassName() {
		return CropTypeOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return CROP_TYPE_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return CROP_TYPE_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return CROP_TYPE_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return CROP_TYPE_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextCropTypeOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		CropTypeOutbox cropTypeOutbox = (CropTypeOutbox)outbox;
		cirrasPolicyService.processCropTypeOutbox(cropTypeOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
