package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityVarietySyncDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CommodityVarietySyncDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CommodityVarietySyncDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetCropCommodityById() throws Exception {
		logger.debug("<testGetCropCommodityById");

		Integer cropId = 26;
		String cropName = "WHEAT";
		//Integer parentCropId = null;
		Boolean isProductInsurable = true;
		Boolean isInventoryCrop = true;
		Integer insurancePlanId = 4;
		String shortLabel = "WHT";
		String plantDurationTypeCode = "ANNUAL";
		Boolean isYieldCrop = true;
		Boolean isUnderwritingCrop = true;
		String yieldMeasUnitTypeCode = "TONNE";
		Integer yieldDecimalPrecision = 2;
		Boolean isCropInsuranceEligible = true;
		Boolean isPlantInsuranceEligible = false;
		Boolean isOtherInsuranceEligible = true;

		CommodityVarietySyncDao commodityVarietySyncDao = persistenceSpringConfig.commodityVarietySyncDao();
		CommodityVarietySyncDto dto = commodityVarietySyncDao.selectByCropId(cropId);
		Assert.assertNotNull(dto);
		Assert.assertEquals(cropId, dto.getCropId());
		Assert.assertEquals(cropName, dto.getCropName());
		Assert.assertNull(dto.getParentCropId());
		Assert.assertEquals(isProductInsurable, dto.getIsProductInsurable());
		Assert.assertEquals(isInventoryCrop, dto.getIsInventoryCrop());
		Assert.assertEquals("InsurancePlanId", insurancePlanId, dto.getInsurancePlanId());
		Assert.assertEquals("ShortLabel", shortLabel, dto.getShortLabel());
		Assert.assertEquals("PlantDurationTypeCode", plantDurationTypeCode, dto.getPlantDurationTypeCode());
		Assert.assertEquals("IsYieldCrop", isYieldCrop, dto.getIsYieldCrop());
		Assert.assertEquals("IsUnderwritingCrop", isUnderwritingCrop, dto.getIsUnderwritingCrop());
		Assert.assertEquals("YieldMeasUnitTypeCode", yieldMeasUnitTypeCode, dto.getYieldMeasUnitTypeCode());
		Assert.assertEquals("YieldDecimalPrecision", yieldDecimalPrecision, dto.getYieldDecimalPrecision());
		Assert.assertEquals("isCropInsuranceEligible", isCropInsuranceEligible, dto.getIsCropInsuranceEligible());
		Assert.assertEquals("isPlantInsuranceEligible", isPlantInsuranceEligible, dto.getIsPlantInsuranceEligible());
		Assert.assertEquals("isOtherInsuranceEligible", isOtherInsuranceEligible, dto.getIsOtherInsuranceEligible());
		
		logger.debug(">testGetCropCommodityById");
	}

	@Test
	public void testGetCropVarietyById() throws Exception {
		logger.debug("<testGetCropVarietyById");

		Integer cropId = 93;
		String cropName = "SHAMROCK";
		Integer parentCropId = 3;
		Boolean isProductInsurable = false;
		Boolean isInventoryCrop = false;

		CommodityVarietySyncDao commodityVarietySyncDao = persistenceSpringConfig.commodityVarietySyncDao();
		CommodityVarietySyncDto dto = commodityVarietySyncDao.selectByCropId(cropId);
		Assert.assertNotNull(dto);
		Assert.assertEquals(cropId, dto.getCropId());
		Assert.assertEquals(cropName, dto.getCropName());
		Assert.assertEquals(parentCropId, dto.getParentCropId());
		Assert.assertEquals(isProductInsurable, dto.getIsProductInsurable());
		Assert.assertEquals(isInventoryCrop, dto.getIsInventoryCrop());
		
		logger.debug(">testGetCropVarietyById");
	}
	
	
	@Test
	public void testGetNonexistentCropById() throws Exception {
		logger.debug("<testGetNonexistentCropById");

		// search
		Integer cropId = 999999;
		CommodityVarietySyncDao commodityVarietySyncDao = persistenceSpringConfig.commodityVarietySyncDao();
		CommodityVarietySyncDto dto = commodityVarietySyncDao.selectByCropId(cropId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentCropById");
	}

}
