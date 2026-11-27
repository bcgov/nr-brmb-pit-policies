package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class InsuredGrowerContactsDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(InsuredGrowerContactsDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetInsuredGrowerContactsById() throws Exception {
		logger.debug("<testGetInsuredGrowerContactsById");

		Integer growerContactsId = 18705;
		Integer growerId = 11703;
		Integer contactsId = 18705;
		Boolean isPrimaryContactInd = false;
		Boolean isActivelyInvolvedInd = true;

		
		InsuredGrowerContactsDao insuredGrowerContactsDao = persistenceSpringConfig.insuredGrowerContactsDao();
		InsuredGrowerContactsDto dto = insuredGrowerContactsDao.selectByGrowerContactsId(growerContactsId);
		Assert.assertNotNull(dto);
		
		Assert.assertEquals("GrowerContactId", growerContactsId, dto.getGrowerContactsId());
		Assert.assertEquals("GrowerId", growerId, dto.getGrowerId());
		Assert.assertEquals("ContactId", contactsId, dto.getContactsId());
		Assert.assertEquals("IsPrimaryContactInd", isPrimaryContactInd, dto.getIsPrimaryContactInd());
		Assert.assertEquals("IsActivelyInvolvedInd", isActivelyInvolvedInd, dto.getIsActivelyInvolvedInd());

		
		logger.debug(">testGetInsuredGrowerContactsById");
	}

	
	@Test
	public void testGetNonexistentInsuredGrowerContactsById() throws Exception {
		logger.debug("<testGetNonexistentInsuredGrowerContactsById");

		// search
		Integer growerContactsId = 999999999;
		InsuredGrowerContactsDao insuredGrowerContactsDao = persistenceSpringConfig.insuredGrowerContactsDao();
		InsuredGrowerContactsDto dto = insuredGrowerContactsDao.selectByGrowerContactsId(growerContactsId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentInsuredGrowerContactsById");
	}

}
