package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import java.util.Properties;
import java.util.List;
import java.util.ArrayList;

import jakarta.annotation.PreDestroy;
import jakarta.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class FetchOutboxTask extends AsynchronousTimerTask {
	
	private static final Logger logger = LoggerFactory.getLogger(FetchOutboxTask.class);
	
	private static final String LOGGING_ID_SOURCE = "SYNCOB";
		
	public static final String EMAIL_SUBJECT_PROPERTY_KEY = "email.outbox.synch.error.subject";

	private CirrasPolicyService cirrasPolicyService;

	private List<OutboxProcessor> outboxProcessorList;
	
	public FetchOutboxTask(Properties applicationProperties) throws AddressException {
		super(applicationProperties);
		
		OutboxProcessor codeOutboxProcessor = new CodeOutboxProcessor(applicationProperties);
		OutboxProcessor cropTypeOutboxProcessor = new CropTypeOutboxProcessor(applicationProperties);
		OutboxProcessor commodityTypeCodeOutboxProcessor = new CommodityTypeCodeOutboxProcessor(applicationProperties);
		OutboxProcessor commodityTypeVarietyXrefOutboxProcessor = new CommodityTypeVarietyXrefOutboxProcessor(applicationProperties);
		OutboxProcessor coveragePerilOutboxProcessor = new CoveragePerilOutboxProcessor(applicationProperties);
		OutboxProcessor claimOutboxProcessor = new ClaimOutboxProcessor(applicationProperties);
		OutboxProcessor growerOutboxProcessor = new GrowerOutboxProcessor(applicationProperties);
		OutboxProcessor policyOutboxProcessor = new PolicyOutboxProcessor(applicationProperties);
		OutboxProcessor growerContractYearOutboxProcessor = new GrowerContractYearOutboxProcessor(applicationProperties);
		OutboxProcessor contactsOutboxProcessor = new ContactsOutboxProcessor(applicationProperties);
		OutboxProcessor insuredGrowerContactsOutboxProcessor = new InsuredGrowerContactsOutboxProcessor(applicationProperties);
		OutboxProcessor emailsOutboxProcessor = new EmailsOutboxProcessor(applicationProperties);
		OutboxProcessor telecomOutboxProcessor = new TelecomOutboxProcessor(applicationProperties);
		OutboxProcessor productOutboxProcessor = new ProductOutboxProcessor(applicationProperties); 

		// Outboxes are added to batchCropOutboxList in order that insert/update events would need to be processed. Delete events are processed in reverse order.
		//The outboxes need to be processed in this order: CropType, CommodityTypeCode, CommodityTypeVarietyXref
		List<OutboxProcessor> batchCropOutboxList = new ArrayList<OutboxProcessor>();
		batchCropOutboxList.add(cropTypeOutboxProcessor);
		batchCropOutboxList.add(commodityTypeCodeOutboxProcessor);
		batchCropOutboxList.add(commodityTypeVarietyXrefOutboxProcessor);
		
		//Currently all BatchOutboxProcessors use the same config settings. But in the future may differentiate using the batchName.
		OutboxProcessor batchCropOutboxProcessor = new BatchOutboxProcessor(applicationProperties, "crop", batchCropOutboxList);
		
		// Outboxes are processed in order of dependency. For example, Crop Types is processed before Claims because Claims might depend on new Commodities or Varieties.
		outboxProcessorList = new ArrayList<OutboxProcessor>();
		outboxProcessorList.add(codeOutboxProcessor);
		outboxProcessorList.add(batchCropOutboxProcessor);
		outboxProcessorList.add(coveragePerilOutboxProcessor);
		outboxProcessorList.add(claimOutboxProcessor);
		
		// Outboxes are added to batchPolicyOutboxList in order that insert/update events would need to be processed. Delete events are processed in reverse order.
		//The outboxes need to be processed in this order: Contact, Email, Telecom, Grower, Contact Grower, Policies, Grower Contract Year, Products.
		List<OutboxProcessor> batchPolicyOutboxList = new ArrayList<OutboxProcessor>();
		batchPolicyOutboxList.add(contactsOutboxProcessor);
		batchPolicyOutboxList.add(emailsOutboxProcessor);
		batchPolicyOutboxList.add(telecomOutboxProcessor);
		batchPolicyOutboxList.add(growerOutboxProcessor);
		batchPolicyOutboxList.add(insuredGrowerContactsOutboxProcessor);
		batchPolicyOutboxList.add(policyOutboxProcessor);
		batchPolicyOutboxList.add(growerContractYearOutboxProcessor);
		batchPolicyOutboxList.add(productOutboxProcessor);
		
		//Currently all BatchOutboxProcessors use the same config settings. But in the future may differentiate using the batchName.
		OutboxProcessor batchPolicyGrowerContactOutboxProcessor = new BatchOutboxProcessor(applicationProperties, "policy_grower_contact", batchPolicyOutboxList);
		
		// Outboxes are processed generally in order of dependency, but otherwise independently. If two or more outboxes are highly coupled, and need to be 
		// processed in order together to ensure inserts/updates/deletes between them are in the right sequence, then use a BatchOutboxProcessor.
		outboxProcessorList.add(batchPolicyGrowerContactOutboxProcessor);
		
	}
	
	private boolean initialized;
	
	public void init() {
		logger.debug("<init");
		
//		this.profileAuthorizationService.init(applicationProperties);
		
		this.initialized = true;
		
		logger.debug(">init");
	}
	
	
	@PreDestroy
	public void destroy() {
		logger.info("<destroy");
		cancel();
		logger.info(">destroy");
	}
	
	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public void run() {
		logger.info("<run");
		
		if(!this.initialized) {
			
			throw new IllegalStateException("Task has not been initialized.");
		}
		
		long startMillis = System.currentTimeMillis();
		
		setLoggingRequestId(LOGGING_ID_SOURCE);
		
		try {

			WebAdeAuthentication authentication = this.getWebAdeAuthentication();

			for ( OutboxProcessor op : outboxProcessorList ) {
				op.process(authentication, cirrasPolicyService);
			}
			
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
			addError(ERROR_TYPE_UNRECOVERABLE, "Encountered an unrecoverable error: "+e.getMessage());
		}
		
		sendErrors();
		
		long executionMillis = System.currentTimeMillis() - startMillis;
		logger.debug("Execution Seconds: "+((executionMillis)/1000.0));
		
		logger.debug(">run");
	}

	public void setCirrasPolicyService(CirrasPolicyService cirrasPolicyService) {
		this.cirrasPolicyService = cirrasPolicyService;
	}

	@Override
	protected String getEmailSubjectPropertyKey() {
		return EMAIL_SUBJECT_PROPERTY_KEY;
	}
}
