package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilSyncDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CoveragePerilSyncDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CoveragePerilSyncDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetCoveragePerilById() throws Exception {
		logger.debug("<testGetCoveragePerilById");

		Integer coveragePerilId = 213;
		Integer cropCommodityId = 3;
		String perilCode = "FIRE";
		String commodityCoverageCode = "CQTF";
		Integer cropCoverageId = 10020;
		Boolean isActive = true;
		
		CoveragePerilSyncDao coveragePerilSyncDao = persistenceSpringConfig.coveragePerilSyncDao();
		CoveragePerilSyncDto dto = coveragePerilSyncDao.selectByCoveragePerilId(coveragePerilId);
		Assert.assertNotNull(dto);
		
		Assert.assertEquals(coveragePerilId, dto.getCoveragePerilId());
		Assert.assertEquals(cropCommodityId, dto.getCropCommodityId());
		Assert.assertEquals(perilCode, dto.getPerilCode());
		Assert.assertEquals(commodityCoverageCode, dto.getCommodityCoverageCode());
		Assert.assertEquals(cropCoverageId, dto.getCropCoverageId());
		Assert.assertEquals(isActive, dto.getIsActive());
		
		logger.debug(">testGetCoveragePerilById");
	}

	
	@Test
	public void testGetNonexistentCoveragePerilById() throws Exception {
		logger.debug("<testGetNonexistentCoveragePerilById");

		// search
		Integer coveragePerilId = 12345678;
		CoveragePerilSyncDao coveragePerilSyncDao = persistenceSpringConfig.coveragePerilSyncDao();
		CoveragePerilSyncDto dto = coveragePerilSyncDao.selectByCoveragePerilId(coveragePerilId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentCoveragePerilById");
	}

}
