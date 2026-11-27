package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public class ProductOutboxProcessor extends OutboxProcessor {

	public static final String PRODUCT_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.product.enabled";
	public static final String PRODUCT_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.product.seconds.frequency";
	public static final String PRODUCT_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.product.max.records";
	public static final String PRODUCT_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.product.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(ProductOutboxProcessor.class);
	
	
	public ProductOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}
	
	@Override
	protected String getOutboxClassName() {
		return ProductOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return PRODUCT_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return PRODUCT_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return PRODUCT_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return PRODUCT_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextProductOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		ProductOutbox productOutbox = (ProductOutbox)outbox;
		cirrasPolicyService.processProductOutbox(productOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
