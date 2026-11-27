package ca.bc.gov.mal.cirras.policies.api.rest.v1.publisher;

import java.util.Map;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyServiceException;
import ca.bc.gov.mal.cirras.policies.api.rest.test.EndpointsTest;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.EndpointsRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimRsrc;

import ca.bc.gov.mal.cirras.policies.service.api.v1.EventPublisher;
import ca.bc.gov.mal.cirras.policies.service.api.v1.EventPublisherException;

import ca.bc.gov.mal.cirras.policies.model.v1.PoliciesEventTypes;
import ca.bc.gov.mal.pit.common.webade.oauth2.token.client.Oauth2ClientException;

public class EventPublisherTest extends EndpointsTest {
	private static final Logger logger = LoggerFactory.getLogger(EventPublisherTest.class);

	private static ObjectMapper mapper = new ObjectMapper();
	
	private static final String[] SCOPES = {
			Scopes.GET_TOP_LEVEL, 
			Scopes.REFRESH_DATA,
			Scopes.SEARCH_CLAIMS
	};

	private CirrasPolicyService service;
	private EndpointsRsrc topLevelEndpoints;

		
	@Before
	public void prepareTests() throws CirrasPolicyServiceException, Oauth2ClientException{
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}
		service = getService(SCOPES);
		topLevelEndpoints = service.getTopLevelEndpoints();
	}	
	
	@Test
	public void testClaimEventPublish() throws CirrasPolicyServiceException, Oauth2ClientException, EventPublisherException {
		logger.debug("<testClaimEventPublish");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		String claimNumber = "28168";
		InsuranceClaimRsrc claimRsrc = service.getInsuranceClaim(topLevelEndpoints, claimNumber);
		Assert.assertEquals(28168, claimRsrc.getClaimNumber().intValue());

		Map<String, String> sourceIdentifiers = new HashMap<>();
		sourceIdentifiers.put("claimNumber", claimRsrc.getClaimNumber().toString());
		
		EventPublisher eventPublisher = (EventPublisher)webApplicationContext.getBean("eventPublisher");
		eventPublisher.publish(PoliciesEventTypes.ClaimUpdated, null, claimRsrc, sourceIdentifiers);
				
		logger.debug(">testClaimEventPublish");		
	}

	@Test
	public void testNoRsrcEventPublish() throws CirrasPolicyServiceException, Oauth2ClientException, EventPublisherException {
		logger.debug("<testNoRsrcEventPublish");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		String claimNumber = "999999";

		Map<String, String> sourceIdentifiers = new HashMap<>();
		sourceIdentifiers.put("claimNumber", claimNumber);
		
		EventPublisher eventPublisher = (EventPublisher)webApplicationContext.getBean("eventPublisher");
		eventPublisher.publish(PoliciesEventTypes.ClaimDeleted, null, null, sourceIdentifiers);
				
		logger.debug(">testNoRsrcEventPublish");		
	}
	
}
