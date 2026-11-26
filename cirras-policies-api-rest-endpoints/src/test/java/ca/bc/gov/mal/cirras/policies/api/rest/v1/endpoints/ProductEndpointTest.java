package ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyService;
import ca.bc.gov.mal.cirras.policies.api.rest.client.v1.CirrasPolicyServiceException;
import ca.bc.gov.mal.cirras.policies.api.rest.test.EndpointsTest;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.security.Scopes;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.EndpointsRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ProductListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ProductRsrc;
import ca.bc.gov.nrs.wfone.common.webade.oauth2.token.client.Oauth2ClientException;

public class ProductEndpointTest extends EndpointsTest {
	private static final Logger logger = LoggerFactory.getLogger(ProductEndpointTest.class);


	private static final String[] SCOPES = {
		Scopes.GET_TOP_LEVEL, 
		Scopes.SEARCH_PRODUCTS
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
	public void testGetProducts() throws CirrasPolicyServiceException, Oauth2ClientException {
		logger.debug("<testSearchProducts");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}
		
		Integer insurancePolicyId = 1061577;

		List<ProductRsrc> expectedProducts = new ArrayList<ProductRsrc>();
		ProductRsrc p1 = new ProductRsrc();
		p1.setInsurancePolicyId(insurancePolicyId);
		p1.setProductId(1215585);
		p1.setIcuId(1150786);
		expectedProducts.add(p1);
		
		ProductRsrc p2 = new ProductRsrc();
		p2.setInsurancePolicyId(insurancePolicyId);
		p2.setProductId(1215589);
		p2.setIcuId(1152747);
		expectedProducts.add(p2);

		ProductRsrc p3 = new ProductRsrc();
		p3.setInsurancePolicyId(insurancePolicyId);
		p3.setProductId(1215590);
		p3.setIcuId(1152747);
		expectedProducts.add(p3);

		ProductRsrc p4 = new ProductRsrc();
		p4.setInsurancePolicyId(insurancePolicyId);
		p4.setProductId(null);
		p4.setIcuId(1150787);
		expectedProducts.add(p4);

		ProductListRsrc searchResults = service.getProducts(topLevelEndpoints, insurancePolicyId.toString(), "false", null, null);
		
		Assert.assertNotNull(searchResults);
		
		List<ProductRsrc> actualProducts = searchResults.getCollection();
		Assert.assertEquals(expectedProducts.size(), actualProducts.size());

		for (int i = 0; i < actualProducts.size(); i++) {
			ProductRsrc expectedProduct = expectedProducts.get(i);
			ProductRsrc actualProduct = actualProducts.get(i);
			
			Assert.assertEquals(expectedProduct.getInsurancePolicyId(), actualProduct.getInsurancePolicyId());
			Assert.assertEquals(expectedProduct.getProductId(), actualProduct.getProductId());
			Assert.assertEquals(expectedProduct.getIcuId(), actualProduct.getIcuId());
		}

		// Policy with no products
		searchResults = service.getProducts(topLevelEndpoints, "1064255", "false", null, null);
		
		Assert.assertNotNull(searchResults);
		Assert.assertEquals(0, searchResults.getCollection().size());		
		
		logger.debug(">testSearchProducts");
	}

	@Test
	public void testGetProductsDetails() throws CirrasPolicyServiceException, Oauth2ClientException {
		logger.debug("<testGetProductsDetails");
		
		if(skipTests) {
			logger.warn("Skipping tests");
			return;
		}

		Integer policyIdWithoutProducts = 1067555;
		
		Integer insurancePolicyId = 1067386;

		List<ProductRsrc> expectedProducts = new ArrayList<ProductRsrc>();
		expectedProducts.add(createProductRsrc(1241404, "FINAL", 1067386, 1165114, 2023, 4, 16, "BARLEY", "CQG", 50, "ACRES", 195.0, null, null, 288.0, 320.0, 161.0, 1.654, null, 46445.0));
		expectedProducts.add(createProductRsrc(1241598, "FINAL", 1067386, 1165307, 2023, 4, 18, "CANOLA", "CQG", 50, "ACRES", 1697.0, null, null, 697.5, 775.0, 796.0, 0.937, null, 554546.0));
		expectedProducts.add(createProductRsrc(1241714, "FINAL", 1067386, 1165423, 2023, 4, 21, "FIELD PEA", "CQG", 50, "ACRES", 555.0, null, null, 360.0, 400.0, 369.0, 1.33, null, 132867.0));
		expectedProducts.add(createProductRsrc(1242281, "FINAL", 1067386, 1165989, 2023, 4, 26, "WHEAT", "CQG", 50, "ACRES", 863.0, null, null, 324.0, 360.0, 753.0, 1.745, null, 243961.0));
		expectedProducts.add(createProductRsrc(1242905, "NA", 1067386, 1165114, 2023, 4, 16, "BARLEY", "CSL", null, "ACRES", 195.0, null, null, null, null, null, 1.654, 300.0, 58500.0));
		expectedProducts.add(createProductRsrc(1242906, "NA", 1067386, 1165307, 2023, 4, 18, "CANOLA", "CSL", null, "ACRES", 1697.0, null, null, null, null, null, 0.937, 400.0, 678800.0));
		expectedProducts.add(createProductRsrc(1242907, "NA", 1067386, 1165423, 2023, 4, 21, "FIELD PEA", "CSL", null, "ACRES", 555.0, null, null, null, null, null, 1.33, 400.0, 222000.0));
		expectedProducts.add(createProductRsrc(1242908, "NA", 1067386, 1165989, 2023, 4, 26, "WHEAT", "CSL", null, "ACRES", 863.0, null, null, null, null, null, 1.745, 300.0, 258900.0));
		expectedProducts.add(createProductRsrc(1242081, "FINAL", 1067386, 1165789, 2023, 4, 75, "UNSEEDED GRAIN", "CUNS", 20, "ACRES", 2802.0, 60.0, 75.0, null, null, null, null, null, 134496.0));
		expectedProducts.add(createProductRsrc(1242700, "FINAL", 1067386, null, 2023, 4, 1010076, "GRAIN BASKET", "GB", 20, "ACRES", null, null, null, null, null, null, null, null, 760526.0));

		// -----------------------------------
		// TEST 1: All PI products for policy.
		// -----------------------------------
		ProductListRsrc expectedProductList = new ProductListRsrc();
		expectedProductList.setCollection(expectedProducts);
		
		ProductListRsrc searchResults = service.getProducts(topLevelEndpoints, insurancePolicyId.toString(), "true", null, null);
		checkProductListRsrc(expectedProductList, searchResults);

		// -----------------------------------
		// TEST 2: Quantity PI products for policy.
		// -----------------------------------
		expectedProductList.setCollection(Arrays.asList(
				expectedProducts.get(0),
				expectedProducts.get(1),
				expectedProducts.get(2),
				expectedProducts.get(3)
		));
		
		searchResults = service.getProducts(topLevelEndpoints, insurancePolicyId.toString(), "true", null, "CQG");
		checkProductListRsrc(expectedProductList, searchResults);

		// -----------------------------------
		// TEST 3: PI product for product id.
		// -----------------------------------
		expectedProductList.setCollection(Arrays.asList(
				expectedProducts.get(8)
		));
		
		searchResults = service.getProducts(topLevelEndpoints, insurancePolicyId.toString(), "true", "1242081", null);
		checkProductListRsrc(expectedProductList, searchResults);
		
		
		// -----------------------------------
		// TEST 4: Policy with no products.
		// -----------------------------------
		expectedProductList.setCollection(Collections.emptyList());

		searchResults = service.getProducts(topLevelEndpoints, policyIdWithoutProducts.toString(), "true", null, null);
		checkProductListRsrc(expectedProductList, searchResults);
		
		logger.debug(">testGetProductsDetails");
	}

	private ProductRsrc createProductRsrc(
			Integer productId,
			String productStatusCode,
			Integer insurancePolicyId,
			Integer icuId,
			Integer cropYear,
			Integer insurancePlanId,
			Integer cropCommodityId,
			String commodityName,
			String commodityCoverageCode,
			Integer deductibleLevel,
			String insuredByMeasType,
			Double acres,
			Double unseededSelectedInsurableValue,
			Double unseededInsurableValueHundredPercent,
			Double selectedInsurableValue,
			Double insurableValueHundredPercent,
			Double productionGuarantee,
			Double probableYield,
			Double spotLossCoverageAmountPerAcre,
			Double coverageDollars
			) {

		ProductRsrc pr = new ProductRsrc();

		pr.setAcres(acres);
		pr.setCommodityCoverageCode(commodityCoverageCode);
		pr.setCommodityName(commodityName);
		pr.setCoverageDollars(coverageDollars);
		pr.setCropCommodityId(cropCommodityId);
		pr.setCropYear(cropYear);
		pr.setDeductibleLevel(deductibleLevel);
		pr.setIcuId(icuId);
		pr.setInsurableValueHundredPercent(insurableValueHundredPercent);
		pr.setInsurancePlanId(insurancePlanId);
		pr.setInsurancePolicyId(insurancePolicyId);
		pr.setInsuredByMeasType(insuredByMeasType);
		pr.setProbableYield(probableYield);
		pr.setProductId(productId);
		pr.setProductionGuarantee(productionGuarantee);
		pr.setProductStatusCode(productStatusCode);
		pr.setSelectedInsurableValue(selectedInsurableValue);
		pr.setSpotLossCoverageAmountPerAcre(spotLossCoverageAmountPerAcre);
		pr.setUnseededInsurableValueHundredPercent(unseededInsurableValueHundredPercent);
		pr.setUnseededSelectedInsurableValue(unseededSelectedInsurableValue);
		
		return pr;
	}

	private void checkProductListRsrc(ProductListRsrc src, ProductListRsrc dest) {
		Assert.assertNotNull(src);
		Assert.assertNotNull(dest);
		Assert.assertEquals(src.getCollection().size(), dest.getCollection().size());
		
		for ( int i = 0; i < src.getCollection().size(); i++ ) {
			checkProductRsrc(src.getCollection().get(i), dest.getCollection().get(i));
		}
	}
	
	private void checkProductRsrc(ProductRsrc src, ProductRsrc dest) {
		Assert.assertEquals(src.getAcres(), dest.getAcres());
		Assert.assertEquals(src.getCommodityCoverageCode(), dest.getCommodityCoverageCode());
		Assert.assertEquals(src.getCommodityName(), dest.getCommodityName());
		Assert.assertEquals(src.getCoverageDollars(), dest.getCoverageDollars());
		Assert.assertEquals(src.getCropCommodityId(), dest.getCropCommodityId());
		Assert.assertEquals(src.getCropYear(), dest.getCropYear());
		Assert.assertEquals(src.getDeductibleLevel(), dest.getDeductibleLevel());
		Assert.assertEquals(src.getIcuId(), dest.getIcuId());		
		Assert.assertEquals(src.getInsurableValueHundredPercent(), dest.getInsurableValueHundredPercent());
		Assert.assertEquals(src.getInsurancePlanId(), dest.getInsurancePlanId());
		Assert.assertEquals(src.getInsurancePolicyId(), dest.getInsurancePolicyId());
		Assert.assertEquals(src.getInsuredByMeasType(), dest.getInsuredByMeasType());
		Assert.assertEquals(src.getProbableYield(), dest.getProbableYield());
		Assert.assertEquals(src.getProductId(), dest.getProductId());
		Assert.assertEquals(src.getProductionGuarantee(), dest.getProductionGuarantee());
		Assert.assertEquals(src.getProductStatusCode(), dest.getProductStatusCode());
		Assert.assertEquals(src.getSelectedInsurableValue(), dest.getSelectedInsurableValue());
		Assert.assertEquals(src.getSpotLossCoverageAmountPerAcre(), dest.getSpotLossCoverageAmountPerAcre());
		Assert.assertEquals(src.getUnseededInsurableValueHundredPercent(), dest.getUnseededInsurableValueHundredPercent());
		Assert.assertEquals(src.getUnseededSelectedInsurableValue(), dest.getUnseededSelectedInsurableValue());
	}
	
}
