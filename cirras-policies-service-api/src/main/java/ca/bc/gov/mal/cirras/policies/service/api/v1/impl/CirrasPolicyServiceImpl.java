package ca.bc.gov.mal.cirras.policies.service.api.v1.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.ClaimCalculationSubmit;
import ca.bc.gov.mal.cirras.policies.model.v1.ClaimOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CodeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CropTypeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.Emails;
import ca.bc.gov.mal.cirras.policies.model.v1.EmailsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerContractYear;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerContractYearOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.PolicyOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.Product;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductList;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.Telecom;
import ca.bc.gov.mal.cirras.policies.model.v1.TelecomOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CodeSync;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeCodeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeCodeSync;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeVarietyXrefOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityVarietySync;
import ca.bc.gov.mal.cirras.policies.model.v1.Contacts;
import ca.bc.gov.mal.cirras.policies.model.v1.ContactsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CoveragePerilOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CoveragePerilSync;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaim;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaimList;
import ca.bc.gov.mal.cirras.policies.model.v1.InsurancePolicy;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrower;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrowerContacts;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrowerContactsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.OutboxTransactionTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.PoliciesEventTypes;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimCalculationSubmitDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimSearchDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CodeSyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityTypeCodeOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityTypeCodeSyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityTypeVarietyXrefOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityVarietySyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ContactsDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ContactsOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CoveragePerilOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CoveragePerilSyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CodeOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CropTypeOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.EmailsDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.EmailsOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerContractYearDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerContractYearOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.InsuredGrowerContactsDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.InsuredGrowerContactsOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.PolicyDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.PolicyOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ProductDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ProductOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.TelecomDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.TelecomOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.UserDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.VarietyDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimCalculationSubmitDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeSyncDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeSyncDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeVarietyXrefOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityVarietySyncDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilSyncDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CropTypeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.EmailsDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.EmailsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.UserDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.VarietyDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.ClaimCalculationSubmitFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.CodeSyncFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.CommodityTypeCodeSyncFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.CommodityVarietySyncFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.ContactsFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.CoveragePerilSyncFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.EmailsFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.GrowerContractYearFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.InsuranceClaimFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.InsurancePolicyFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.InsuredGrowerContactsFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.InsuredGrowerFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.OutboxFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.ProductFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.TelecomFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.validation.ModelValidator;
import ca.bc.gov.mal.cirras.policies.service.api.v1.EventPublisher;
import ca.bc.gov.mal.cirras.policies.service.api.v1.EventPublisherException;
import ca.bc.gov.mal.pit.common.model.Message;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.service.api.MaxResultsExceededException;
import ca.bc.gov.mal.pit.common.service.api.NotFoundException;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.service.api.ValidationFailureException;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryContext;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;


public class CirrasPolicyServiceImpl implements CirrasPolicyService {

	private static final Logger logger = LoggerFactory.getLogger(CirrasPolicyServiceImpl.class);

	private Properties applicationProperties;

	private ModelValidator modelValidator;

	// factories
	private CodeSyncFactory codeSyncFactory;
	private CommodityVarietySyncFactory commodityVarietySyncFactory;
	private CoveragePerilSyncFactory coveragePerilSyncFactory;
	private InsuranceClaimFactory insuranceClaimFactory;
	private ClaimCalculationSubmitFactory claimCalculationSubmitFactory;
	private InsurancePolicyFactory insurancePolicyFactory;
	private GrowerContractYearFactory growerContractYearFactory;
	private InsuredGrowerFactory insuredGrowerFactory;
	private OutboxFactory outboxFactory;
	private ContactsFactory contactsFactory;
	private InsuredGrowerContactsFactory insuredGrowerContactsFactory;
	private EmailsFactory emailsFactory;
	private TelecomFactory telecomFactory;
	private ProductFactory productFactory;
	private CommodityTypeCodeSyncFactory commodityTypeCodeSyncFactory;

	
	// daos
	private ClaimDao claimDao;
	private ClaimOutboxDao claimOutboxDao;
	private ClaimSearchDao claimSearchDao;
	private CodeSyncDao codeSyncDao;
	private CommodityVarietySyncDao commodityVarietySyncDao;
	private CodeOutboxDao codeOutboxDao;
	private CropTypeOutboxDao cropTypeOutboxDao;
	private CoveragePerilOutboxDao coveragePerilOutboxDao;
	private CoveragePerilSyncDao coveragePerilSyncDao;
	private GrowerDao growerDao;
	private GrowerOutboxDao growerOutboxDao;
	private PolicyDao policyDao;
	private PolicyOutboxDao policyOutboxDao;
	private GrowerContractYearDao growerContractYearDao;
	private GrowerContractYearOutboxDao growerContractYearOutboxDao;
	private VarietyDao varietyDao;
	private ClaimCalculationSubmitDao claimCalculationSubmitDao;
	private UserDao userDao;
	private ContactsDao contactsDao;
	private ContactsOutboxDao contactsOutboxDao;
	private InsuredGrowerContactsDao insuredGrowerContactsDao;
	private InsuredGrowerContactsOutboxDao insuredGrowerContactsOutboxDao;
	private EmailsDao emailsDao;
	private EmailsOutboxDao emailsOutboxDao;
	private TelecomDao telecomDao;
	private TelecomOutboxDao telecomOutboxDao;
	private ProductDao productDao;
	private ProductOutboxDao productOutboxDao;
	private CommodityTypeCodeSyncDao commodityTypeCodeSyncDao;
	private CommodityTypeCodeOutboxDao commodityTypeCodeOutboxDao;
	private CommodityTypeVarietyXrefOutboxDao commodityTypeVarietyXrefOutboxDao;
	
	private EventPublisher eventPublisher;
	
	public static final String MaximumResultsProperty = "maximum.results";

	public static final int DefaultMaximumResults = 800;

	

	public void setApplicationProperties(Properties applicationProperties) {
		this.applicationProperties = applicationProperties;
	}

	public void setModelValidator(ModelValidator modelValidator) {
		this.modelValidator = modelValidator;
	}

	public void setCodeSyncFactory(CodeSyncFactory codeSyncFactory) {
		this.codeSyncFactory = codeSyncFactory;
	}	
	
	public void setCommodityVarietySyncFactory(CommodityVarietySyncFactory commodityVarietySyncFactory) {
		this.commodityVarietySyncFactory = commodityVarietySyncFactory;
	}
	
	public void setCoveragePerilSyncFactory(CoveragePerilSyncFactory coveragePerilSyncFactory) {
		this.coveragePerilSyncFactory = coveragePerilSyncFactory;
	}
	
	public void setInsuranceClaimFactory(InsuranceClaimFactory insuranceClaimFactory) {
		this.insuranceClaimFactory = insuranceClaimFactory;
	}

	public void setClaimCalculationSubmitFactory(ClaimCalculationSubmitFactory claimCalculationSubmitFactory) {
		this.claimCalculationSubmitFactory = claimCalculationSubmitFactory;
	}

	public void setInsurancePolicyFactory(InsurancePolicyFactory insurancePolicyFactory) {
		this.insurancePolicyFactory = insurancePolicyFactory;
	}

	public void setGrowerContractYearFactory(GrowerContractYearFactory growerContractYearFactory) {
		this.growerContractYearFactory = growerContractYearFactory;
	}
	
	public void setInsuredGrowerFactory(InsuredGrowerFactory insuredGrowerFactory) {
		this.insuredGrowerFactory = insuredGrowerFactory;
	}	
	
	public void setOutboxFactory(OutboxFactory outboxFactory) {
		this.outboxFactory = outboxFactory;
	}
	
	public void setContactsFactory(ContactsFactory contactsFactory) {
		this.contactsFactory = contactsFactory;
	}
	
	public void setInsuredGrowerContactsFactory(InsuredGrowerContactsFactory insuredGrowerContactsFactory) {
		this.insuredGrowerContactsFactory = insuredGrowerContactsFactory;
	}
	
	public void setEmailsFactory(EmailsFactory emailsFactory) {
		this.emailsFactory = emailsFactory;
	}
	
	public void setTelecomFactory(TelecomFactory telecomFactory) {
		this.telecomFactory = telecomFactory;
	}

	public void setProductFactory(ProductFactory productFactory) {
		this.productFactory = productFactory;
	}	
	
	public void setCommodityTypeCodeSyncFactory(CommodityTypeCodeSyncFactory commodityTypeCodeSyncFactory) {
		this.commodityTypeCodeSyncFactory = commodityTypeCodeSyncFactory;
	}
	
	public void setClaimDao(ClaimDao claimDao) {
		this.claimDao = claimDao;
	}

	public void setClaimOutboxDao(ClaimOutboxDao claimOutboxDao) {
		this.claimOutboxDao = claimOutboxDao;
	}	
	
	public void setClaimSearchDao(ClaimSearchDao claimSearchDao) {
		this.claimSearchDao = claimSearchDao;
	}

	public void setCodeSyncDao(CodeSyncDao codeSyncDao) {
		this.codeSyncDao = codeSyncDao;
	}
	
	public void setCommodityVarietySyncDao(CommodityVarietySyncDao commodityVarietySyncDao) {
		this.commodityVarietySyncDao = commodityVarietySyncDao;
	}

	public void setCodeOutboxDao(CodeOutboxDao codeOutboxDao) {
		this.codeOutboxDao = codeOutboxDao;
	}
	
	public void setCropTypeOutboxDao(CropTypeOutboxDao cropTypeOutboxDao) {
		this.cropTypeOutboxDao = cropTypeOutboxDao;
	}
	
	public void setCoveragePerilOutboxDao(CoveragePerilOutboxDao coveragePerilOutboxDao) {
		this.coveragePerilOutboxDao = coveragePerilOutboxDao;
	}
	
	public void setCoveragePerilSyncDao(CoveragePerilSyncDao coveragePerilSyncDao) {
		this.coveragePerilSyncDao = coveragePerilSyncDao;
	}
	
	public void setGrowerDao(GrowerDao growerDao) {
		this.growerDao = growerDao;
	}

	public void setGrowerOutboxDao(GrowerOutboxDao growerOutboxDao) {
		this.growerOutboxDao = growerOutboxDao;
	}

	public void setPolicyDao(PolicyDao policyDao) {
		this.policyDao = policyDao;
	}

	public void setPolicyOutboxDao(PolicyOutboxDao policyOutboxDao) {
		this.policyOutboxDao = policyOutboxDao;
	}

	public void setGrowerContractYearDao(GrowerContractYearDao growerContractYearDao) {
		this.growerContractYearDao = growerContractYearDao;
	}

	public void setGrowerContractYearOutboxDao(GrowerContractYearOutboxDao growerContractYearOutboxDao) {
		this.growerContractYearOutboxDao = growerContractYearOutboxDao;
	}
	
	public void setVarietyDao(VarietyDao varietyDao) {
		this.varietyDao = varietyDao;
	}
	
	public void setClaimCalculationSubmitDao(ClaimCalculationSubmitDao claimCalculationSubmitDao ) {
		this.claimCalculationSubmitDao = claimCalculationSubmitDao;
	}

	public void setUserDao(UserDao userDao ) {
		this.userDao = userDao;
	}

	public void setContactsDao(ContactsDao contactsDao ) {
		this.contactsDao = contactsDao;
	}

	public void setContactsOutboxDao(ContactsOutboxDao contactsOutboxDao ) {
		this.contactsOutboxDao = contactsOutboxDao;
	}

	public void setInsuredGrowerContactsDao(InsuredGrowerContactsDao insuredGrowerContactsDao ) {
		this.insuredGrowerContactsDao = insuredGrowerContactsDao;
	}

	public void setInsuredGrowerContactsOutboxDao(InsuredGrowerContactsOutboxDao insuredGrowerContactsOutboxDao ) {
		this.insuredGrowerContactsOutboxDao = insuredGrowerContactsOutboxDao;
	}

	public void setEmailsDao(EmailsDao emailsDao ) {
		this.emailsDao = emailsDao;
	}

	public void setEmailsOutboxDao(EmailsOutboxDao emailsOutboxDao ) {
		this.emailsOutboxDao = emailsOutboxDao;
	}

	public void setTelecomDao(TelecomDao telecomDao ) {
		this.telecomDao = telecomDao;
	}

	public void setTelecomOutboxDao(TelecomOutboxDao telecomOutboxDao ) {
		this.telecomOutboxDao = telecomOutboxDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}	

	public void setProductOutboxDao(ProductOutboxDao productOutboxDao) {
		this.productOutboxDao = productOutboxDao;
	}	

	public void setCommodityTypeCodeSyncDao(CommodityTypeCodeSyncDao commodityTypeCodeSyncDao ) {
		this.commodityTypeCodeSyncDao = commodityTypeCodeSyncDao;
	}

	public void setCommodityTypeCodeOutboxDao(CommodityTypeCodeOutboxDao commodityTypeCodeOutboxDao ) {
		this.commodityTypeCodeOutboxDao = commodityTypeCodeOutboxDao;
	}	

	public void setCommodityTypeVarietyXrefOutboxDao(CommodityTypeVarietyXrefOutboxDao commodityTypeVarietyXrefOutboxDao ) {
		this.commodityTypeVarietyXrefOutboxDao = commodityTypeVarietyXrefOutboxDao;
	}
	
	public void setEventPublisher(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
	
	@Override
	public InsuranceClaim getInsuranceClaim(
		Integer claimNumber, 
		FactoryContext factoryContext, 
		WebAdeAuthentication authentication
	)
	throws ServiceException, NotFoundException {
		logger.debug("<getInsuranceClaim");
		
		InsuranceClaim result = null;

		try {
			//Get Claim Details
			ClaimDto claimDto = claimDao.selectByClaimNumber(claimNumber);
			
			if(claimDto == null) {
				throw new NotFoundException("no claim found for " + claimNumber);
			}
			
			//
			// varieties
			//
			List<VarietyDto> varietyDtos = varietyDao.select(
				claimDto.getCropYear(),
				claimDto.getContractId(),
				claimDto.getInsurancePlanId(),
				claimDto.getCropCommodityId()
			);
			
			claimDto.setVarieties(varietyDtos);
			
			result = insuranceClaimFactory.getInsuranceClaim(claimDto, true, factoryContext, authentication);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
		
		logger.debug(">getInsuranceClaim");
		return result;
	}
	
	private InsuranceClaim getBaseClaimById(
			Integer claimId, 
			Boolean createSelfLink,
			FactoryContext factoryContext, 
			WebAdeAuthentication authentication
	) throws ServiceException, NotFoundException {
		logger.debug("<getBaseClaimById");
			
		InsuranceClaim result = null;

		try {
			ClaimDto claimDto = claimDao.selectByClaimId(claimId);
				
			if(claimDto == null) {
				throw new NotFoundException("no claim found for " + claimId);
			}
				
			result = insuranceClaimFactory.getInsuranceClaim(claimDto, createSelfLink, factoryContext, authentication);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseClaimById");
		return result;
	}

	private CodeSync getBaseCodeSyncByKey(String codeTableType, String uniqueKeyString, Integer uniqueKeyInteger) throws ServiceException, NotFoundException {
		logger.debug("<getBaseCodeSyncByKey");
			
		CodeSync result = null;

		try {
			CodeSyncDto codeSyncDto = codeSyncDao.selectByKey(codeTableType, uniqueKeyString, uniqueKeyInteger);
				
			if(codeSyncDto == null) {
				throw new NotFoundException("no code found for " + codeTableType + ", " + uniqueKeyString + ", " + uniqueKeyInteger);
			}
				
			result = codeSyncFactory.getCodeSync(codeSyncDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseCodeSyncByKey");
		return result;
	}
	
	private CommodityVarietySync getBaseCommodityVarietySyncById(Integer cropId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseCommodityVarietySyncById");
			
		CommodityVarietySync result = null;

		try {
			CommodityVarietySyncDto commodityVarietySyncDto = commodityVarietySyncDao.selectByCropId(cropId);
				
			if(commodityVarietySyncDto == null) {
				throw new NotFoundException("no crop found for " + cropId);
			}
				
			result = commodityVarietySyncFactory.getCommodityVarietySync(commodityVarietySyncDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseCommodityVarietySyncById");
		return result;
	}
	
	
	private CoveragePerilSync getBaseCoveragePerilSyncById(Integer coveragePerilId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseCoveragePerilSyncById");
			
		CoveragePerilSync result = null;

		try {
			CoveragePerilSyncDto coveragePerilSyncDto = coveragePerilSyncDao.selectByCoveragePerilId(coveragePerilId);
				
			if(coveragePerilSyncDto == null) {
				throw new NotFoundException("no coverage peril found for " + coveragePerilId);
			}
				
			result = coveragePerilSyncFactory.getCoveragePerilSync(coveragePerilSyncDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseCoveragePerilSyncById");
		return result;
	}
	
	private InsuredGrower getBaseGrowerById(Integer growerId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseGrowerById");
			
		InsuredGrower result = null;

		try {
			GrowerDto growerDto = growerDao.selectByGrowerId(growerId);
				
			if(growerDto == null) {
				throw new NotFoundException("no grower found for " + growerId);
			}
				
			result = insuredGrowerFactory.getInsuredGrower(growerDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseGrowerById");
		return result;
	}

	private InsurancePolicy getBasePolicyById(Integer insurancePolicyId) throws ServiceException, NotFoundException {
		logger.debug("<getBasePolicyById");
			
		InsurancePolicy result = null;

		try {
			PolicyDto policyDto = policyDao.selectByPolicyId(insurancePolicyId);
				
			if(policyDto == null) {
				throw new NotFoundException("no policy found for " + insurancePolicyId);
			}
				
			result = insurancePolicyFactory.getInsurancePolicy(policyDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBasePolicyById");
		return result;
	}

	private GrowerContractYear getBaseGrowerContractYearById(Integer growerContractYearId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseGrowerContractYearById");
			
		GrowerContractYear result = null;

		try {
			GrowerContractYearDto growerContractYearDto = growerContractYearDao.selectByGrowerContractYearId(growerContractYearId);
				
			if(growerContractYearDto == null) {
				throw new NotFoundException("no Grower Contract Year found for " + growerContractYearId);
			}
				
			result = growerContractYearFactory.getGrowerContractYear(growerContractYearDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseGrowerContractYearById");
		return result;
	}
	
	
	private Contacts getBaseContactsById(Integer contactsId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseContactsById");
			
		Contacts result = null;

		try {
			ContactsDto contactsDto = contactsDao.selectByContactsId(contactsId);
				
			if(contactsDto == null) {
				throw new NotFoundException("no contact found for " + contactsId);
			}
				
			result = contactsFactory.getContacts(contactsDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseContactsById");
		return result;
	}
	
	private InsuredGrowerContacts getBaseInsuredGrowerContactsById(Integer insuredGrowerContactsId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseInsuredGrowerContactsById");
			
		InsuredGrowerContacts result = null;

		try {
			InsuredGrowerContactsDto insuredGrowerContactsDto = insuredGrowerContactsDao.selectByGrowerContactsId(insuredGrowerContactsId);
				
			if(insuredGrowerContactsDto == null) {
				throw new NotFoundException("no grower contact found for " + insuredGrowerContactsId);
			}
				
			result = insuredGrowerContactsFactory.getInsuredGrowerContacts(insuredGrowerContactsDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseInsuredGrowerContactsById");
		return result;
	}

	private Emails getBaseEmailsById(Integer emailsId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseEmailsById");
			
		Emails result = null;

		try {
			EmailsDto emailsDto = emailsDao.selectByEmailsId(emailsId);
				
			if(emailsDto == null) {
				throw new NotFoundException("no email found for " + emailsId);
			}
				
			result = emailsFactory.getEmails(emailsDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseEmailsById");
		return result;
	}

	private Telecom getBaseTelecomById(Integer telecomId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseTelecomById");
			
		Telecom result = null;

		try {
			TelecomDto telecomDto = telecomDao.selectByTelecomId(telecomId);
				
			if(telecomDto == null) {
				throw new NotFoundException("no phone found for " + telecomId);
			}
				
			result = telecomFactory.getTelecom(telecomDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseTelecomById");
		return result;
	}	

	private CommodityTypeCodeSync getBaseCommodityTypeCodeSyncByKey(String commodityTypeCode) throws ServiceException, NotFoundException {
		logger.debug("<getBaseCommodityTypeCodeSyncByKey");
			
		CommodityTypeCodeSync result = null;

		try {
			CommodityTypeCodeSyncDto commodityTypeCodeSyncDto = commodityTypeCodeSyncDao.selectByCommodityTypeCode(commodityTypeCode);
				
			if(commodityTypeCodeSyncDto == null) {
				throw new NotFoundException("no commodity type code found for " + commodityTypeCode);
			}
				
			result = commodityTypeCodeSyncFactory.getCommodityTypeCodeSync(commodityTypeCodeSyncDto);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseCommodityTypeCodeSyncByKey");
		return result;
	}

	private Product getBaseProductById(Integer productId) throws ServiceException, NotFoundException {
		logger.debug("<getBaseProductById");
			
		Product result = null;

		try {
			ProductDto productDto = productDao.selectByProductId(productId);
			
			//It's possible that productDto is null. Not all purchases are synchronized.
			//Only Grain and Forage Quantity and Grain Basket are included
			if(productDto != null) {
				result = productFactory.getProduct(productDto);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
			
		logger.debug(">getBaseProductById");
		return result;
	}
	
	
	@Override
	public InsuranceClaimList<? extends InsuranceClaim> getClaims(
			Integer claimNumber,
			String policyNumber,
			FactoryContext context, 
			WebAdeAuthentication authentication
		) 
		throws ServiceException, MaxResultsExceededException {

		InsuranceClaimList<? extends InsuranceClaim> results = null;
	
		try {
			int maximumRows = DefaultMaximumResults;

			List<ClaimSearchDto> dtos = claimSearchDao.searchClaims(
					claimNumber, 
					policyNumber);
			
			results = insuranceClaimFactory.getClaimCalculationList(
					dtos, 
					claimNumber, 
					policyNumber,
					context,
					authentication);
			
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
		
		return results;
	}

	@Override
	public ProductList<? extends Product> getProducts(
			Integer insurancePolicyId,
			Boolean includeProductDetails, 
			Integer productId, 
			String commodityCoverageCode,
			FactoryContext context,
			WebAdeAuthentication authentication) throws ServiceException, MaxResultsExceededException {

		if ( insurancePolicyId == null ) {
			throw new ServiceException("insurancePolicyId is required");
		}
		
		if ( !Boolean.TRUE.equals(includeProductDetails) ) {
			if ( productId != null || commodityCoverageCode != null ) {
				throw new ServiceException("productId and commodityCoverageCode parameters only allowed if includeProductDetails is true");
			}
		}
		
		ProductList<? extends Product> results = null;
		
		try {
			List<ProductDto> dtos = null;

			if ( Boolean.TRUE.equals(includeProductDetails) ) {
				dtos = productDao.selectProductsDetailsByPolicyId(insurancePolicyId, productId, commodityCoverageCode);
			} else {
				dtos = productDao.selectByPolicyId(insurancePolicyId);	
			}

			results = productFactory.getProductList(
					dtos, 
					insurancePolicyId, 
					includeProductDetails,
					productId,
					commodityCoverageCode,
					context,
					authentication);
			
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
		
		return results;
	}
	
	@Override
	public void submitClaimCalculation(
			ClaimCalculationSubmit resource, 
			FactoryContext factoryContext, 
			WebAdeAuthentication authentication
		) throws DaoException, ValidationFailureException {


		//Get user information and clam data from CIRRAS
		UserDto userDto = userDao.getUser(resource.getUserId());
		ClaimCalculationSubmitDto dto = claimCalculationSubmitDao.getClaim(resource.getClaimNumber());
		
		List<Message> errors = new ArrayList<Message>();
		//Validate data
		errors.addAll(modelValidator.validateSubmitClaimCalculation(resource, userDto, dto));

		//Throw error if there is any
		if (!errors.isEmpty()) {
			throw new ValidationFailureException(errors);
		}
		
		//Update dto
		claimCalculationSubmitFactory.updateClaimDto(dto, userDto, resource);
		
		//Save data
		claimCalculationSubmitDao.updateClaimAndPayments(dto);
		
	}
	

	@Override
	public List<ClaimOutbox> getNextClaimOutboxes(
			Integer maxRecords, 
			WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextClaimOutboxes");

		List<ClaimOutbox> results = null;

		try {
			List<ClaimOutboxDto> dtos = claimOutboxDao.select(maxRecords);
			results = outboxFactory.getClaimOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextClaimOutboxes");
		
		return results;
	}

	@Override
	public void processClaimOutbox(
		ClaimOutbox claimOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processClaimOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				InsuranceClaim beforeClaim = null;
				InsuranceClaim afterClaim = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( claimOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.ClaimCreated;
					afterClaim = getBaseClaimById(claimOutbox.getClaimId(), false, null, authentication);
					sourceIdentifiers.put("claimId", afterClaim.getClaimId().toString());
						
				} else if (claimOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.ClaimUpdated;
					afterClaim = getBaseClaimById(claimOutbox.getClaimId(), false, null, authentication);
					sourceIdentifiers.put("claimId", afterClaim.getClaimId().toString());
						
				} else if (claimOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.ClaimDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("claimId", claimOutbox.getClaimId().toString());
						
				} else { 
					throw new ServiceException("Claim Outbox returned invalid transaction type");
				}

				// Delete Claim Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				claimOutboxDao.delete(claimOutbox.getClaimOutboxId());
				eventPublisher.publish(eventType, beforeClaim, afterClaim, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				claimOutboxDao.delete(claimOutbox.getClaimOutboxId());				
			}

		} catch (NotFoundException e) {
			// If claimId does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for claimId " + claimOutbox.getClaimId() + " as it no longer exists.");
			try { 
				claimOutboxDao.delete(claimOutbox.getClaimOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processClaimOutbox");
	}
	
	@Override
	public List<GrowerOutbox> getNextGrowerOutboxes(
			Integer maxRecords, 
			WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextGrowerOutboxes");

		List<GrowerOutbox> results = null;

		try {
			List<GrowerOutboxDto> dtos = growerOutboxDao.select(maxRecords);
			results = outboxFactory.getGrowerOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextGrowerOutboxes");
		
		return results;
	}

	@Override
	public void processGrowerOutbox(
		GrowerOutbox growerOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processGrowerOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				InsuredGrower beforeGrower = null;
				InsuredGrower afterGrower = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( growerOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.GrowerCreated;
					afterGrower = getBaseGrowerById(growerOutbox.getGrowerId());
					sourceIdentifiers.put("growerId", afterGrower.getGrowerId().toString());
						
				} else if (growerOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.GrowerUpdated;
					afterGrower = getBaseGrowerById(growerOutbox.getGrowerId());
					sourceIdentifiers.put("growerId", afterGrower.getGrowerId().toString());
						
				} else if (growerOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.GrowerDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("growerId", growerOutbox.getGrowerId().toString());
						
				} else { 
					throw new ServiceException("Grower Outbox returned invalid transaction type");
				}

				// Delete Grower Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				growerOutboxDao.delete(growerOutbox.getGrowerOutboxId());
				eventPublisher.publish(eventType, beforeGrower, afterGrower, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				growerOutboxDao.delete(growerOutbox.getGrowerOutboxId());
			}

		} catch (NotFoundException e) {
			// If growerId does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for growerId " + growerOutbox.getGrowerId() + " as it no longer exists.");
			try { 
				growerOutboxDao.delete(growerOutbox.getGrowerOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processGrowerOutbox");
	}

	@Override
	public List<PolicyOutbox> getNextPolicyOutboxes(
			Integer maxRecords, 
			WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextPolicyOutboxes");

		List<PolicyOutbox> results = null;

		try {
			List<PolicyOutboxDto> dtos = policyOutboxDao.select(maxRecords);
			results = outboxFactory.getPolicyOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextPolicyOutboxes");
		
		return results;
	}

	@Override
	public void processPolicyOutbox(
		PolicyOutbox policyOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processPolicyOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				InsurancePolicy beforePolicy = null;
				InsurancePolicy afterPolicy = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( policyOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.PolicyCreated;
					afterPolicy = getBasePolicyById(policyOutbox.getInsurancePolicyId());
					sourceIdentifiers.put("insurancePolicyId", afterPolicy.getInsurancePolicyId().toString());
						
				} else if (policyOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.PolicyUpdated;
					afterPolicy = getBasePolicyById(policyOutbox.getInsurancePolicyId());
					sourceIdentifiers.put("insurancePolicyId", afterPolicy.getInsurancePolicyId().toString());
						
				} else if (policyOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.PolicyDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("insurancePolicyId", policyOutbox.getInsurancePolicyId().toString());
						
				} else { 
					throw new ServiceException("Policy Outbox returned invalid transaction type");
				}

				// Delete Policy Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				policyOutboxDao.delete(policyOutbox.getPolicyOutboxId());
				eventPublisher.publish(eventType, beforePolicy, afterPolicy, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				policyOutboxDao.delete(policyOutbox.getPolicyOutboxId());
			}

		} catch (NotFoundException e) {
			// If insurancePolicyId does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for insurancePolicyId " + policyOutbox.getInsurancePolicyId() + " as it no longer exists.");
			try { 
				policyOutboxDao.delete(policyOutbox.getPolicyOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processPolicyOutbox");
	}

	@Override
	public List<GrowerContractYearOutbox> getNextGrowerContractYearOutboxes(
			Integer maxRecords, 
			WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextGrowerContractYearOutboxes");

		List<GrowerContractYearOutbox> results = null;

		try {
			List<GrowerContractYearOutboxDto> dtos = growerContractYearOutboxDao.select(maxRecords);
			results = outboxFactory.getGrowerContractYearOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextGrowerContractYearOutboxes");
		
		return results;
	}

	@Override
	public void processGrowerContractYearOutbox(
		GrowerContractYearOutbox growerContractYearOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processGrowerContractYearOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				GrowerContractYear beforeGrowerContractYear = null;
				GrowerContractYear afterGrowerContractYear = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( growerContractYearOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.GrowerContractYearCreated;
					afterGrowerContractYear = getBaseGrowerContractYearById(growerContractYearOutbox.getGrowerContractYearId());
					sourceIdentifiers.put("growerContractYearId", afterGrowerContractYear.getGrowerContractYearId().toString());
						
				} else if (growerContractYearOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.GrowerContractYearUpdated;
					afterGrowerContractYear = getBaseGrowerContractYearById(growerContractYearOutbox.getGrowerContractYearId());
					sourceIdentifiers.put("growerContractYearId", afterGrowerContractYear.getGrowerContractYearId().toString());
						
				} else if (growerContractYearOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.GrowerContractYearDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("growerContractYearId", growerContractYearOutbox.getGrowerContractYearId().toString());
						
				} else { 
					throw new ServiceException("Grower Contract Year Outbox returned invalid transaction type");
				}

				// Delete Annual Lot Detail Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				growerContractYearOutboxDao.delete(growerContractYearOutbox.getGrowerContractYearOutboxId());
				eventPublisher.publish(eventType, beforeGrowerContractYear, afterGrowerContractYear, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				growerContractYearOutboxDao.delete(growerContractYearOutbox.getGrowerContractYearOutboxId());
			}

		} catch (NotFoundException e) {
			// If growerContractYear does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for growerContractYearId " + growerContractYearOutbox.getGrowerContractYearId() + " as it no longer exists.");
			try { 
				growerContractYearOutboxDao.delete(growerContractYearOutbox.getGrowerContractYearOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processGrowerContractYearOutbox");
	}
	
	@Override
	public List<CropTypeOutbox> getNextCropTypeOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextCropTypeOutboxes");

		List<CropTypeOutbox> results = null;

		try {
			List<CropTypeOutboxDto> dtos = cropTypeOutboxDao.select(maxRecords);
			results = outboxFactory.getCropTypeOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextCropTypeOutboxes");
		
		return results;
	}
	
	@Override
	public void processCropTypeOutbox(
		CropTypeOutbox cropTypeOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processCropTypeOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				CommodityVarietySync beforeCommodityVarietySync = null;
				CommodityVarietySync afterCommodityVarietySync = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( cropTypeOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.CommodityVarietyCreated;
					afterCommodityVarietySync = getBaseCommodityVarietySyncById(cropTypeOutbox.getCropId());
					sourceIdentifiers.put("cropId", afterCommodityVarietySync.getCropId().toString());
						
				} else if (cropTypeOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.CommodityVarietyUpdated;
					afterCommodityVarietySync = getBaseCommodityVarietySyncById(cropTypeOutbox.getCropId());
					sourceIdentifiers.put("cropId", afterCommodityVarietySync.getCropId().toString());
						
				} else if (cropTypeOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.CommodityVarietyDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("cropId", cropTypeOutbox.getCropId().toString());
						
				} else { 
					throw new ServiceException("Crop Type Outbox returned invalid transaction type");
				}

				// Delete Crop Type Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				cropTypeOutboxDao.delete(cropTypeOutbox.getCropTypeOutboxId());
				eventPublisher.publish(eventType, beforeCommodityVarietySync, afterCommodityVarietySync, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				cropTypeOutboxDao.delete(cropTypeOutbox.getCropTypeOutboxId());
			}

		} catch (NotFoundException e) {
			// If cropId does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for cropId " + cropTypeOutbox.getCropId() + " as it no longer exists.");
			try { 
				cropTypeOutboxDao.delete(cropTypeOutbox.getCropTypeOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processCropTypeOutbox");
	}
	
	@Override
	public List<CoveragePerilOutbox> getNextCoveragePerilOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextCoveragePerilOutboxes");

		List<CoveragePerilOutbox> results = null;

		try {
			List<CoveragePerilOutboxDto> dtos = coveragePerilOutboxDao.select(maxRecords);
			results = outboxFactory.getCoveragePerilOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextCoveragePerilOutboxes");
		
		return results;
	}
	
	@Override
	public void processCoveragePerilOutbox(
		CoveragePerilOutbox coveragePerilOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processCoveragePerilOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				CoveragePerilSync beforeCoveragePerilSync = null;
				CoveragePerilSync afterCoveragePerilSync = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( coveragePerilOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.CoveragePerilCreated;
					afterCoveragePerilSync = getBaseCoveragePerilSyncById(coveragePerilOutbox.getCoveragePerilId());

					sourceIdentifiers.put("coveragePerilId", afterCoveragePerilSync.getCoveragePerilId().toString());
						
				} else if (coveragePerilOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.CoveragePerilUpdated;
					afterCoveragePerilSync = getBaseCoveragePerilSyncById(coveragePerilOutbox.getCoveragePerilId());
					sourceIdentifiers.put("coveragePerilId", afterCoveragePerilSync.getCoveragePerilId().toString());
						
				} else if (coveragePerilOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.CoveragePerilDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("coveragePerilId", coveragePerilOutbox.getCoveragePerilId().toString());
						
				} else { 
					throw new ServiceException("Crop Type Outbox returned invalid transaction type");
				}

				// Delete Crop Type Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				coveragePerilOutboxDao.delete(coveragePerilOutbox.getCoveragePerilOutboxId());
				eventPublisher.publish(eventType, beforeCoveragePerilSync, afterCoveragePerilSync, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				coveragePerilOutboxDao.delete(coveragePerilOutbox.getCoveragePerilOutboxId());
			}

		} catch (NotFoundException e) {
			// If cropId does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for coveragePerilId " + coveragePerilOutbox.getCoveragePerilId() + " as it no longer exists.");
			try { 
				coveragePerilOutboxDao.delete(coveragePerilOutbox.getCoveragePerilOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processCoveragePerilOutbox");
	}	
	
	@Override
	public List<ContactsOutbox> getNextContactsOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextContactsOutboxes");

		List<ContactsOutbox> results = null;

		try {
			List<ContactsOutboxDto> dtos = contactsOutboxDao.select(maxRecords);
			results = outboxFactory.getContactsOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextContactsOutboxes");
		
		return results;
	}
	
	@Override
	public void processContactsOutbox(
		ContactsOutbox contactsOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processContactsOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				Contacts beforeContacts = null;
				Contacts afterContacts = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( contactsOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.ContactsCreated;
					afterContacts = getBaseContactsById(contactsOutbox.getContactsId());

					sourceIdentifiers.put("contactsId", afterContacts.getContactsId().toString());
						
				} else if (contactsOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.ContactsUpdated;
					afterContacts = getBaseContactsById(contactsOutbox.getContactsId());
					sourceIdentifiers.put("contactsId", afterContacts.getContactsId().toString());
						
				} else if (contactsOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.ContactsDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("contactsId", contactsOutbox.getContactsId().toString());
						
				} else { 
					throw new ServiceException("Contacts Outbox returned invalid transaction type");
				}

				// Delete Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				contactsOutboxDao.delete(contactsOutbox.getContactsOutboxId());
				eventPublisher.publish(eventType, beforeContacts, afterContacts, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				contactsOutboxDao.delete(contactsOutbox.getContactsOutboxId());
			}

		} catch (NotFoundException e) {
			// If Id does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for contactsId " + contactsOutbox.getContactsId() + " as it no longer exists.");
			try { 
				contactsOutboxDao.delete(contactsOutbox.getContactsOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processContactsOutbox");
	}	

	@Override
	public List<InsuredGrowerContactsOutbox> getNextInsuredGrowerContactsOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextInsuredGrowerContactsOutboxes");

		List<InsuredGrowerContactsOutbox> results = null;

		try {
			List<InsuredGrowerContactsOutboxDto> dtos = insuredGrowerContactsOutboxDao.select(maxRecords);
			results = outboxFactory.getInsuredGrowerContactsOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextInsuredGrowerContactsOutboxes");
		
		return results;
	}
	
	@Override
	public void processInsuredGrowerContactsOutbox(
		InsuredGrowerContactsOutbox insuredGrowerContactsOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processInsuredGrowerContactsOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				InsuredGrowerContacts beforeInsuredGrowerContacts = null;
				InsuredGrowerContacts afterInsuredGrowerContacts = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( insuredGrowerContactsOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.InsuredGrowerContactsCreated;
					afterInsuredGrowerContacts = getBaseInsuredGrowerContactsById(insuredGrowerContactsOutbox.getInsuredGrowerContactsId());

					sourceIdentifiers.put("insuredGrowerContactsId", afterInsuredGrowerContacts.getGrowerContactsId().toString());
						
				} else if (insuredGrowerContactsOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.InsuredGrowerContactsUpdated;
					afterInsuredGrowerContacts = getBaseInsuredGrowerContactsById(insuredGrowerContactsOutbox.getInsuredGrowerContactsId());
					sourceIdentifiers.put("insuredGrowerContactsId", afterInsuredGrowerContacts.getGrowerContactsId().toString());
						
				} else if (insuredGrowerContactsOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.InsuredGrowerContactsDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("insuredGrowerContactsId", insuredGrowerContactsOutbox.getInsuredGrowerContactsId().toString());
						
				} else { 
					throw new ServiceException("InsuredGrowerContacts Outbox returned invalid transaction type");
				}

				// Delete Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				insuredGrowerContactsOutboxDao.delete(insuredGrowerContactsOutbox.getInsuredGrowerContactsOutboxId());
				eventPublisher.publish(eventType, beforeInsuredGrowerContacts, afterInsuredGrowerContacts, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				insuredGrowerContactsOutboxDao.delete(insuredGrowerContactsOutbox.getInsuredGrowerContactsOutboxId());
			}

		} catch (NotFoundException e) {
			// If Id does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for insuredGrowerContactsId " + insuredGrowerContactsOutbox.getInsuredGrowerContactsId() + " as it no longer exists.");
			try { 
				insuredGrowerContactsOutboxDao.delete(insuredGrowerContactsOutbox.getInsuredGrowerContactsOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processInsuredGrowerContactsOutbox");
	}	

	@Override
	public List<EmailsOutbox> getNextEmailsOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextEmailsOutboxes");

		List<EmailsOutbox> results = null;

		try {
			List<EmailsOutboxDto> dtos = emailsOutboxDao.select(maxRecords);
			results = outboxFactory.getEmailsOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextEmailsOutboxes");
		
		return results;
	}
	
	@Override
	public void processEmailsOutbox(
		EmailsOutbox emailsOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processEmailsOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				Emails beforeEmails = null;
				Emails afterEmails = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( emailsOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.EmailsCreated;
					afterEmails = getBaseEmailsById(emailsOutbox.getEmailsId());

					sourceIdentifiers.put("emailsId", afterEmails.getEmailsId().toString());
						
				} else if (emailsOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.EmailsUpdated;
					afterEmails = getBaseEmailsById(emailsOutbox.getEmailsId());
					sourceIdentifiers.put("emailsId", afterEmails.getEmailsId().toString());
						
				} else if (emailsOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.EmailsDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("emailsId", emailsOutbox.getEmailsId().toString());
						
				} else { 
					throw new ServiceException("Emails Outbox returned invalid transaction type");
				}

				// Delete Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				emailsOutboxDao.delete(emailsOutbox.getEmailsOutboxId());
				eventPublisher.publish(eventType, beforeEmails, afterEmails, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				emailsOutboxDao.delete(emailsOutbox.getEmailsOutboxId());
			}

		} catch (NotFoundException e) {
			// If Id does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for emailsId " + emailsOutbox.getEmailsId() + " as it no longer exists.");
			try { 
				emailsOutboxDao.delete(emailsOutbox.getEmailsOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processEmailsOutbox");
	}	

	@Override
	public List<TelecomOutbox> getNextTelecomOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextTelecomOutboxes");

		List<TelecomOutbox> results = null;

		try {
			List<TelecomOutboxDto> dtos = telecomOutboxDao.select(maxRecords);
			results = outboxFactory.getTelecomOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextTelecomOutboxes");
		
		return results;
	}
	
	@Override
	public void processTelecomOutbox(
		TelecomOutbox telecomOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processTelecomOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				Telecom beforeTelecom = null;
				Telecom afterTelecom = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( telecomOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.TelecomCreated;
					afterTelecom = getBaseTelecomById(telecomOutbox.getTelecomId());

					sourceIdentifiers.put("telecomId", afterTelecom.getTelecomId().toString());
						
				} else if (telecomOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.TelecomUpdated;
					afterTelecom = getBaseTelecomById(telecomOutbox.getTelecomId());
					sourceIdentifiers.put("telecomId", afterTelecom.getTelecomId().toString());
						
				} else if (telecomOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.TelecomDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("telecomId", telecomOutbox.getTelecomId().toString());
						
				} else { 
					throw new ServiceException("Telecom Outbox returned invalid transaction type");
				}

				// Delete Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				telecomOutboxDao.delete(telecomOutbox.getTelecomOutboxId());
				eventPublisher.publish(eventType, beforeTelecom, afterTelecom, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				telecomOutboxDao.delete(telecomOutbox.getTelecomOutboxId());
			}

		} catch (NotFoundException e) {
			// If Id does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for telecomId " + telecomOutbox.getTelecomId() + " as it no longer exists.");
			try { 
				telecomOutboxDao.delete(telecomOutbox.getTelecomOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processTelecomOutbox");
	}


	@Override
	public List<ProductOutbox> getNextProductOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextProductOutboxes");

		List<ProductOutbox> results = null;

		try {
			List<ProductOutboxDto> dtos = productOutboxDao.select(maxRecords);
			results = outboxFactory.getProductOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextProductOutboxes");
		
		return results;
	}
	
	@Override
	public void processProductOutbox(
		ProductOutbox productOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processProductOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				Product beforeProduct = null;
				Product afterProduct = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( productOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.ProductCreated;
					afterProduct = getBaseProductById(productOutbox.getProductId());

					if(afterProduct != null) {
						sourceIdentifiers.put("productId", afterProduct.getProductId().toString());
					}
						
				} else if (productOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.ProductUpdated;
					afterProduct = getBaseProductById(productOutbox.getProductId());
					if(afterProduct != null) {
						sourceIdentifiers.put("productId", afterProduct.getProductId().toString());
					}
						
				} else if (productOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.ProductDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("productId", productOutbox.getProductId().toString());
						
				} else { 
					throw new ServiceException("Product Outbox returned invalid transaction type");
				}

				// Delete Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				productOutboxDao.delete(productOutbox.getProductOutboxId());
				//Only push to queue if a valid product has been added
				if(sourceIdentifiers != null && sourceIdentifiers.isEmpty() == false) {
					eventPublisher.publish(eventType, beforeProduct, afterProduct, sourceIdentifiers);
				}
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				productOutboxDao.delete(productOutbox.getProductOutboxId());
			}

		} catch (NotFoundException e) {
			// If Id does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for productId " + productOutbox.getProductId() + " as it no longer exists.");
			try { 
				productOutboxDao.delete(productOutbox.getProductOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processProductOutbox");
	}	
	
	@Override
	public List<CodeOutbox> getNextCodeOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextCodeOutboxes");

		List<CodeOutbox> results = null;

		try {
			List<CodeOutboxDto> dtos = codeOutboxDao.select(maxRecords);
			results = outboxFactory.getCodeOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextCodeOutboxes");
		
		return results;
	}
	
	@Override
	public void processCodeOutbox(
		CodeOutbox codeOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processCodeOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				CodeSync beforeCodeSync = null;
				CodeSync afterCodeSync = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( codeOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.CodeCreated;
					afterCodeSync = getBaseCodeSyncByKey(codeOutbox.getCodeTableType(), codeOutbox.getUniqueKeyString(), codeOutbox.getUniqueKeyInteger());
					sourceIdentifiers.put("codeTableType", afterCodeSync.getCodeTableType());
					sourceIdentifiers.put("uniqueKeyString", afterCodeSync.getUniqueKeyString());
					sourceIdentifiers.put("uniqueKeyInteger", (afterCodeSync.getUniqueKeyInteger() != null ? afterCodeSync.getUniqueKeyInteger().toString() : null));
						
				} else if (codeOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.CodeUpdated;
					afterCodeSync = getBaseCodeSyncByKey(codeOutbox.getCodeTableType(), codeOutbox.getUniqueKeyString(), codeOutbox.getUniqueKeyInteger());
					sourceIdentifiers.put("codeTableType", afterCodeSync.getCodeTableType());
					sourceIdentifiers.put("uniqueKeyString", afterCodeSync.getUniqueKeyString());
					sourceIdentifiers.put("uniqueKeyInteger", (afterCodeSync.getUniqueKeyInteger() != null ? afterCodeSync.getUniqueKeyInteger().toString() : null));
						
				} else if (codeOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.CodeDeleted;

					// Include the resource because it has a composite key and simplifies Claims Listener impl.
					// But since the delete has already happened, resource only contains key fields.
					CodeSyncDto codeSyncDto = new CodeSyncDto();
					codeSyncDto.setCodeTableType(codeOutbox.getCodeTableType());
					codeSyncDto.setUniqueKeyString(codeOutbox.getUniqueKeyString());
					codeSyncDto.setUniqueKeyInteger(codeOutbox.getUniqueKeyInteger());
					beforeCodeSync = codeSyncFactory.getCodeSync(codeSyncDto);
					
					sourceIdentifiers.put("codeTableType", beforeCodeSync.getCodeTableType());
					sourceIdentifiers.put("uniqueKeyString", beforeCodeSync.getUniqueKeyString());
					sourceIdentifiers.put("uniqueKeyInteger", (beforeCodeSync.getUniqueKeyInteger() != null ? beforeCodeSync.getUniqueKeyInteger().toString() : null));
						
				} else { 
					throw new ServiceException("Code Outbox returned invalid transaction type");
				}

				// Delete Code Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				codeOutboxDao.delete(codeOutbox.getCodeTableType(), codeOutbox.getCodeOutboxId());
				eventPublisher.publish(eventType, beforeCodeSync, afterCodeSync, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				codeOutboxDao.delete(codeOutbox.getCodeTableType(), codeOutbox.getCodeOutboxId());
			}

		} catch (NotFoundException e) {
			// If code does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			String codeKeyMsg = codeOutbox.getCodeTableType();
			if (codeOutbox.getUniqueKeyString() != null)
			{
				codeKeyMsg = codeKeyMsg + ", uniqueKeyStr " + codeOutbox.getUniqueKeyString();
			}
			else if (codeOutbox.getUniqueKeyInteger() != null)
			{
				codeKeyMsg = codeKeyMsg + ", uniqueKeyInt " + codeOutbox.getUniqueKeyInteger().toString();
			}
			
			logger.info("Skipped insert/update event for code table " + codeKeyMsg + " as it no longer exists.");

			try { 
				codeOutboxDao.delete(codeOutbox.getCodeTableType(), codeOutbox.getCodeOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processCodeOutbox");
	}

	@Override
	public List<CommodityTypeCodeOutbox> getNextCommodityTypeCodeOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextCommodityTypeCodeOutboxes");

		List<CommodityTypeCodeOutbox> results = null;

		try {
			List<CommodityTypeCodeOutboxDto> dtos = commodityTypeCodeOutboxDao.select(maxRecords);
			results = outboxFactory.getCommodityTypeCodeOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextCommodityTypeCodeOutboxes");
		
		return results;
	}
	
	@Override
	public void processCommodityTypeCodeOutbox(
		CommodityTypeCodeOutbox commodityTypeCodeOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processCommodityTypeCodeOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				CommodityTypeCodeSync beforeCommodityTypeCodeSync = null;
				CommodityTypeCodeSync afterCommodityTypeCodeSync = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( commodityTypeCodeOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.CommodityTypeCodeCreated;
					afterCommodityTypeCodeSync = getBaseCommodityTypeCodeSyncByKey(commodityTypeCodeOutbox.getCommodityTypeCode());

					sourceIdentifiers.put("commodityTypeCode", afterCommodityTypeCodeSync.getCommodityTypeCode());
						
				} else if (commodityTypeCodeOutbox.getTransactionType().equals(OutboxTransactionTypes.Updated) ) {
					eventType = PoliciesEventTypes.CommodityTypeCodeUpdated;
					afterCommodityTypeCodeSync = getBaseCommodityTypeCodeSyncByKey(commodityTypeCodeOutbox.getCommodityTypeCode());
					sourceIdentifiers.put("commodityTypeCode", afterCommodityTypeCodeSync.getCommodityTypeCode());
						
				} else if (commodityTypeCodeOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.CommodityTypeCodeDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("commodityTypeCode", commodityTypeCodeOutbox.getCommodityTypeCode());
						
				} else { 
					throw new ServiceException("CommodityTypeCode Outbox returned invalid transaction type");
				}

				// Delete Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				commodityTypeCodeOutboxDao.delete(commodityTypeCodeOutbox.getCommodityTypeCodeOutboxId());
				eventPublisher.publish(eventType, beforeCommodityTypeCodeSync, afterCommodityTypeCodeSync, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				commodityTypeCodeOutboxDao.delete(commodityTypeCodeOutbox.getCommodityTypeCodeOutboxId());
			}

		} catch (NotFoundException e) {
			// If code does not exist, then there must be a delete event that will be processed later.
			// So we can ignore this insert/update event and just delete the outbox record.
			logger.info("Skipped insert/update event for commodityTypeCode " + commodityTypeCodeOutbox.getCommodityTypeCode() + " as it no longer exists.");
			try { 
				commodityTypeCodeOutboxDao.delete(commodityTypeCodeOutbox.getCommodityTypeCodeOutboxId());
			} catch (DaoException e2) { 
				throw new ServiceException("DAO threw an exception", e2);
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processCommodityTypeCodeOutbox");
	}	
	
	@Override
	public List<CommodityTypeVarietyXrefOutbox> getNextCommodityTypeVarietyXrefOutboxes(
		Integer maxRecords, 
		WebAdeAuthentication authentication
	) throws ServiceException
	{
		logger.debug("<getNextCommodityTypeVarietyXrefOutboxes");

		List<CommodityTypeVarietyXrefOutbox> results = null;

		try {
			List<CommodityTypeVarietyXrefOutboxDto> dtos = commodityTypeVarietyXrefOutboxDao.select(maxRecords);
			results = outboxFactory.getCommodityTypeVarietyXrefOutboxList(dtos);
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}

		logger.debug(">getNextCommodityTypeVarietyXrefOutboxes");
		
		return results;
	}
	
	@Override
	public void processCommodityTypeVarietyXrefOutbox(
		CommodityTypeVarietyXrefOutbox commodityTypeVarietyXrefOutbox,
		Boolean doPublishEvent,
		WebAdeAuthentication authentication
	) 
	throws ServiceException
	{
		logger.debug("<processCommodityTypeVarietyXrefOutbox");

		try {

			if ( doPublishEvent.booleanValue() ) { 
				String eventType = null;
				Map<String, String> sourceIdentifiers = new HashMap<>();
					
				if ( commodityTypeVarietyXrefOutbox.getTransactionType().equals(OutboxTransactionTypes.Inserted) ) {
					eventType = PoliciesEventTypes.CommodityTypeVarietyXrefCreated;

					// No resource included as the only data is commodityTypeCode and varietyId which are the primary key.
					sourceIdentifiers.put("commodityTypeCode", commodityTypeVarietyXrefOutbox.getCommodityTypeCode());
					sourceIdentifiers.put("varietyId", commodityTypeVarietyXrefOutbox.getVarietyId().toString());
						
				} else if (commodityTypeVarietyXrefOutbox.getTransactionType().equals(OutboxTransactionTypes.Deleted) ) {
					eventType = PoliciesEventTypes.CommodityTypeVarietyXrefDeleted;

					// Since the delete has already happened, no resource is included in the event.
					sourceIdentifiers.put("commodityTypeCode", commodityTypeVarietyXrefOutbox.getCommodityTypeCode());
					sourceIdentifiers.put("varietyId", commodityTypeVarietyXrefOutbox.getVarietyId().toString());
						
				} else { 
					// Note that Updated event is not supported and should never occur for this outbox.
					throw new ServiceException("CommodityTypeVarietyXref Outbox returned invalid transaction type");
				}

				// Delete Outbox before publishing event. If the publish fails, the exception 
				// rolls back the delete.
				commodityTypeVarietyXrefOutboxDao.delete(commodityTypeVarietyXrefOutbox.getCommodityTypeVarietyXrefOutboxId());
				eventPublisher.publish(eventType, null, null, sourceIdentifiers);
			} else {
				// Not publishing an event because it would be a duplicate, so just delete the outbox record.
				commodityTypeVarietyXrefOutboxDao.delete(commodityTypeVarietyXrefOutbox.getCommodityTypeVarietyXrefOutboxId());
			}

		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		} catch (EventPublisherException e) {
			throw new ServiceException("Event Publisher threw an exception", e);
		}
		
		logger.debug(">processCommodityTypeVarietyXrefOutbox");
	}
	
}
