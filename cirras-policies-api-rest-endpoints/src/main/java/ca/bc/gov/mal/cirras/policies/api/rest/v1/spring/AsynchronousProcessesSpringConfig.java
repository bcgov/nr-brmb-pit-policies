package ca.bc.gov.mal.cirras.policies.api.rest.v1.spring;

import java.util.Properties;

import jakarta.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.async.AsyncMasterTask;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.async.AsynchronousProcessesService;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.async.AsynchronousProcessesServiceImpl;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.async.FailOverService;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.async.FailOverServiceImpl;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.async.FetchOutboxTask;

@Configuration
@Import({
	SecuritySpringConfig.class
})
public class AsynchronousProcessesSpringConfig {

	private static final Logger logger = LoggerFactory.getLogger(AsynchronousProcessesSpringConfig.class);

	public AsynchronousProcessesSpringConfig() {
		logger.debug("<AsynchronousProcessesSpringConfig");
		
		logger.debug(">AsynchronousProcessesSpringConfig");
	}

	// Beans provided by EndpointsSpringConfig
	@Autowired Properties applicationProperties;
	
	// Imported Spring Config
	@Autowired SecuritySpringConfig securitySpringConfig;

	// Beans provided by ServiceApiSpringConfig
	@Autowired CirrasPolicyService cirrasPolicyService;

	@Value("${webade-oauth2.cirras-claims-rest.client.id}")
	private String webadeOauth2ClientId;

	@Value("${webade-oauth2.cirras-claims-rest.client.secret}")
	private String webadeOauth2ClientSecret;
	
	@Bean
	FailOverService failOverService() {
		FailOverServiceImpl result;
		
		result = new FailOverServiceImpl();
		
		return result;
	}
	
	@Bean
	UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken() {
		UsernamePasswordAuthenticationToken result;
		
		result = new UsernamePasswordAuthenticationToken(webadeOauth2ClientId, webadeOauth2ClientSecret);
		
		return result;
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	AsyncMasterTask asyncMasterTask() throws AddressException {
		AsyncMasterTask result;
		
		result = new AsyncMasterTask(applicationProperties);
		result.setUsernamePasswordAuthenticationToken(usernamePasswordAuthenticationToken());
		result.setAuthenticationProvider(securitySpringConfig.authenticationProvider());
		result.setFailOverService(failOverService());

		return result;
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	FetchOutboxTask fetchOutboxTask() throws AddressException {
		FetchOutboxTask result;
		
		result = new FetchOutboxTask(applicationProperties);
		result.setUsernamePasswordAuthenticationToken(usernamePasswordAuthenticationToken());
		result.setAuthenticationProvider(securitySpringConfig.authenticationProvider());
		result.setCirrasPolicyService(cirrasPolicyService);
		
		return result;
	}

	@Bean
	AsynchronousProcessesService asynchronousProcessesService() throws AddressException {
		AsynchronousProcessesServiceImpl result;
		
		result = new AsynchronousProcessesServiceImpl();
		result.setApplicationProperties(applicationProperties);
		result.setAsyncMasterTask(asyncMasterTask());

		return result;
	}
}
