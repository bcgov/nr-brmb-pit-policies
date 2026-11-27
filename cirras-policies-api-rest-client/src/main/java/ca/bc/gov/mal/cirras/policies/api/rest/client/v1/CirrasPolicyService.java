package ca.bc.gov.mal.cirras.policies.api.rest.client.v1;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ClaimCalculationSubmitRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.EndpointsRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ProductListRsrc;
import ca.bc.gov.nrs.common.wfone.rest.resource.HealthCheckResponseRsrc;
import ca.bc.gov.nrs.wfone.common.rest.client.RestClientServiceException;

public interface CirrasPolicyService {
	
	EndpointsRsrc getTopLevelEndpoints() throws CirrasPolicyServiceException;

	String getSwaggerString() throws RestClientServiceException;

	HealthCheckResponseRsrc getHealthCheck(String callstack) throws RestClientServiceException;

	InsuranceClaimListRsrc getClaims(
			EndpointsRsrc parent,
			String claimNumber, 
			String policyNumber 
		) 
		throws CirrasPolicyServiceException;	
	
	InsuranceClaimRsrc getInsuranceClaim(EndpointsRsrc parent, String claimNumber) throws CirrasPolicyServiceException;
	
	void claimCalculationSubmit(ClaimCalculationSubmitRsrc resource) throws CirrasPolicyServiceException, ValidationException;

	ProductListRsrc getProducts(
			EndpointsRsrc parent, 
			String insurancePolicyId, 
			String includeProductDetails, 
			String productId, 
			String commodityCoverageCode
	) throws CirrasPolicyServiceException;

}
