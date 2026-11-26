package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.EmailsDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class EmailsDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailsDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetEmailsById() throws Exception {
		logger.debug("<testGetEmailsById");

		Integer emailsId = 1013027;
		Integer contactsId = 1024579;
		String emailAddress = "sohiaman82@gmail.com";
		Boolean isPrimaryEmailInd = true;
		Boolean isActive = true;
		
		EmailsDao emailsDao = persistenceSpringConfig.emailsDao();
		EmailsDto dto = emailsDao.selectByEmailsId(emailsId);
		Assert.assertNotNull(dto);
		
		Assert.assertEquals("EmailsId", emailsId, dto.getEmailsId());
		Assert.assertEquals("ContactsId", contactsId, dto.getContactsId());
		Assert.assertEquals("EmailAddress", emailAddress, dto.getEmailAddress());
		Assert.assertEquals("IsPrimaryEmailInd", isPrimaryEmailInd, dto.getIsPrimaryEmailInd());
		Assert.assertEquals("IsActive", isActive, dto.getIsActive());
		
		logger.debug(">testGetEmailsById");
	}

	
	@Test
	public void testGetNonexistentEmailsById() throws Exception {
		logger.debug("<testGetNonexistentEmailsById");

		// search
		Integer emailsId = 999999999;
		EmailsDao emailsDao = persistenceSpringConfig.emailsDao();
		EmailsDto dto = emailsDao.selectByEmailsId(emailsId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentEmailsById");
	}

}
