package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class ProductDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetProductsByPolicyId() throws Exception {
		logger.debug("<testGetProductsByPolicyId");

		Integer insurancePolicyId = 1061577;

		List<ProductDto> expectedDtos = new ArrayList<ProductDto>();
		ProductDto p1 = new ProductDto();
		p1.setInsurancePolicyId(insurancePolicyId);
		p1.setProductId(1215585);
		p1.setIcuId(1150786);
		expectedDtos.add(p1);
		
		ProductDto p2 = new ProductDto();
		p2.setInsurancePolicyId(insurancePolicyId);
		p2.setProductId(1215589);
		p2.setIcuId(1152747);
		expectedDtos.add(p2);

		ProductDto p3 = new ProductDto();
		p3.setInsurancePolicyId(insurancePolicyId);
		p3.setProductId(1215590);
		p3.setIcuId(1152747);
		expectedDtos.add(p3);
		
		ProductDto p4 = new ProductDto();
		p4.setInsurancePolicyId(insurancePolicyId);
		p4.setProductId(null);
		p4.setIcuId(1150787);
		expectedDtos.add(p4);
		
		ProductDao productDao = persistenceSpringConfig.productDao();
		List<ProductDto> actualDtos = productDao.selectByPolicyId(insurancePolicyId);
		Assert.assertNotNull(actualDtos);
		Assert.assertEquals(expectedDtos.size(), actualDtos.size());

		for (int i = 0; i < actualDtos.size(); i++) {
			ProductDto expectedDto = expectedDtos.get(i);
			ProductDto actualDto = actualDtos.get(i);
			
			Assert.assertEquals(expectedDto.getInsurancePolicyId(), actualDto.getInsurancePolicyId());
			Assert.assertEquals(expectedDto.getProductId(), actualDto.getProductId());			
			Assert.assertEquals(expectedDto.getIcuId(), actualDto.getIcuId());			
		}		

		actualDtos = productDao.selectByPolicyId(1064255);
		Assert.assertNotNull(actualDtos);
		Assert.assertEquals(0, actualDtos.size());
		
		logger.debug(">testGetProductsByPolicyId");
	}
	
	@Test
	public void testGetProductById() throws Exception {
		logger.debug("<testGetProductById");

		Integer productId = 1251236;
		Integer policyId = 1070087;
		Integer cropCommodityId = 16;
		String commodityCoverageCode = "CQG";
		String productStatusCode = "FINAL";
		Integer deductibleLevel = 50;
		Double productionGuarantee = 2044.0;
		Double probableYield = 1.7700;
		String insuredByMeasType = "ACRES";
		Integer cropYear = 2024;
		Integer insurancePlanId = 4;
		Double insurableValueHundredPercent = 250.0;
		Double coverageDollars = 459990.0;

		
		ProductDao productDao = persistenceSpringConfig.productDao();
		ProductDto dto = productDao.selectByProductId(productId);
		Assert.assertNotNull(dto);
		
		Assert.assertEquals("ProductId", productId, dto.getProductId());
		Assert.assertEquals("PolicyId", policyId, dto.getInsurancePolicyId());
		Assert.assertEquals("CropCommodityId", cropCommodityId, dto.getCropCommodityId());
		Assert.assertEquals("CommodityCoverageCode", commodityCoverageCode, dto.getCommodityCoverageCode());
		Assert.assertEquals("ProductStatusCode", productStatusCode, dto.getProductStatusCode());
		Assert.assertEquals("DeductibleLevel", deductibleLevel, dto.getDeductibleLevel());
		Assert.assertEquals("ProductionGuarantee", productionGuarantee, dto.getProductionGuarantee());
		Assert.assertEquals("ProbableYield", probableYield, dto.getProbableYield());
		Assert.assertEquals("InsuredByMeasType", insuredByMeasType, dto.getInsuredByMeasType());
		Assert.assertEquals("CropYear", cropYear, dto.getCropYear());
		Assert.assertEquals("InsurancePlanId", insurancePlanId, dto.getInsurancePlanId());
		Assert.assertEquals("InsurableValueHundredPercent", insurableValueHundredPercent, dto.getInsurableValueHundredPercent());
		Assert.assertEquals("CoverageDollars", coverageDollars, dto.getCoverageDollars());

		
		logger.debug(">testGetProductById");
	}
	
	@Test
	public void testGetGrainBasketProductById() throws Exception {
		logger.debug("<testGetGrainBasketProductById");

		Integer productId = 1252983;
		Integer policyId = 1070125;
		Integer cropCommodityId = 1010076;
		String commodityCoverageCode = "GB";
		String productStatusCode = "OFFER";
		Integer deductibleLevel = 20;
		Double productionGuarantee = null;
		Double probableYield = null;
		String insuredByMeasType = "ACRES";
		Integer cropYear = 2024;
		Integer insurancePlanId = 4;
		Double insurableValueHundredPercent = null;
		Double coverageDollars = 11713.0;

		
		ProductDao productDao = persistenceSpringConfig.productDao();
		ProductDto dto = productDao.selectByProductId(productId);
		Assert.assertNotNull(dto);
		
		Assert.assertEquals("ProductId", productId, dto.getProductId());
		Assert.assertEquals("PolicyId", policyId, dto.getInsurancePolicyId());
		Assert.assertEquals("CropCommodityId", cropCommodityId, dto.getCropCommodityId());
		Assert.assertEquals("CommodityCoverageCode", commodityCoverageCode, dto.getCommodityCoverageCode());
		Assert.assertEquals("ProductStatusCode", productStatusCode, dto.getProductStatusCode());
		Assert.assertEquals("DeductibleLevel", deductibleLevel, dto.getDeductibleLevel());
		Assert.assertEquals("ProductionGuarantee", productionGuarantee, dto.getProductionGuarantee());
		Assert.assertEquals("ProbableYield", probableYield, dto.getProbableYield());
		Assert.assertEquals("InsuredByMeasType", insuredByMeasType, dto.getInsuredByMeasType());
		Assert.assertEquals("CropYear", cropYear, dto.getCropYear());
		Assert.assertEquals("InsurancePlanId", insurancePlanId, dto.getInsurancePlanId());
		Assert.assertEquals("InsurableValueHundredPercent", insurableValueHundredPercent, dto.getInsurableValueHundredPercent());
		Assert.assertEquals("CoverageDollars", coverageDollars, dto.getCoverageDollars());

		
		logger.debug(">testGetGrainBasketProductById");
	}
	
	@Test
	public void testGetUnsupportedCoverage() throws Exception {
		logger.debug("<testGetUnsupportedCoverage");

		// search
		Integer productId = 1252866;
		ProductDao productDao = persistenceSpringConfig.productDao();
		ProductDto dto = productDao.selectByProductId(productId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetUnsupportedCoverage");
	}	
	
	@Test
	public void testGetUnsupportedInsurancePlan() throws Exception {
		logger.debug("<testGetUnsupportedInsurancePlan");

		// search
		Integer productId = 1241219;
		ProductDao productDao = persistenceSpringConfig.productDao();
		ProductDto dto = productDao.selectByProductId(productId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetUnsupportedInsurancePlan");
	}	
	
	
	
	
	@Test
	public void testGetNonexistentProductById() throws Exception {
		logger.debug("<testGetNonexistentProductById");

		// search
		Integer productId = 999999999;
		ProductDao productDao = persistenceSpringConfig.productDao();
		ProductDto dto = productDao.selectByProductId(productId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentProductById");
	}

	@Test
	public void testGetProductsDetails() throws Exception {
		logger.debug("<testGetProductsDetails");
		
		Integer policyIdWithoutProducts = 1067555;
		
		Integer insurancePolicyId = 1067386;

		List<ProductDto> expectedProducts = new ArrayList<ProductDto>();
		expectedProducts.add(createProductDto(1241404, "FINAL", 1067386, 1165114, 2023, 4, 16, "BARLEY", "CQG", 50, "ACRES", 195.0, null, null, 288.0, 320.0, 161.0, 1.654, null, 46445.0));
		expectedProducts.add(createProductDto(1241598, "FINAL", 1067386, 1165307, 2023, 4, 18, "CANOLA", "CQG", 50, "ACRES", 1697.0, null, null, 697.5, 775.0, 796.0, 0.937, null, 554546.0));
		expectedProducts.add(createProductDto(1241714, "FINAL", 1067386, 1165423, 2023, 4, 21, "FIELD PEA", "CQG", 50, "ACRES", 555.0, null, null, 360.0, 400.0, 369.0, 1.33, null, 132867.0));
		expectedProducts.add(createProductDto(1242281, "FINAL", 1067386, 1165989, 2023, 4, 26, "WHEAT", "CQG", 50, "ACRES", 863.0, null, null, 324.0, 360.0, 753.0, 1.745, null, 243961.0));
		expectedProducts.add(createProductDto(1242905, "NA", 1067386, 1165114, 2023, 4, 16, "BARLEY", "CSL", null, "ACRES", 195.0, null, null, null, null, null, 1.654, 300.0, 58500.0));
		expectedProducts.add(createProductDto(1242906, "NA", 1067386, 1165307, 2023, 4, 18, "CANOLA", "CSL", null, "ACRES", 1697.0, null, null, null, null, null, 0.937, 400.0, 678800.0));
		expectedProducts.add(createProductDto(1242907, "NA", 1067386, 1165423, 2023, 4, 21, "FIELD PEA", "CSL", null, "ACRES", 555.0, null, null, null, null, null, 1.33, 400.0, 222000.0));
		expectedProducts.add(createProductDto(1242908, "NA", 1067386, 1165989, 2023, 4, 26, "WHEAT", "CSL", null, "ACRES", 863.0, null, null, null, null, null, 1.745, 300.0, 258900.0));
		expectedProducts.add(createProductDto(1242081, "FINAL", 1067386, 1165789, 2023, 4, 75, "UNSEEDED GRAIN", "CUNS", 20, "ACRES", 2802.0, 60.0, 75.0, null, null, null, null, null, 134496.0));
		expectedProducts.add(createProductDto(1242700, "FINAL", 1067386, null, 2023, 4, 1010076, "GRAIN BASKET", "GB", 20, "ACRES", null, null, null, null, null, null, null, null, 760526.0));

		ProductDao productDao = persistenceSpringConfig.productDao();
		
		// -----------------------------------
		// TEST 1: All PI products for policy.
		// -----------------------------------
		List<ProductDto> expectedProductList = expectedProducts;
		
		List<ProductDto> searchResults = productDao.selectProductsDetailsByPolicyId(insurancePolicyId, null, null);
		checkProductDtoList(expectedProductList, searchResults);

		// -----------------------------------
		// TEST 2: Quantity PI products for policy.
		// -----------------------------------
		expectedProductList = Arrays.asList(
				expectedProducts.get(0),
				expectedProducts.get(1),
				expectedProducts.get(2),
				expectedProducts.get(3)
		);
		
		searchResults = productDao.selectProductsDetailsByPolicyId(insurancePolicyId, null, "CQG");
		checkProductDtoList(expectedProductList, searchResults);

		// -----------------------------------
		// TEST 3: PI product for product id.
		// -----------------------------------
		expectedProductList = Arrays.asList(
				expectedProducts.get(8)
		);
		
		searchResults = productDao.selectProductsDetailsByPolicyId(insurancePolicyId, 1242081, null);
		checkProductDtoList(expectedProductList, searchResults);
		
		
		// -----------------------------------
		// TEST 4: Policy with no products.
		// -----------------------------------
		expectedProductList = Collections.emptyList();

		searchResults = productDao.selectProductsDetailsByPolicyId(policyIdWithoutProducts, null, null);
		checkProductDtoList(expectedProductList, searchResults);
		
		logger.debug(">testGetProductsDetails");
	}
	
	
	private ProductDto createProductDto(
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

		ProductDto pr = new ProductDto();

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

	private void checkProductDtoList(List<ProductDto> src, List<ProductDto> dest) {
		Assert.assertNotNull(src);
		Assert.assertNotNull(dest);
		Assert.assertEquals(src.size(), dest.size());
		
		for ( int i = 0; i < src.size(); i++ ) {
			checkProductDto(src.get(i), dest.get(i));
		}
	}
	
	private void checkProductDto(ProductDto src, ProductDto dest) {
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
