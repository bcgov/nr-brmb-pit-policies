package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class ContactsOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactsOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testContactsOutbox() throws Exception {
		logger.debug("<testContactsOutbox");

		// search
		ContactsOutboxDao contactsOutboxDao = persistenceSpringConfig.contactsOutboxDao();
		List<ContactsOutboxDto> dtos = contactsOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
	
		Assert.assertEquals("Wrong ContactsOutboxId (idx=0)", 4, dtos.get(0).getContactsOutboxId().intValue());
		Assert.assertEquals("Wrong ContactsId (idx=0)", 900001, dtos.get(0).getContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "INSERTED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong ContactsOutboxId (idx=1)", 5, dtos.get(1).getContactsOutboxId().intValue());
		Assert.assertEquals("Wrong ContactsId (idx=1)", 900002, dtos.get(1).getContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());

		Assert.assertEquals("Wrong ContactsOutboxId (idx=2)", 6, dtos.get(2).getContactsOutboxId().intValue());
		Assert.assertEquals("Wrong ContactsId (idx=2)", 900003, dtos.get(2).getContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=2)", "DELETED", dtos.get(2).getTransactionType());

		contactsOutboxDao.delete(4);

		dtos = contactsOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong ContactsOutboxId (idx=0)", 5, dtos.get(0).getContactsOutboxId().intValue());
		Assert.assertEquals("Wrong ContactsId (idx=0)", 900002, dtos.get(0).getContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong ContactsOutboxId (idx=1)", 6, dtos.get(1).getContactsOutboxId().intValue());
		Assert.assertEquals("Wrong ContactsId (idx=1)", 900003, dtos.get(1).getContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "DELETED", dtos.get(1).getTransactionType());
		
		contactsOutboxDao.delete(5);
		contactsOutboxDao.delete(6);

		dtos = contactsOutboxDao.select(3);
		Assert.assertEquals("Wrong number of elements", 0, dtos.size());

		logger.debug(">testContactsOutbox");
	}
	/*
	 SQL to create the test data
   INSERT INTO cirr_contacts_ob (con_ob_id, con_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (4, 900001, 'INSERTED', 'admin', sysdate, 'admin', sysdate);
   INSERT INTO cirr_contacts_ob (con_ob_id, con_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (5, 900002, 'UPDATED', 'admin', sysdate, 'admin', sysdate);
   INSERT INTO cirr_contacts_ob (con_ob_id, con_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (6, 900003, 'DELETED', 'admin', sysdate, 'admin', sysdate);
   */

	
}
