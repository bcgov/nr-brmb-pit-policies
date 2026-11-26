package ca.bc.gov.mal.cirras.policies.service.api.v1;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaim;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaimList;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrowerContactsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerContractYearOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.ClaimCalculationSubmit;
import ca.bc.gov.mal.cirras.policies.model.v1.ClaimOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CodeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeCodeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeVarietyXrefOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.ContactsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CropTypeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.EmailsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.PolicyOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.Product;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductList;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.TelecomOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CoveragePerilOutbox;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.service.api.MaxResultsExceededException;
import ca.bc.gov.mal.pit.common.service.api.NotFoundException;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.service.api.ValidationFailureException;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryContext;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public interface CirrasPolicyService {
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	InsuranceClaim getInsuranceClaim(
		Integer claimNumber, 
		FactoryContext factoryContext, 
		WebAdeAuthentication authentication
	)
	throws ServiceException, NotFoundException;
	
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	InsuranceClaimList<? extends InsuranceClaim> getClaims(
		Integer claimNumber,
		String policyNumber,
		FactoryContext context, 
		WebAdeAuthentication authentication
	) 
	throws ServiceException, MaxResultsExceededException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	ProductList<? extends Product> getProducts(
		Integer insurancePolicyId,
		Boolean includeProductDetails, 
		Integer productId, 
		String commodityCoverageCode,
		FactoryContext context, 
		WebAdeAuthentication authentication
	) 
	throws ServiceException, MaxResultsExceededException;
	
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<ClaimOutbox> getNextClaimOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processClaimOutbox(
		ClaimOutbox claimOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<GrowerOutbox> getNextGrowerOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processGrowerOutbox(
		GrowerOutbox growerOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<PolicyOutbox> getNextPolicyOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processPolicyOutbox(
		PolicyOutbox policyOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<GrowerContractYearOutbox> getNextGrowerContractYearOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processGrowerContractYearOutbox(
		GrowerContractYearOutbox growerContractYearOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException;
	
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<CropTypeOutbox> getNextCropTypeOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processCropTypeOutbox(
		CropTypeOutbox cropTypeOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<CodeOutbox> getNextCodeOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) 
	throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processCodeOutbox(
		CodeOutbox codeOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException;
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void submitClaimCalculation(
		ClaimCalculationSubmit claimCalculationSubmit, 
		FactoryContext factoryContext, 
		WebAdeAuthentication authentication
	)
	throws ServiceException, ValidationFailureException, NotFoundException, DaoException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<CoveragePerilOutbox> getNextCoveragePerilOutboxes(Integer maxRecords, WebAdeAuthentication authentication)
			throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processCoveragePerilOutbox(CoveragePerilOutbox coveragePerilOutbox, Boolean doPublishEvent,
			WebAdeAuthentication authentication) throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<ContactsOutbox> getNextContactsOutboxes(Integer maxRecords, WebAdeAuthentication authentication)
			throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processContactsOutbox(ContactsOutbox contactsOutbox, Boolean doPublishEvent,
			WebAdeAuthentication authentication) throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<InsuredGrowerContactsOutbox> getNextInsuredGrowerContactsOutboxes(Integer maxRecords, WebAdeAuthentication authentication)
			throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processInsuredGrowerContactsOutbox(InsuredGrowerContactsOutbox insuredGrowerContactsOutbox, Boolean doPublishEvent,
			WebAdeAuthentication authentication) throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<EmailsOutbox> getNextEmailsOutboxes(Integer maxRecords, WebAdeAuthentication authentication)
			throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processEmailsOutbox(EmailsOutbox emailsOutbox, Boolean doPublishEvent,
			WebAdeAuthentication authentication) throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<TelecomOutbox> getNextTelecomOutboxes(Integer maxRecords, WebAdeAuthentication authentication)
			throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processTelecomOutbox(TelecomOutbox telecomOutbox, Boolean doPublishEvent,
			WebAdeAuthentication authentication) throws ServiceException;
	

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<CommodityTypeCodeOutbox> getNextCommodityTypeCodeOutboxes(Integer maxRecords, WebAdeAuthentication authentication)
			throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processCommodityTypeCodeOutbox(CommodityTypeCodeOutbox commodityTypeCodeOutbox, Boolean doPublishEvent,
			WebAdeAuthentication authentication) throws ServiceException;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<CommodityTypeVarietyXrefOutbox> getNextCommodityTypeVarietyXrefOutboxes(Integer maxRecords, WebAdeAuthentication authentication)
			throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processCommodityTypeVarietyXrefOutbox(CommodityTypeVarietyXrefOutbox commodityTypeVarietyXrefOutbox, Boolean doPublishEvent,
			WebAdeAuthentication authentication) throws ServiceException;


	@Transactional(readOnly = true, rollbackFor = Exception.class)
	List<ProductOutbox> getNextProductOutboxes(Integer maxRecords, WebAdeAuthentication authentication)
			throws ServiceException;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	void processProductOutbox(ProductOutbox productOutbox, Boolean doPublishEvent,
			WebAdeAuthentication authentication) throws ServiceException;

}
