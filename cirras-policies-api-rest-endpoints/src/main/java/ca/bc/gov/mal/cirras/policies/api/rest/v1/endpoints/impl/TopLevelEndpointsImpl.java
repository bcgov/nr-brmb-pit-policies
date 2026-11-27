package ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.impl;

import java.net.URI;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.TopLevelEndpoints;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.EndpointsRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.InsuranceClaimRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory.ProductRsrcFactory;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.pit.common.rest.resource.RelLink;
import ca.bc.gov.mal.pit.common.rest.endpoints.BaseEndpointsImpl;

public class TopLevelEndpointsImpl extends BaseEndpointsImpl implements TopLevelEndpoints {
	/** Logger. */
	private static final Logger logger = LoggerFactory.getLogger(TopLevelEndpointsImpl.class);
	
	@Override
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getTopLevel() {
		Response response = null;

		URI baseUri = this.getBaseUri();
		
		EndpointsRsrc result = new EndpointsRsrc();

		result.setReleaseVersion(this.getApplicationProperties().getProperty("application.version"));

		try {
			if (hasAuthority(Scopes.REFRESH_DATA)) {
				String selfURI = InsuranceClaimRsrcFactory.getInsuranceClaimSelfUri(null, baseUri);
				result.getLinks().add(new RelLink(ResourceTypes.INSURANCE_CLAIM, selfURI, HttpMethod.GET));
			}
			
			if (hasAuthority(Scopes.SEARCH_CLAIMS)) {
				String selfURI = InsuranceClaimRsrcFactory.getClaimsSelfUri(null, null, baseUri);
				result.getLinks().add(new RelLink(ResourceTypes.INSURANCE_CLAIM_LIST, selfURI, HttpMethod.GET));
			}
			
			if (hasAuthority(Scopes.UPDATE_CALCULATION)) {
				String selfURI = InsuranceClaimRsrcFactory.getClaimCalculationSubmitSelfUri(baseUri);
				result.getLinks().add(new RelLink(ResourceTypes.CLAIM_CALCULATION_SUBMIT, selfURI, HttpMethod.PUT));
			}

			if (hasAuthority(Scopes.SEARCH_PRODUCTS)) {
				String selfURI = ProductRsrcFactory.getProductListSelfUri(null, null, null, null, baseUri);
				result.getLinks().add(new RelLink(ResourceTypes.PRODUCT_LIST, selfURI, HttpMethod.GET));
			}
			
			result.setETag(getEtag(result));

			GenericEntity<EndpointsRsrc> entity = new GenericEntity<EndpointsRsrc>(result) {
				/* do nothing */
			};

			response = Response.ok(entity).tag(result.getUnquotedETag()).build();
			
		} catch (Throwable t) {
			response = getInternalServerErrorResponse(t);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getTopLevel=" + response);
		}
		
		return response;
	}
}
