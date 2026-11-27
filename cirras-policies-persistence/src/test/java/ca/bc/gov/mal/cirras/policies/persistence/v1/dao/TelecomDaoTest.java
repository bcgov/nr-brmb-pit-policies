package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class TelecomDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(TelecomDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetTelecomById() throws Exception {
		logger.debug("<testGetTelecomById");

		Integer telecomId = 17795;
		Integer contactsId = 17366;
		String phoneNumber = "2507694451";
		String extension = "251";
		Boolean isPrimaryPhoneInd = true;
		String telecomTypeCode = "PHONE";
		Boolean isActive = true;
		
		TelecomDao telecomDao = persistenceSpringConfig.telecomDao();
		TelecomDto dto = telecomDao.selectByTelecomId(telecomId);
		Assert.assertNotNull(dto);
		
		Assert.assertEquals("TelecomId", telecomId, dto.getTelecomId());
		Assert.assertEquals("ContactsId", contactsId, dto.getContactsId());
		Assert.assertEquals("PhoneNumber", phoneNumber, dto.getPhoneNumber());
		Assert.assertEquals("Extension", extension, dto.getExtension());
		Assert.assertEquals("IsPrimaryPhoneInd", isPrimaryPhoneInd, dto.getIsPrimaryPhoneInd());
		Assert.assertEquals("TelecomTypeCode", telecomTypeCode, dto.getTelecomTypeCode());
		Assert.assertEquals("IsActive", isActive, dto.getIsActive());
		
		logger.debug(">testGetTelecomById");
	}

	
	@Test
	public void testGetNonexistentTelecomById() throws Exception {
		logger.debug("<testGetNonexistentTelecomById");

		// search
		Integer telecomId = 999999999;
		TelecomDao telecomDao = persistenceSpringConfig.telecomDao();
		TelecomDto dto = telecomDao.selectByTelecomId(telecomId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentTelecomById");
	}

}
