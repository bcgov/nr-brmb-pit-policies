package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeSyncDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CommodityTypeCodeSyncDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CommodityTypeCodeSyncDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetCommodityTypeCodeSyncByKey() throws Exception {
		logger.debug("<testGetCommodityTypeCodeSyncByKey");

		CommodityTypeCodeSyncDto expectedDto = new CommodityTypeCodeSyncDto();
		expectedDto.setCommodityTypeCode("Two Row");
		expectedDto.setCropId(16);
		expectedDto.setDescription("Two Row Standard");
		expectedDto.setIsActive(true);
		
		CommodityTypeCodeSyncDao commodityTypeCodeSyncDao = persistenceSpringConfig.commodityTypeCodeSyncDao();
		CommodityTypeCodeSyncDto dto = commodityTypeCodeSyncDao.selectByCommodityTypeCode(expectedDto.getCommodityTypeCode());
		Assert.assertNotNull(dto);
		
		Assert.assertEquals(expectedDto.getCommodityTypeCode(), dto.getCommodityTypeCode());
		Assert.assertEquals(expectedDto.getDescription(), dto.getDescription());
		Assert.assertEquals(expectedDto.getCropId(), dto.getCropId());
		Assert.assertEquals(expectedDto.getIsActive(), dto.getIsActive());
		
		logger.debug(">testGetCommodityTypeCodeSyncByKey");
	}

	
	@Test
	public void testGetNonexistentCommodityTypeCodeSyncByKey() throws Exception {
		logger.debug("<testGetNonexistentCommodityTypeCodeSyncByKey");

		// search
		CommodityTypeCodeSyncDao commodityTypeCodeSyncDao = persistenceSpringConfig.commodityTypeCodeSyncDao();
		CommodityTypeCodeSyncDto dto = commodityTypeCodeSyncDao.selectByCommodityTypeCode("NOSUCHTYPE");
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentCommodityTypeCodeSyncByKey");
	}

}
