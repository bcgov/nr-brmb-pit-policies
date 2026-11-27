package ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.impl;

import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.ProductListEndpoint;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.parameters.validation.ParameterValidator;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ProductListRsrc;
import ca.bc.gov.mal.cirras.policies.service.api.v1.CirrasPolicyService;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.BaseEndpointsImpl;

public class ProductListEndpointImpl extends BaseEndpointsImpl implements ProductListEndpoint {
	
	@Autowired
	private CirrasPolicyService cirrasPolicyService;

	@Autowired
	private ParameterValidator parameterValidator;
	
	
	public void setCirrasPolicyService(CirrasPolicyService cirrasPolicyService) {
		this.cirrasPolicyService = cirrasPolicyService;
	}

	public void setParameterValidator(ParameterValidator parameterValidator) {
		this.parameterValidator = parameterValidator;
	}
		
	@Override
	public Response getProducts(String insurancePolicyId, String includeProductDetails, String productId, String commodityCoverageCode) {
		
		Response response = null;
		
		logRequest();
		
		if(!hasAuthority(Scopes.SEARCH_PRODUCTS)) {
			return Response.status(Status.FORBIDDEN).build();
		}

		try {
			ProductListRsrc results = (ProductListRsrc) cirrasPolicyService.getProducts(
					toInteger(insurancePolicyId), 
					toBoolean(includeProductDetails),
					toInteger(productId), 
					toString(commodityCoverageCode),
					getFactoryContext(), 
					getWebAdeAuthentication());

			
			GenericEntity<ProductListRsrc> entity = new GenericEntity<ProductListRsrc>(results) {
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
