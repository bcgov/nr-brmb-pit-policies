package ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.impl;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ca.bc.gov.nrs.common.wfone.rest.resource.MessageListRsrc;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.BaseEndpointsImpl;
import ca.bc.gov.nrs.wfone.common.service.api.NotFoundException;
import ca.bc.gov.nrs.wfone.common.service.api.ValidationFailureException;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ClaimCalculationSubmitRsrc;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.ClaimCalculationSubmitEndpoint;

public class ClaimCalculationSubmitEndpointImpl extends BaseEndpointsImpl implements ClaimCalculationSubmitEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimCalculationSubmitEndpointImpl.class);
	
	@Autowired
	private CirrasPolicyService cirrasPolicyService; 

	@Override
	public Response submitClaimCalculation(ClaimCalculationSubmitRsrc resource) {
		logger.debug("<submitClaimCalculation");

		Response response = null;
		
		logRequest();
		
		if(!hasAuthority(Scopes.UPDATE_CALCULATION)) {
			return Response.status(Status.FORBIDDEN).build();
		}
			
		try {
			
			cirrasPolicyService.submitClaimCalculation(
					resource, 
					getFactoryContext(), 
					getWebAdeAuthentication());

			response = Response.ok().build();

		} catch(ValidationFailureException e) {
			response = Response.status(Status.BAD_REQUEST).entity(new MessageListRsrc(e.getValidationErrors())).build();
//		} catch (ConflictException e) {
//			response = Response.status(Status.CONFLICT).entity(e.getMessage()).build();
		} catch (NotFoundException e) {
			response = Response.status(Status.NOT_FOUND).build();
		} catch (Throwable t) {
			response = getInternalServerErrorResponse(t);
		}
		
		logResponse(response);

		logger.debug(">submitClaimCalculation " + response.getStatus());
		return response;
	}

}
