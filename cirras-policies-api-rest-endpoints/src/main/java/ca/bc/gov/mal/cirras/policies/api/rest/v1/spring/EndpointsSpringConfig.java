package ca.bc.gov.mal.cirras.policies.api.rest.v1.spring;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import ca.bc.gov.mal.pit.common.api.rest.code.endpoints.spring.CodeEndpointsSpringConfig;
import ca.bc.gov.mal.pit.common.checkhealth.CheckHealthValidator;
import ca.bc.gov.mal.pit.common.checkhealth.CompositeValidator;
import ca.bc.gov.mal.pit.common.checkhealth.DatabaseCheckHealthValidator;
import ca.bc.gov.mal.pit.common.utils.ApplicationContextProvider;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.parameters.validation.ParameterValidator;
import ca.bc.gov.mal.cirras.policies.service.api.v1.spring.ServiceApiSpringConfig;

@Configuration
@Import({
	PropertiesSpringConfig.class,
	ServiceApiSpringConfig.class,
	ResourceFactorySpringConfig.class,
	CodeEndpointsSpringConfig.class,
	SecuritySpringConfig.class,
	EventPublisherSpringConfig.class,
	AsynchronousProcessesSpringConfig.class
})
public class EndpointsSpringConfig {

	private static final Logger logger = LoggerFactory.getLogger(EndpointsSpringConfig.class);
	
	public EndpointsSpringConfig() {
		logger.info("<EndpointsSpringConfig");
		
		logger.info(">EndpointsSpringConfig");
	}
	
	@Bean
	public ApplicationContextProvider applicationContextProvider() {
		ApplicationContextProvider result;
		
		result = new ApplicationContextProvider();
		
		return result;
	}

	@Primary
	@Bean
	public DataSource cirrasDataSource() {
		DataSource result;
		
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
	    dsLookup.setResourceRef(true);
	    result = dsLookup.getDataSource("java:comp/env/jdbc/cirras_policies_rest");
	    
	    return result;
	}
	
	@Bean 
	public DataSource codeTableDataSource() {
		DataSource result;
		
	    result = cirrasDataSource();
	    
	    return result;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource result;
		
		result = new ResourceBundleMessageSource();
		result.setBasename("messages");
		
		return result;
	}

	@Bean
	public ParameterValidator parameterValidator() {
		ParameterValidator result;
		
		result = new ParameterValidator();
		result.setMessageSource(messageSource());
		
		return result;
	}

	@Bean(initMethod="init")
	public CompositeValidator checkHealthValidator() {
		CompositeValidator result;
		
		result = new CompositeValidator();
		result.setComponentIdentifier("WFRM_RESOURCE_API");
		result.setComponentName("Wildfire Resource V2 Rest API");
		result.setValidators(healthCheckValidators());
		
		return result;
	}

	@Bean()
	public List<CheckHealthValidator> healthCheckValidators() {
		List<CheckHealthValidator> result = new ArrayList<>();

		result.add(databaseCheckHealthValidator());
		
		return result;
	}

	@Bean(initMethod="init")
	public DatabaseCheckHealthValidator databaseCheckHealthValidator() {
		DatabaseCheckHealthValidator result;
		
		result = new DatabaseCheckHealthValidator();
		result.setUsername("cirras_wu_ng");
		result.setDescription("java:comp/env/jdbc/cirras_policies_rest");
		result.setDataSource(cirrasDataSource());
		
		return result;
	}

}
