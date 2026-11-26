package ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.parameters.PagingQueryParameters;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.InsuranceClaimEndpoint;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.InsuranceClaimListEndpoint;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.parameters.validation.ParameterValidator;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimRsrc;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.nrs.common.wfone.rest.resource.MessageListRsrc;
import ca.bc.gov.nrs.wfone.common.model.Message;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.BaseEndpointsImpl;

public class InsuranceClaimListEndpointImpl extends BaseEndpointsImpl implements InsuranceClaimListEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(InsuranceClaimListEndpointImpl.class);
	
	@Autowired
	private CirrasPolicyService cirrasPolicyService;

	@Autowired
	private ParameterValidator parameterValidator;
	
	
	public void setCirrasClaimService(CirrasPolicyService cirrasPolicyService) {
		this.cirrasPolicyService = cirrasPolicyService;
	}

	public void setParameterValidator(ParameterValidator parameterValidator) {
		this.parameterValidator = parameterValidator;
	}
	

	@Override
	public Response getInsuranceClaims(
			String claimNumber,
			String policyNumber) {
		
		Response response = null;
		
		logRequest();
		
		if(!hasAuthority(Scopes.SEARCH_CLAIMS)) {
			return Response.status(Status.FORBIDDEN).build();
		}

		try {
				
			InsuranceClaimListRsrc results = (InsuranceClaimListRsrc) cirrasPolicyService.getClaims(
					toInteger(claimNumber), 
					toString(policyNumber),
					getFactoryContext(), 
					getWebAdeAuthentication());

			
			GenericEntity<InsuranceClaimListRsrc> entity = new GenericEntity<InsuranceClaimListRsrc>(results) {
				/* do nothing */
			};

			response = Response.ok(entity).tag(results.getUnquotedETag()).build();
			
		} catch (Throwable t) {
			response = getInternalServerErrorResponse(t);
		}
		
		logResponse(response);

		return response;
	}
}
