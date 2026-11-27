package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class ContactsDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactsDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetContactsById() throws Exception {
		logger.debug("<testGetContactsById");

		Integer contactsId = 17710;
		String firstName = "Harvey";
		String lastName = "Kiely";
		
		ContactsDao contactsDao = persistenceSpringConfig.contactsDao();
		ContactsDto dto = contactsDao.selectByContactsId(contactsId);
		Assert.assertNotNull(dto);
		
		Assert.assertEquals("ContactsId", contactsId, dto.getContactsId());
		Assert.assertEquals("FirstName", firstName, dto.getFirstName());
		Assert.assertEquals("LastName", lastName, dto.getLastName());
		
		logger.debug(">testGetContactsById");
	}

	
	@Test
	public void testGetNonexistentContactsById() throws Exception {
		logger.debug("<testGetNonexistentContactsById");

		// search
		Integer contactsId = 999999999;
		ContactsDao contactsDao = persistenceSpringConfig.contactsDao();
		ContactsDto dto = contactsDao.selectByContactsId(contactsId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentContactsById");
	}

}
