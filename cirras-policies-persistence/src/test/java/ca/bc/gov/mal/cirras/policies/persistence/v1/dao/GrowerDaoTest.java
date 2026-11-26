package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class GrowerDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(GrowerDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetGrowerById() throws Exception {
		logger.debug("<testGetGrowerById");

		Integer growerId = 551042;
		Integer growerNumber = 523660;
		Integer growerCityId = 10020;

		GrowerDao growerDao = persistenceSpringConfig.growerDao();
		GrowerDto dto = growerDao.selectByGrowerId(growerId);
		Assert.assertNotNull(dto);
		Assert.assertEquals(growerId, dto.getGrowerId());
		Assert.assertEquals("IFPGT NUBKTK UAOECXY YAQIZ", dto.getGrowerAddressLine1());
		Assert.assertEquals("MB EVB 175", dto.getGrowerAddressLine2());
		Assert.assertEquals(growerCityId, dto.getGrowerCityId());
		Assert.assertEquals("NDVCO, ZSSKXHO & KVMBB, MWKJPY & URXMZ, EQ OE ", dto.getGrowerName());
		Assert.assertEquals(growerNumber, dto.getGrowerNumber());
		Assert.assertEquals("A6U 5X2", dto.getGrowerPostalCode());
		Assert.assertEquals("4892398", dto.getVendorNumber());
		Assert.assertEquals("CHARLIE LAKE", dto.getGrowerCity());
		Assert.assertEquals("BC", dto.getGrowerProvince());
		
		logger.debug(">testGetGrowerById");
	}

	@Test
	public void testGetNonexistentGrowerById() throws Exception {
		logger.debug("<testGetNonexistentGrowerById");

		// search
		Integer growerId = 9999999;
		GrowerDao growerDao = persistenceSpringConfig.growerDao();
		GrowerDto dto = growerDao.selectByGrowerId(growerId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentGrowerById");
	}

}
