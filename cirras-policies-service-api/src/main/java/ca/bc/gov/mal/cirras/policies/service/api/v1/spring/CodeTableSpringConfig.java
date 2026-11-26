package ca.bc.gov.mal.cirras.policies.service.api.v1.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;

import ca.bc.gov.mal.pit.common.persistence.code.dao.CodeTableConfig;
import ca.bc.gov.mal.pit.common.persistence.code.spring.CodePersistenceSpringConfig;
import ca.bc.gov.mal.cirras.policies.service.api.v1.util.CachedCodeTables;


@Configuration
@Import({
	CodePersistenceSpringConfig.class
})
public class CodeTableSpringConfig {

	private static final Logger logger = LoggerFactory.getLogger(CodeTableSpringConfig.class);
	
	public CodeTableSpringConfig() {
		logger.debug("<CodeTableSpringConfig");
		
		logger.debug(">CodeTableSpringConfig");
	}

	// Beans provided by EndpointsSpringConfig
	@Autowired ResourceBundleMessageSource messageSource;
	
	// Imported Spring Config
	@Autowired CodePersistenceSpringConfig codePersistenceSpringConfig;
	
	@Bean
	public CachedCodeTables cachedCodeTables() {
		CachedCodeTables result;
		
		result = new CachedCodeTables();
		result.setCodeTableDao(codePersistenceSpringConfig.codeTableDao());
		result.setCodeTableConfigs(codeTableConfigs());
		
		return result;
	}

	@Bean
	public List<CodeTableConfig> codeTableConfigs() {
		List<CodeTableConfig> result = new ArrayList<>();

		result.add(insurancePlanCodeTableConfig());
		result.add(insuranceCoverageCodeTableConfig());
		result.add(claimStatusCodeTableConfig());
		result.add(cropCommodityCodeTableConfig());
		result.add(perilCodeTableConfig());

		return result;
	}
	
	
	@Bean
	public CodeTableConfig insurancePlanCodeTableConfig() {
		return createCodeTableConfig("INSURANCE_PLAN_CODE");
	}
	
	@Bean
	public CodeTableConfig insuranceCoverageCodeTableConfig() {
		return createCodeTableConfig("INSURANCE_COVERAGE_CODE");
	}
	
	@Bean
	public CodeTableConfig claimStatusCodeTableConfig() {
		return createCodeTableConfig("CLAIM_STATUS_CODE");
	}
	
	@Bean
	public CodeTableConfig cropCommodityCodeTableConfig() {
		return createCodeTableConfig("CROP_COMMODITY_CODE");
	}
	
	@Bean
	public CodeTableConfig perilCodeTableConfig() {
		return createCodeTableConfig("PERIL_CODE");
	}
	
	
	private CodeTableConfig createCodeTableConfig(String tableName) {
		CodeTableConfig result = new CodeTableConfig();
		
		String fetchSql = String.format("SELECT T.%s CODE, T.DESCRIPTION, NULL DISPLAY_ORDER, T.EFFECTIVE_DATE, T.EXPIRY_DATE, T.CREATE_USER, T.CREATE_DATE, T.UPDATE_USER, T.UPDATE_DATE FROM %s T ORDER BY T.DESCRIPTION", tableName, tableName);
				
		//result.setReadScope("CIRRAS_CLAIMS.GET_CODE_TABLES");
		result.setUseRevisionCount(Boolean.FALSE);
		result.setCodeTableDao(codePersistenceSpringConfig.codeTableDao());
		result.setCodeTableName(tableName);
		result.setFetchSql(fetchSql);
		
		return result;
	}
}
