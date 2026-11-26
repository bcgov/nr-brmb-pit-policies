package ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyServiceException;
import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.ValidationException;
import ca.bc.gov.mal.cirras.policies.api.rest.test.EndpointsTest;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ClaimCalculationSubmitRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.EndpointsRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimRsrc;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.util.PoliciesServiceEnums;
import ca.bc.gov.nrs.wfone.common.webade.oauth2.token.client.Oauth2ClientException;

public class ClaimCalculationSubmitEndpointTest extends EndpointsTest {
	private static final Logger logger = LoggerFactory.getLogger(ClaimCalculationSubmitEndpointTest.class);


	private static final String[] SCOPES = {
		Scopes.GET_TOP_LEVEL, 
		Scopes.REFRESH_DATA,
		Scopes.SEARCH_CLAIMS,
		Scopes.UPDATE_CALCULATION
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
	public void testSubmitNoPayment() throws CirrasPolicyServiceException, Oauth2ClientException, ValidationException {
		logger.debug("<testSubmitNoPayment");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		//NEEDS TO BE A CLAIM WITHOUT CHEQUE REQ IN STATUS Open with claim type New
		ClaimCalculationSubmitRsrc resource = new ClaimCalculationSubmitRsrc();
		Integer claimNumber = 30676;
		Double claimAmount = (double)10000;
		String userId = "mhostett";
		resource.setClaimNumber(claimNumber);
		resource.setClaimAmount(claimAmount);
		resource.setUserId(userId);
		
		//Submit to trigger an error (claim amount > coverage)
		try {
			service.claimCalculationSubmit(resource);
			Assert.fail("Submit operation should have thrown an exception");
		} catch ( ValidationException e) {
			// Expected.
			Assert.assertEquals(1, e.getMessages().size());

			String claimStatusTypeMessage = "Claim amount cannot be higher than the total coverage in CIRRAS. Refresh the calculation to resolve this issue.";
			Assert.assertEquals("Claim Amount",  claimStatusTypeMessage, e.getMessages().get(0).getMessage());
		}


		//Set claim amount within the coverage
		resource.setClaimAmount((double)2000);

		
		//Successful submit
		try {
			service.claimCalculationSubmit(resource);
		} catch ( ValidationException e) {
			Assert.fail("Submit operation shouldn't have thrown an exception");
		}
		
		//Submit again to trigger an error (status and type)
		try {
			service.claimCalculationSubmit(resource);
			Assert.fail("Submit operation should have thrown an exception");
		} catch ( ValidationException e) {
			// Expected.
			Assert.assertEquals(1, e.getMessages().size());

			String claimStatusTypeMessage = "Claim Status has to be OPEN and Claim Type has to be NEW. Roll back the claim in CIRRAS to resolve this issue.";
			Assert.assertEquals("Claim Type",  claimStatusTypeMessage, e.getMessages().get(0).getMessage());
		}
		
		logger.debug(">testSubmitNoPayment");
	}

	@Test
	public void testSubmitWithPaymentZeroClaim() throws CirrasPolicyServiceException, Oauth2ClientException, ValidationException {
		logger.debug("<testSubmitWithPaymentZeroClaim");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		//NEEDS TO BE A CLAIM WITH CHEQUE REQ IN STATUS In Progress with claim type ZERO CLAIM 
		ClaimCalculationSubmitRsrc resource = new ClaimCalculationSubmitRsrc();
		Integer claimNumber = 30393;
		Double claimAmount = (double)0;
		String userId = "mhostett";
		resource.setClaimNumber(claimNumber);
		resource.setClaimAmount(claimAmount);
		resource.setUserId(userId);

		try {
			service.claimCalculationSubmit(resource);
		} catch ( ValidationException e) {
			Assert.fail("Submit operation shouldn't have thrown an exception");
		}
		
		logger.debug(">testSubmitWithPaymentZeroClaim");
	}
	
	@Test
	public void testSubmitWithPaymentClaim() throws CirrasPolicyServiceException, Oauth2ClientException, ValidationException {
		logger.debug("<testSubmitWithPaymentClaim");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		//NEEDS TO BE A CLAIM WITH CHEQUE REQ IN STATUS In Progress with claim type CLAIM 
		ClaimCalculationSubmitRsrc resource = new ClaimCalculationSubmitRsrc();
		Integer claimNumber = 30126;
		Double claimAmount = (double)5000;
		String userId = "mhostett";
		resource.setClaimNumber(claimNumber);
		resource.setClaimAmount(claimAmount);
		resource.setUserId(userId);

		try {
			service.claimCalculationSubmit(resource);
		} catch ( ValidationException e) {
			Assert.fail("Submit operation shouldn't have thrown an exception");
		}
		
		logger.debug(">testSubmitWithPaymentClaim");
	}
	
	@Test
	public void testSubmitWithPaymentStatusError() throws CirrasPolicyServiceException, Oauth2ClientException, ValidationException {
		logger.debug("<testSubmitWithPaymentStatusError");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		//NEEDS TO BE A CLAIM WITH CHEQUE REQ IN STATUS OTHER THAN In Progress 
		ClaimCalculationSubmitRsrc resource = new ClaimCalculationSubmitRsrc();
		Integer claimNumber = 28168;
		Double claimAmount = (double)11200;
		String userId = "mhostett";
		resource.setClaimNumber(claimNumber);
		resource.setClaimAmount(claimAmount);
		resource.setUserId(userId);

		try {
			service.claimCalculationSubmit(resource);
			Assert.fail("Submit operation should have thrown an exception");
		} catch ( ValidationException e) {
			// Expected.
			Assert.assertEquals(1, e.getMessages().size());
			
			String statusMessage = "Claim Status has to be IN PROGRESS. Roll back the claim in CIRRAS to resolve this issue.";
			Assert.assertEquals("Status",  statusMessage, e.getMessages().get(0).getMessage());
		}
		
		logger.debug(">testSubmitWithPaymentStatusError");
	}
	
	@Test
	public void testSubmitWithPaymentClaimTypeAndHoldbackError() throws CirrasPolicyServiceException, Oauth2ClientException, ValidationException {
		logger.debug("<testSubmitWithPaymentClaimTypeAndHoldbackError");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		//NEEDS TO BE A CLAIM WITH CHEQUE REQ IN STATUS In Progress AND CLAIM TYPE = NO DAMAGE AND A HOLDBACK AMOUNT GREATER claimAmount
		ClaimCalculationSubmitRsrc resource = new ClaimCalculationSubmitRsrc();
		Integer claimNumber = 30140;
		Double claimAmount = (double)11200;
		String userId = "mhostett";
		resource.setClaimNumber(claimNumber);
		resource.setClaimAmount(claimAmount);
		resource.setUserId(userId);

		try {
			service.claimCalculationSubmit(resource);
			Assert.fail("Submit operation should have thrown an exception");
		} catch ( ValidationException e) {
			// Expected.
			Assert.assertEquals(2, e.getMessages().size());
			
			String holdBackMessage = "There exists at least one holdback amount that is greater than the total claim amount. Please update the holdback amount in the claim in CIRRAS.";
			Assert.assertEquals("Holdback",  holdBackMessage, e.getMessages().get(0).getMessage());

			String claimTypeMessage = "Claim Type has to be CLAIM or ZERO CLAIM. Roll back the claim in CIRRAS to resolve this issue.";
			Assert.assertEquals("Claim Type",  claimTypeMessage, e.getMessages().get(1).getMessage());
		}
		
		logger.debug(">testSubmitWithPaymentClaimTypeAndHoldbackError");
	}	
	
	
	@Test
	public void testSubmitWithPaymentClaimTypeAndStatusError() throws CirrasPolicyServiceException, Oauth2ClientException, ValidationException {
		logger.debug("<testSubmitWithPaymentClaimTypeAndStatusError");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		//NEEDS TO BE A CLAIM WITH CHEQUE REQ IN STATUS OTHER THAN In Progress AND CLAIM TYPE = NO DAMAGE
		ClaimCalculationSubmitRsrc resource = new ClaimCalculationSubmitRsrc();
		Integer claimNumber = 30039;
		Double claimAmount = (double)11200;
		String userId = "mhostett";
		resource.setClaimNumber(claimNumber);
		resource.setClaimAmount(claimAmount);
		resource.setUserId(userId);

		try {
			service.claimCalculationSubmit(resource);
			Assert.fail("Submit operation should have thrown an exception");
		} catch ( ValidationException e) {
			// Expected.
			Assert.assertEquals(1, e.getMessages().size());
			
			String claimStatusTypeMessage = "Claim Status has to be IN PROGRESS and Claim Type has to be CLAIM or ZERO CLAIM. Roll back the claim in CIRRAS to resolve this issue.";
			Assert.assertEquals("Claim Type",  claimStatusTypeMessage, e.getMessages().get(0).getMessage());
		}
		
		logger.debug(">testSubmitWithPaymentClaimTypeAndStatusError");
	}	
	
}
