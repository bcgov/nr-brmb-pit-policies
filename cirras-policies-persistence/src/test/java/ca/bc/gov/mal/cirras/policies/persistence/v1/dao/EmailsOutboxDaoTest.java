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
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.EmailsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class EmailsOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailsOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testEmailsOutbox() throws Exception {
		logger.debug("<testEmailsOutbox");

		// search
		EmailsOutboxDao emailsOutboxDao = persistenceSpringConfig.emailsOutboxDao();
		List<EmailsOutboxDto> dtos = emailsOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
	
		Assert.assertEquals("Wrong EmailsOutboxId (idx=0)", 4, dtos.get(0).getEmailsOutboxId().intValue());
		Assert.assertEquals("Wrong EmailsId (idx=0)", 900001, dtos.get(0).getEmailsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "INSERTED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong EmailsOutboxId (idx=1)", 5, dtos.get(1).getEmailsOutboxId().intValue());
		Assert.assertEquals("Wrong EmailsId (idx=1)", 900002, dtos.get(1).getEmailsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());

		Assert.assertEquals("Wrong EmailsOutboxId (idx=2)", 6, dtos.get(2).getEmailsOutboxId().intValue());
		Assert.assertEquals("Wrong EmailsId (idx=2)", 900003, dtos.get(2).getEmailsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=2)", "DELETED", dtos.get(2).getTransactionType());

		emailsOutboxDao.delete(4);

		dtos = emailsOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong EmailsOutboxId (idx=0)", 5, dtos.get(0).getEmailsOutboxId().intValue());
		Assert.assertEquals("Wrong EmailsId (idx=0)", 900002, dtos.get(0).getEmailsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong EmailsOutboxId (idx=1)", 6, dtos.get(1).getEmailsOutboxId().intValue());
		Assert.assertEquals("Wrong EmailsId (idx=1)", 900003, dtos.get(1).getEmailsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "DELETED", dtos.get(1).getTransactionType());
		
		emailsOutboxDao.delete(5);
		emailsOutboxDao.delete(6);

		dtos = emailsOutboxDao.select(3);
		Assert.assertEquals("Wrong number of elements", 0, dtos.size());

		logger.debug(">testEmailsOutbox");
	}
	/*
	 SQL to create the test data
   INSERT INTO cirr_emails_ob (em_ob_id, em_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (4, 900001, 'INSERTED', 'admin', sysdate, 'admin', sysdate);
   INSERT INTO cirr_emails_ob (em_ob_id, em_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (5, 900002, 'UPDATED', 'admin', sysdate, 'admin', sysdate);
   INSERT INTO cirr_emails_ob (em_ob_id, em_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (6, 900003, 'DELETED', 'admin', sysdate, 'admin', sysdate);
   */

	
}
