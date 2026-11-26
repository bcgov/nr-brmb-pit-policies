package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.UriBuilder;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.ProductListEndpoint;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ProductListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ProductRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.Product;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductList;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.ProductFactory;
import ca.bc.gov.nrs.common.wfone.rest.resource.RelLink;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryContext;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class ProductRsrcFactory extends BaseResourceFactory implements ProductFactory {
	
	@Override
	public ProductList<? extends Product> getProductList(
			List<ProductDto> dtos,
			Integer insurancePolicyId,
			Boolean includeProductDetails, 
			Integer productId, 
			String commodityCoverageCode,
			FactoryContext context, 
			WebAdeAuthentication authentication
	) throws FactoryException, DaoException {
		URI baseUri = getBaseURI(context);
		
		ProductListRsrc result = null;
		
		List<ProductRsrc> resources = new ArrayList<ProductRsrc>();
		
		for (ProductDto dto : dtos) {
			ProductRsrc resource = new ProductRsrc();
			
			populateResource(resource, dto);
			
			resources.add(resource);
		}
		
		result = new ProductListRsrc();
		result.setCollection(resources);
		
		String eTag = getEtag(result);
		result.setETag(eTag);		
		
		setSelfLink(result, 
				insurancePolicyId, 
				includeProductDetails,
				productId,
				commodityCoverageCode,
				baseUri);
		
		return result;
	}
	
	@Override
	public Product getProduct(ProductDto dto) throws FactoryException {

		ProductRsrc resource = new ProductRsrc();

		populateResource(resource, dto);

		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.

		return resource;
	}

	private void populateResource(ProductRsrc resource, ProductDto dto) {
		resource.setInsurancePolicyId(dto.getInsurancePolicyId());
		resource.setProductId(dto.getProductId());
		resource.setIcuId(dto.getIcuId());
		resource.setCropCommodityId(dto.getCropCommodityId());
		resource.setCommodityCoverageCode(dto.getCommodityCoverageCode());
		resource.setProductStatusCode(dto.getProductStatusCode());
		resource.setDeductibleLevel(dto.getDeductibleLevel());
		resource.setProductionGuarantee(dto.getProductionGuarantee());
		resource.setProbableYield(dto.getProbableYield());
		resource.setInsuredByMeasType(dto.getInsuredByMeasType());
		resource.setInsurableValueHundredPercent(dto.getInsurableValueHundredPercent());
		resource.setCoverageDollars(dto.getCoverageDollars());
		resource.setAcres(dto.getAcres());
		resource.setCommodityName(dto.getCommodityName());
		resource.setCropYear(dto.getCropYear());
		resource.setInsurancePlanId(dto.getInsurancePlanId());
		resource.setSelectedInsurableValue(dto.getSelectedInsurableValue());
		resource.setSpotLossCoverageAmountPerAcre(dto.getSpotLossCoverageAmountPerAcre());
		resource.setUnseededInsurableValueHundredPercent(dto.getUnseededInsurableValueHundredPercent());
		resource.setUnseededSelectedInsurableValue(dto.getUnseededSelectedInsurableValue());
	}
	
	private static void setSelfLink(
			ProductListRsrc resource, 
			Integer insurancePolicyId,
			Boolean includeProductDetails, 
			Integer productId, 
			String commodityCoverageCode,
			URI baseUri) {
			
			String selfUri = getProductListSelfUri(
					insurancePolicyId,
					includeProductDetails,
					productId,
					commodityCoverageCode,
					baseUri);
			
			resource.getLinks().add(new RelLink(ResourceTypes.SELF, selfUri, "GET"));
	}
	
	public static String getProductListSelfUri(
		Integer insurancePolicyId, 
		Boolean includeProductDetails, 
		Integer productId, 
		String commodityCoverageCode,
		URI baseUri) {

		String result = UriBuilder.fromUri(baseUri)
			.path(ProductListEndpoint.class)
			.queryParam("insurancePolicyId", nvl(insurancePolicyId, ""))
			.queryParam("includeProductDetails", nvl(toString(includeProductDetails), ""))
			.queryParam("productId", nvl(productId, ""))
			.queryParam("commodityCoverageCode", nvl(commodityCoverageCode, ""))
			.build()
			.toString();

		return result;
	}
		
	protected static String nvl(Integer value, String defaultValue) {
		return (value==null)?defaultValue:value.toString();
	}
}
