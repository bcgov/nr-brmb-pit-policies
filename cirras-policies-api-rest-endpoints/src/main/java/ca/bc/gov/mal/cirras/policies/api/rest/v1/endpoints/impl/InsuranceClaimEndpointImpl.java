package ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.InsuranceClaimEndpoint;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.parameters.validation.ParameterValidator;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimRsrc;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.pit.common.rest.resource.MessageListRsrc;
import ca.bc.gov.mal.pit.common.model.Message;
import ca.bc.gov.mal.pit.common.rest.endpoints.BaseEndpointsImpl;

public class InsuranceClaimEndpointImpl extends BaseEndpointsImpl implements InsuranceClaimEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(InsuranceClaimEndpointImpl.class);
	
	@Autowired
	private CirrasPolicyService cirrasClaimService;

	@Autowired
	private ParameterValidator parameterValidator;
	
	
	public void setCirrasClaimService(CirrasPolicyService cirrasClaimService) {
		this.cirrasClaimService = cirrasClaimService;
	}

	public void setParameterValidator(ParameterValidator parameterValidator) {
		this.parameterValidator = parameterValidator;
	}
	

	@Override
	public Response getInsuranceClaim(String claimNumber) {
		
		Response response = null;
		
		logRequest();
		
		if(!hasAuthority(Scopes.REFRESH_DATA)) {
			return Response.status(Status.FORBIDDEN).build();
		}

		try {
			List<Message> validation = new ArrayList<>();
			
			MessageListRsrc validationMessages = new MessageListRsrc(validation);
			if (validationMessages.hasMessages()) {
				response = Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
			} else {
				
				InsuranceClaimRsrc results = (InsuranceClaimRsrc) cirrasClaimService.getInsuranceClaim(
						toInteger(claimNumber),  // returns null is String is empty
						getFactoryContext(), 
						getWebAdeAuthentication());

				GenericEntity<InsuranceClaimRsrc> entity = new GenericEntity<InsuranceClaimRsrc>(results) {
				};

				response = Response.ok(entity).tag(results.getUnquotedETag()).build();
			}
			
		} catch (Throwable t) {
			response = getInternalServerErrorResponse(t);
		}
		
		logResponse(response);
		
		return response;
	}
}
