package ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyServiceException;
import ca.bc.gov.mal.cirras.policies.api.rest.test.EndpointsTest;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.EndpointsRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimRsrc;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;
import ca.bc.gov.mal.pit.common.webade.oauth2.token.client.Oauth2ClientException;

public class InsuranceClaimEndpointTest extends EndpointsTest {
	private static final Logger logger = LoggerFactory.getLogger(InsuranceClaimEndpointTest.class);


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
	public void testGetClaim() throws CirrasPolicyServiceException, Oauth2ClientException {
		logger.debug("<testGetClaim");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}
		String claimNumber = "28082";
		InsuranceClaimRsrc claimRsrc = service.getInsuranceClaim(topLevelEndpoints, claimNumber);
		Assert.assertEquals(28082, claimRsrc.getClaimNumber().intValue());
		//Assert.assertEquals(1062298, claimRsrc.getInsurancePolicyId().intValue());
		//Assert.assertEquals(claimRsrc.getCalculateIivInd(), "N");
		
//		for(InsuranceClaimVariety v: claimRsrc.getVarieties()) {
//			Assert.assertNotNull(v.getAveragePrice());
//		}

		logger.debug(">testGetClaim");
	}

	@Test
	public void testGetClaimHasChequeReqInd() throws CirrasPolicyServiceException, Oauth2ClientException {
		logger.debug("<testGetClaimHasChequeReqInd");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		String claimNumber = "28084";
		InsuranceClaimRsrc claimRsrc = service.getInsuranceClaim(topLevelEndpoints, claimNumber);
		Assert.assertEquals(28084, claimRsrc.getClaimNumber().intValue());
		Assert.assertEquals(Boolean.FALSE, claimRsrc.getHasChequeReqInd());
		
		claimNumber = "25528";
		claimRsrc = service.getInsuranceClaim(topLevelEndpoints, claimNumber);
		Assert.assertEquals(25528, claimRsrc.getClaimNumber().intValue());
		Assert.assertEquals(Boolean.TRUE, claimRsrc.getHasChequeReqInd());

		logger.debug(">testGetClaimHasChequeReqInd");
	}
	
	
	@Test
	public void testGetBerriesPlantClaim() throws Exception {
		logger.debug("<testGetBerriesPlantClaim");
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}
		
		// search blueberry
		String claimNumber = "28201";
		InsuranceClaimRsrc claimRsrc = service.getInsuranceClaim(topLevelEndpoints, claimNumber);
		Assert.assertNotNull(claimRsrc);
		Assert.assertEquals(Integer.valueOf(claimNumber).intValue(), claimRsrc.getClaimNumber().intValue());
//		claim: 28201
//		units: 47,353.00
//		IV: 4
//		Deductible: 5
//		insured by measurement: UNITS		
		
		// search strawberry
		claimNumber = "28061";
		claimRsrc = service.getInsuranceClaim(topLevelEndpoints, claimNumber);
		Assert.assertNotNull(claimRsrc);
		Assert.assertEquals(Integer.valueOf(claimNumber).intValue(), claimRsrc.getClaimNumber().intValue());

		logger.debug(">testGetBerriesPlantClaim");
		
//		claim: 28061
//		units: 2
//		IV: 3430
//		Deductible: 10
//		insured by measurement: ACRES
	}	
	
	//@Test
	public void testSearchClaims() throws CirrasPolicyServiceException, Oauth2ClientException {
		logger.debug("<testSearchClaims");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}
		
		String claimNumber = "3082";
		String policyNumber = "401837-06";
		InsuranceClaimListRsrc searchResults = service.getClaims(topLevelEndpoints, claimNumber, policyNumber);
		
		Assert.assertNotNull(searchResults);
		Assert.assertTrue(searchResults.getCollection().size() == 1);

		logger.debug(">testSearchClaims");
	}
	
	//@Test
	public void testSearchClaimsByClaimNumber() throws CirrasPolicyServiceException, Oauth2ClientException {
		logger.debug("<testSearchClaimsByClaimNumber");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}
		
		String claimNumber = "3082";
		String policyNumber = null;
		InsuranceClaimListRsrc searchResults = service.getClaims(topLevelEndpoints, claimNumber, policyNumber);
		
		Assert.assertNotNull(searchResults);
		Assert.assertTrue(searchResults.getCollection().size() == 1);
		logger.debug(">testSearchClaimsByClaimNumber");

	}

	//@Test
	public void testSearchClaimsByPolicyNumber() throws CirrasPolicyServiceException, Oauth2ClientException {
		logger.debug("<testSearchClaimsByPolicyNumber");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}
		
		String claimNumber = null;
		String policyNumber = "401837-06";
		InsuranceClaimListRsrc searchResults = service.getClaims(topLevelEndpoints, claimNumber, policyNumber);
		
		Assert.assertNotNull(searchResults);
		Assert.assertTrue(searchResults.getCollection().size() == 1);
		logger.debug(">testSearchClaimsByPolicyNumber");

	}
	
	//@Test
	public void testSearchClaimsNoParams() throws CirrasPolicyServiceException, Oauth2ClientException {
		logger.debug("<testSearchClaimsNoParams");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}
		
		String claimNumber = null;
		String policyNumber = null;
		InsuranceClaimListRsrc searchResults = service.getClaims(topLevelEndpoints, claimNumber, policyNumber);
		
		Assert.assertNotNull(searchResults);
		Assert.assertTrue(searchResults.getCollection().size() == 1);
		logger.debug(">testSearchClaimsNoParams");

	}

	// Not really a unit test, but can be used to see exactly what properties have been configured.
	//@Test
	public void testCurrentProperties() {
		Properties appProperties = (Properties)this.webApplicationContext.getBean("applicationProperties");
//		Properties testProperties = (Properties)this.testApplicationContext.getBean("applicationProperties");

		logger.debug("Application Properties: ");
		for (Map.Entry<Object, Object> e : appProperties.entrySet() ) {
			logger.debug(e.getKey() + "=" + e.getValue());
		}
	}

	// Not really a unit test, but can use to just run the web server for x minutes. Useful for testing the AsynchronousProcessesService and its associated threads.
	//@Test
	public void testAsyncProc() throws InterruptedException {
		synchronized (this) { 
			this.wait(10*60*1000);
		}
	}
}
