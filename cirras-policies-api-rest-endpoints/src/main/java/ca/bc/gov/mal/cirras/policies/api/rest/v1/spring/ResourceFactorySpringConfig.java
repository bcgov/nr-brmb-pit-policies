package ca.bc.gov.mal.cirras.policies.api.rest.v1.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.ClaimCalculationSubmitRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.CodeSyncRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.CommodityTypeCodeSyncRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.CommodityVarietySyncRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.ContactsRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.CoveragePerilSyncRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.EmailsRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.GrowerContractYearRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.InsuranceClaimRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.InsurancePolicyRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.InsuredGrowerContactsRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.InsuredGrowerRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.ProductRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.TelecomRsrcFactory;


@Configuration
public class ResourceFactorySpringConfig {

	private static final Logger logger = LoggerFactory.getLogger(ResourceFactorySpringConfig.class);
	
	public ResourceFactorySpringConfig() {
		logger.info("<ResourceFactorySpringConfig");
		
		logger.info(">ResourceFactorySpringConfig");
	}

	
	@Bean
	public InsuranceClaimRsrcFactory insuranceClaimFactory() {
		InsuranceClaimRsrcFactory result = new InsuranceClaimRsrcFactory();
		return result;
	}
	
	@Bean
	public ClaimCalculationSubmitRsrcFactory claimCalculationSubmitFactory() {
		ClaimCalculationSubmitRsrcFactory result = new ClaimCalculationSubmitRsrcFactory();
		return result;
	}
	
	@Bean
	public InsuredGrowerRsrcFactory insuredGrowerFactory() {
		InsuredGrowerRsrcFactory result = new InsuredGrowerRsrcFactory();
		return result;
	}

	@Bean
	public InsurancePolicyRsrcFactory insurancePolicyFactory() {
		InsurancePolicyRsrcFactory result = new InsurancePolicyRsrcFactory();
		return result;
	}

	@Bean
	public GrowerContractYearRsrcFactory growerContractYearFactory() {
		GrowerContractYearRsrcFactory result = new GrowerContractYearRsrcFactory();
		return result;
	}
	
	@Bean
	public CommodityVarietySyncRsrcFactory commodityVarietySyncFactory() {
		CommodityVarietySyncRsrcFactory result = new CommodityVarietySyncRsrcFactory();
		return result;
	}

	@Bean
	public CoveragePerilSyncRsrcFactory coveragePerilSyncFactory() {
		CoveragePerilSyncRsrcFactory result = new CoveragePerilSyncRsrcFactory();
		return result;
	}

	@Bean
	public CodeSyncRsrcFactory codeSyncFactory() {
		CodeSyncRsrcFactory result = new CodeSyncRsrcFactory();
		return result;
	}

	@Bean
	public ContactsRsrcFactory contactsFactory() {
		ContactsRsrcFactory result = new ContactsRsrcFactory();
		return result;
	}
	
	@Bean
	public InsuredGrowerContactsRsrcFactory insuredGrowerContactsFactory() {
		InsuredGrowerContactsRsrcFactory result = new InsuredGrowerContactsRsrcFactory();
		return result;
	}

	@Bean
	public EmailsRsrcFactory emailsFactory() {
		EmailsRsrcFactory result = new EmailsRsrcFactory();
		return result;
	}

	@Bean
	public TelecomRsrcFactory telecomFactory() {
		TelecomRsrcFactory result = new TelecomRsrcFactory();
		return result;
	}

	@Bean
	public ProductRsrcFactory productFactory() {
		ProductRsrcFactory result = new ProductRsrcFactory();
		return result;
	}

	@Bean
	public CommodityTypeCodeSyncRsrcFactory commodityTypeCodeSyncFactory() {
		CommodityTypeCodeSyncRsrcFactory result = new CommodityTypeCodeSyncRsrcFactory();
		return result;
	}
	
}
