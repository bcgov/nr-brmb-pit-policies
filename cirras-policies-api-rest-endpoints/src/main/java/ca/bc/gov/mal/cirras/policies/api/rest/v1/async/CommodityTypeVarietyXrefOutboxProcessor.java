package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.BaseOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeVarietyXrefOutbox;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public class CommodityTypeVarietyXrefOutboxProcessor extends OutboxProcessor {

	public static final String COMMODITY_TYPE_VARIETY_XREF_OUTBOX_POLLING_ENABLED_KEY = "polling.outbox.commodity_type_variety_xref.enabled";
	public static final String COMMODITY_TYPE_VARIETY_XREF_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY = "polling.outbox.commodity_type_variety_xref.seconds.frequency";
	public static final String COMMODITY_TYPE_VARIETY_XREF_OUTBOX_POLLING_MAX_RECORDS_KEY = "polling.outbox.commodity_type_variety_xref.max.records";
	public static final String COMMODITY_TYPE_VARIETY_XREF_OUTBOX_POLLING_MAX_ITERATIONS_KEY = "polling.outbox.commodity_type_variety_xref.max.iterations";

	private static final Logger logger = LoggerFactory.getLogger(CommodityTypeVarietyXrefOutboxProcessor.class);
	
	
	public CommodityTypeVarietyXrefOutboxProcessor(Properties applicationProperties) {
		super(applicationProperties);
	}
	
	@Override
	protected String getOutboxClassName() {
		return CommodityTypeVarietyXrefOutbox.class.getName();
	}

	@Override
	protected String getEnabledPropertyKey() {
		return COMMODITY_TYPE_VARIETY_XREF_OUTBOX_POLLING_ENABLED_KEY;
	}
	
	@Override
	protected String getFrequencyPropertyKey() {
		return COMMODITY_TYPE_VARIETY_XREF_OUTBOX_POLLING_SECONDS_FREQUENCY_KEY;
	}

	@Override
	protected String getMaxRecordsPropertyKey() {
		return COMMODITY_TYPE_VARIETY_XREF_OUTBOX_POLLING_MAX_RECORDS_KEY;
	}

	@Override
	protected String getMaxIterationsPropertyKey() {
		return COMMODITY_TYPE_VARIETY_XREF_OUTBOX_POLLING_MAX_ITERATIONS_KEY;
	}

	@Override
	protected List<? extends BaseOutbox> getNextOutboxes(int maxRecords, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		return cirrasPolicyService.getNextCommodityTypeVarietyXrefOutboxes(maxRecords, authentication);
	}

	@Override
	protected void processOutbox(BaseOutbox outbox, boolean doPublishEvent, WebAdeAuthentication authentication, CirrasPolicyService cirrasPolicyService) throws ServiceException {
		CommodityTypeVarietyXrefOutbox commodityTypeVarietyXrefOutbox = (CommodityTypeVarietyXrefOutbox)outbox;
		cirrasPolicyService.processCommodityTypeVarietyXrefOutbox(commodityTypeVarietyXrefOutbox, doPublishEvent, authentication);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
