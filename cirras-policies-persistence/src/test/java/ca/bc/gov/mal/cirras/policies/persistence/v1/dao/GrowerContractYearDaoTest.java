package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class GrowerContractYearDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(GrowerContractYearDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetGrowerContractYearById() throws Exception {
		logger.debug("<testGetGrowerContractYearById");

		Integer growerContractYearId = 94622;
		Integer contractId = 729489;
		Integer growerId = 549900;
		Integer insurancePlanId = 1;
		Integer cropYear = 2023;


		GrowerContractYearDao growerContractYearDao = persistenceSpringConfig.growerContractYearDao();
		GrowerContractYearDto dto = growerContractYearDao.selectByGrowerContractYearId(growerContractYearId);
		Assert.assertNotNull(dto);

		Assert.assertEquals("GrowerContractYearId", growerContractYearId, dto.getGrowerContractYearId());
		Assert.assertEquals("ContractId", contractId, dto.getContractId());
		Assert.assertEquals("GrowerId", growerId, dto.getGrowerId());
		Assert.assertEquals("InsurancePlanId", insurancePlanId, dto.getInsurancePlanId());
		Assert.assertEquals("CropYear", cropYear, dto.getCropYear());
		
		logger.debug(">testGetGrowerContractYearById");
	}

	@Test
	public void testGetNonexistentGrowerContractYearById() throws Exception {
		logger.debug("<testGetNonexistentGrowerContractYearById");

		// search
		Integer growerContractYearId = 999999;
		GrowerContractYearDao growerContractYearDao = persistenceSpringConfig.growerContractYearDao();
		GrowerContractYearDto dto = growerContractYearDao.selectByGrowerContractYearId(growerContractYearId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentGrowerContractYearById");
	}

}
