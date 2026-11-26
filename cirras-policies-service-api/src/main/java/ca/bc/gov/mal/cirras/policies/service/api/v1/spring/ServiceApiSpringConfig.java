package ca.bc.gov.mal.cirras.policies.service.api.v1.spring;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.service.api.v1.impl.CirrasPolicyServiceImpl;
import ca.bc.gov.mal.cirras.policies.service.api.v1.validation.ModelValidator;
import ca.bc.gov.mal.cirras.policies.service.api.v1.EventPublisher;
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
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.OutboxFactoryImpl;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.ProductFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.TelecomFactory;

@Configuration
@Import({
	CodeHierarchySpringConfig.class,  // can't remove this because some library stuff depends on it
	CodeTableSpringConfig.class, 
	PersistenceSpringConfig.class
})
public class ServiceApiSpringConfig {

	private static final Logger logger = LoggerFactory.getLogger(ServiceApiSpringConfig.class);

	public ServiceApiSpringConfig() {
		logger.debug("<ServiceApiSpringConfig");
		
		logger.debug(">ServiceApiSpringConfig");
	}

	// Beans provided by EndpointsSpringConfig
	@Autowired ResourceBundleMessageSource messageSource;
	@Autowired Properties applicationProperties;
	@Autowired EventPublisher eventPublisher;
	
    // Beans provided by ResourceFactorySpringConfig
	@Autowired CodeSyncFactory codeSyncFactory;
	@Autowired CommodityVarietySyncFactory commodityVarietySyncFactory;
	@Autowired CoveragePerilSyncFactory coveragePerilSyncFactory;
	@Autowired InsuranceClaimFactory insuranceClaimFactory;
	@Autowired ClaimCalculationSubmitFactory claimCalculationSubmitFactory;
	@Autowired InsurancePolicyFactory insurancePolicyFactory;
	@Autowired GrowerContractYearFactory growerContractYearFactory;
	@Autowired InsuredGrowerFactory insuredGrowerFactory;
	@Autowired ContactsFactory contactsFactory; 
	@Autowired InsuredGrowerContactsFactory insuredGrowerContactsFactory;
	@Autowired EmailsFactory emailsFactory;
	@Autowired TelecomFactory telecomFactory;
	@Autowired ProductFactory productFactory;
	@Autowired CommodityTypeCodeSyncFactory commodityTypeCodeSyncFactory;

	
	// Imported Spring Config
	@Autowired CodeTableSpringConfig codeTableSpringConfig;
	@Autowired CodeHierarchySpringConfig codeHierarchySpringConfig;
	@Autowired PersistenceSpringConfig persistenceSpringConfig;


	@Bean
	public ModelValidator modelValidator() {
		ModelValidator result;
		
		result = new ModelValidator();
		result.setCachedCodeTables(codeTableSpringConfig.cachedCodeTables());
		result.setMessageSource(messageSource);
		
		return result;
	}

	@Bean
	public OutboxFactory outboxFactory() {
		OutboxFactory result = new OutboxFactoryImpl();
		return result;
	}
	
	@Bean()
	public CirrasPolicyService cirrasClaimService() {
		CirrasPolicyServiceImpl result;
		
		result = new CirrasPolicyServiceImpl();
		result.setModelValidator(modelValidator());
		result.setApplicationProperties(applicationProperties);

		result.setCodeSyncFactory(codeSyncFactory);
		result.setCommodityVarietySyncFactory(commodityVarietySyncFactory);
		result.setCoveragePerilSyncFactory(coveragePerilSyncFactory);
		result.setInsuranceClaimFactory(insuranceClaimFactory);
		result.setClaimCalculationSubmitFactory(claimCalculationSubmitFactory);
		result.setInsurancePolicyFactory(insurancePolicyFactory);
		result.setGrowerContractYearFactory(growerContractYearFactory);
		result.setInsuredGrowerFactory(insuredGrowerFactory);
		result.setOutboxFactory(outboxFactory());
		result.setContactsFactory(contactsFactory);
		result.setInsuredGrowerContactsFactory(insuredGrowerContactsFactory);
		result.setEmailsFactory(emailsFactory);
		result.setTelecomFactory(telecomFactory);
		result.setProductFactory(productFactory);
		result.setCommodityTypeCodeSyncFactory(commodityTypeCodeSyncFactory);

		result.setClaimDao(persistenceSpringConfig.claimDao());
		result.setClaimOutboxDao(persistenceSpringConfig.claimOutboxDao());
		result.setClaimSearchDao(persistenceSpringConfig.claimSearchDao());
		result.setCodeSyncDao(persistenceSpringConfig.codeSyncDao());
		result.setCommodityVarietySyncDao(persistenceSpringConfig.commodityVarietySyncDao());
		result.setCodeOutboxDao(persistenceSpringConfig.codeOutboxDao());
		result.setCropTypeOutboxDao(persistenceSpringConfig.cropTypeOutboxDao());
		result.setCoveragePerilOutboxDao(persistenceSpringConfig.coveragePerilOutboxDao());
		result.setCoveragePerilSyncDao(persistenceSpringConfig.coveragePerilSyncDao());
		result.setGrowerDao(persistenceSpringConfig.growerDao());
		result.setGrowerOutboxDao(persistenceSpringConfig.growerOutboxDao());
		result.setPolicyDao(persistenceSpringConfig.policyDao());
		result.setPolicyOutboxDao(persistenceSpringConfig.policyOutboxDao());
		result.setGrowerContractYearDao(persistenceSpringConfig.growerContractYearDao());
		result.setGrowerContractYearOutboxDao(persistenceSpringConfig.growerContractYearOutboxDao());
		result.setVarietyDao(persistenceSpringConfig.varietyDao());
		result.setClaimCalculationSubmitDao(persistenceSpringConfig.claimCalculationSubmitDao());
		result.setUserDao(persistenceSpringConfig.userDao());
		result.setContactsDao(persistenceSpringConfig.contactsDao());
		result.setContactsOutboxDao(persistenceSpringConfig.contactsOutboxDao());
		result.setInsuredGrowerContactsDao(persistenceSpringConfig.insuredGrowerContactsDao());
		result.setInsuredGrowerContactsOutboxDao(persistenceSpringConfig.insuredGrowerContactsOutboxDao());
		result.setEmailsDao(persistenceSpringConfig.emailsDao());
		result.setEmailsOutboxDao(persistenceSpringConfig.emailsOutboxDao());
		result.setTelecomDao(persistenceSpringConfig.telecomDao());
		result.setTelecomOutboxDao(persistenceSpringConfig.telecomOutboxDao());
		result.setProductDao(persistenceSpringConfig.productDao());
		result.setProductOutboxDao(persistenceSpringConfig.productOutboxDao());
		result.setCommodityTypeCodeSyncDao(persistenceSpringConfig.commodityTypeCodeSyncDao());
		result.setCommodityTypeCodeOutboxDao(persistenceSpringConfig.commodityTypeCodeOutboxDao());
		result.setCommodityTypeVarietyXrefOutboxDao(persistenceSpringConfig.commodityTypeVarietyXrefOutboxDao());
				
		result.setEventPublisher(eventPublisher);
		
		return result;
	}
}
