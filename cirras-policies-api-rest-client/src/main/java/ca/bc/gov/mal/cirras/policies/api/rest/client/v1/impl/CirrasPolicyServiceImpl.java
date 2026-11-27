package ca.bc.gov.mal.cirras.policies.api.rest.client.v1.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AuthorizationServiceException;

import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyServiceException;
import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.ValidationException;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ClaimCalculationSubmitRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.EndpointsRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ProductListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.nrs.common.wfone.rest.resource.BaseResource;
import ca.bc.gov.nrs.common.wfone.rest.resource.RelLink;
import ca.bc.gov.nrs.wfone.common.rest.client.BadRequestException;
import ca.bc.gov.nrs.wfone.common.rest.client.BaseRestServiceClient;
import ca.bc.gov.nrs.wfone.common.rest.client.GenericRestDAO;
import ca.bc.gov.nrs.wfone.common.rest.client.Response;
import ca.bc.gov.nrs.wfone.common.rest.client.RestDAOException;

public class CirrasPolicyServiceImpl extends BaseRestServiceClient implements CirrasPolicyService {

	private static final Logger logger = LoggerFactory.getLogger(CirrasPolicyServiceImpl.class);
	
	public static final String CLIENT_VERSION = "1";

	private static final String Scopes = "WEBADE-REST.*";
	
	/**
	 * Constructor used for making OAuth2 Client Credentials requests
	 * @param webadeOauth2ClientId
	 * @param webadeOauth2ClientSecret
	 * @param webadeOauth2TokenUrl
	 */
	public CirrasPolicyServiceImpl(String webadeOauth2ClientId, String webadeOauth2ClientSecret, String webadeOauth2TokenUrl, String scopes) {
		super(webadeOauth2ClientId, webadeOauth2ClientSecret, webadeOauth2TokenUrl, scopes != null ? scopes : Scopes);
		logger.debug("<CirrasPolicyServiceImpl");
		
		logger.debug(">CirrasPolicyServiceImpl");
	}

	/**
	 * Constructor used for making requests with basic credentials
	 *
	 * @param webadeOauth2ClientId
	 * @param webadeOauth2ClientSecret
	 */
	public CirrasPolicyServiceImpl(String webadeOauth2ClientId, String webadeOauth2ClientSecret) {
		super(webadeOauth2ClientId, webadeOauth2ClientSecret);
		logger.debug("<CirrasPolicyServiceImpl");
		
		logger.debug(">CirrasPolicyServiceImpl");
	}

	/**
	 * Constructor used for making requests with basic credentials
	 *
	 * @param headerValue
	 */
	public CirrasPolicyServiceImpl(String headerValue) {
		super(headerValue);
		logger.debug("<CirrasPolicyServiceImpl");
		
		logger.debug(">CirrasPolicyServiceImpl");
	}
	
	/**
	 * Constructor used for making requests using the authorization header of the current HttpServletRequest
	 * 
	 */
	public CirrasPolicyServiceImpl() {
		super();
		logger.debug("<CirrasPolicyServiceImpl");
		
		logger.debug(">CirrasPolicyServiceImpl");
	}

	@Override
	public String getClientVersion() {
		return CLIENT_VERSION;
	}
	
	
	@Override
	public EndpointsRsrc getTopLevelEndpoints() throws CirrasPolicyServiceException {
		EndpointsRsrc result = null;

		try {
			String topLevelRestURL = getTopLevelRestURL();
			
			GenericRestDAO<EndpointsRsrc> dao = this.getRestDAOFactory().getGenericRestDAO(EndpointsRsrc.class);
			Response<EndpointsRsrc> response = dao.Process(
				ResourceTypes.ENDPOINTS, this.getTransformer(), new BaseResource() {

					private static final long serialVersionUID = 1L;

					@Override
					public List<RelLink> getLinks() {
						List<RelLink> links = new ArrayList<RelLink>();
						links.add(new RelLink(ResourceTypes.ENDPOINTS, topLevelRestURL, "GET"));
						return links;
					}
				}, getWebClient());

			if (404 == response.getResponseCode()) {
				throw new AuthorizationServiceException("Failed to find toplevel at '" + getTopLevelRestURL() + "'");
			}

			result = response.getResource();

		} catch (RestDAOException e) {
			e.printStackTrace();
			throw new CirrasPolicyServiceException(e);
			
		} catch (Throwable t) {
			t.printStackTrace();
			throw new CirrasPolicyServiceException(t);
		}

		return result;
	}
	


	@Override
	public InsuranceClaimRsrc getInsuranceClaim(
		EndpointsRsrc parent,
		String claimNumber)
	throws CirrasPolicyServiceException {
		GenericRestDAO<InsuranceClaimRsrc> dao = this.getRestDAOFactory().getGenericRestDAO(InsuranceClaimRsrc.class);
		
		try {
			Map<String, String> queryParams = new HashMap<String, String>();

			putQueryParam(queryParams, "claimNumber",  claimNumber);
			
			Response<InsuranceClaimRsrc> response = dao.Process(ResourceTypes.INSURANCE_CLAIM, this.getTransformer(), parent, queryParams, getWebClient());
			
			return response.getResource();

		} catch (RestDAOException e) {
			throw new CirrasPolicyServiceException(e);
		}
	}
	
	@Override
	public InsuranceClaimListRsrc getClaims(
		EndpointsRsrc parent,
		String claimNumber,
		String policyNumber)
	
	throws CirrasPolicyServiceException {
	
		GenericRestDAO<InsuranceClaimListRsrc> dao = this.getRestDAOFactory().getGenericRestDAO(InsuranceClaimListRsrc.class);
		//GenericRestDAO<InsuranceClaimRsrc> dao = this.getRestDAOFactory().getGenericRestDAO(InsuranceClaimRsrc.class);
		//GenericRestDAO<ClaimCalculationListRsrc> dao = this.getRestDAOFactory().getGenericRestDAO(ClaimCalculationListRsrc.class);
		
		try {
		
			Map<String, String> queryParams = new HashMap<String, String>();
			
			putQueryParam(queryParams, "claimNumber",  claimNumber);
			putQueryParam(queryParams, "policyNumber",  policyNumber);
			
			Response<InsuranceClaimListRsrc> response = dao.Process(ResourceTypes.INSURANCE_CLAIM_LIST, this.getTransformer(), parent, queryParams, getWebClient());
			
			return response.getResource();
	
		} catch (RestDAOException e) {
			throw new CirrasPolicyServiceException(e);
		}
	}	
	
	@Override
	public void claimCalculationSubmit(ClaimCalculationSubmitRsrc resource)
	throws CirrasPolicyServiceException, ValidationException {
	
		EndpointsRsrc parentEndpoint = getTopLevelEndpoints();
		
		GenericRestDAO<ClaimCalculationSubmitRsrc> dao = this.getRestDAOFactory().getGenericRestDAO(ClaimCalculationSubmitRsrc.class);
		
		try {
			dao.Process(ResourceTypes.CLAIM_CALCULATION_SUBMIT, this.getTransformer(), parentEndpoint, resource, getWebClient());			
						
		} catch(BadRequestException e) {
			throw new ValidationException(e.getMessages());			
		} catch (RestDAOException rde) {
			throw new CirrasPolicyServiceException(rde);
		}
		
	}

	@Override
	public ProductListRsrc getProducts(
			EndpointsRsrc parent, 
			String insurancePolicyId,
			String includeProductDetails, 
			String productId, 
			String commodityCoverageCode
	) throws CirrasPolicyServiceException {
		GenericRestDAO<ProductListRsrc> dao = this.getRestDAOFactory().getGenericRestDAO(ProductListRsrc.class);
		
		try {
		
			Map<String, String> queryParams = new HashMap<String, String>();
			
			putQueryParam(queryParams, "insurancePolicyId",  insurancePolicyId);
			putQueryParam(queryParams, "includeProductDetails",  includeProductDetails);
			putQueryParam(queryParams, "productId",  productId);
			putQueryParam(queryParams, "commodityCoverageCode",  commodityCoverageCode);
			
			Response<ProductListRsrc> response = dao.Process(ResourceTypes.PRODUCT_LIST, this.getTransformer(), parent, queryParams, getWebClient());
			
			return response.getResource();
	
		} catch (RestDAOException e) {
			throw new CirrasPolicyServiceException(e);
		}

	}

}
