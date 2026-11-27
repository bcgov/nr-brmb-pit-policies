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
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class TelecomOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(TelecomOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testTelecomOutbox() throws Exception {
		logger.debug("<testTelecomOutbox");

		// search
		TelecomOutboxDao telecomOutboxDao = persistenceSpringConfig.telecomOutboxDao();
		List<TelecomOutboxDto> dtos = telecomOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
	
		Assert.assertEquals("Wrong TelecomOutboxId (idx=0)", 4, dtos.get(0).getTelecomOutboxId().intValue());
		Assert.assertEquals("Wrong TelecomId (idx=0)", 900001, dtos.get(0).getTelecomId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "INSERTED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong TelecomOutboxId (idx=1)", 5, dtos.get(1).getTelecomOutboxId().intValue());
		Assert.assertEquals("Wrong TelecomId (idx=1)", 900002, dtos.get(1).getTelecomId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());

		Assert.assertEquals("Wrong TelecomOutboxId (idx=2)", 6, dtos.get(2).getTelecomOutboxId().intValue());
		Assert.assertEquals("Wrong TelecomId (idx=2)", 900003, dtos.get(2).getTelecomId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=2)", "DELETED", dtos.get(2).getTransactionType());

		telecomOutboxDao.delete(4);

		dtos = telecomOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong TelecomOutboxId (idx=0)", 5, dtos.get(0).getTelecomOutboxId().intValue());
		Assert.assertEquals("Wrong TelecomId (idx=0)", 900002, dtos.get(0).getTelecomId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong TelecomOutboxId (idx=1)", 6, dtos.get(1).getTelecomOutboxId().intValue());
		Assert.assertEquals("Wrong TelecomId (idx=1)", 900003, dtos.get(1).getTelecomId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "DELETED", dtos.get(1).getTransactionType());
		
		telecomOutboxDao.delete(5);
		telecomOutboxDao.delete(6);

		dtos = telecomOutboxDao.select(3);
		Assert.assertEquals("Wrong number of elements", 0, dtos.size());

		logger.debug(">testTelecomOutbox");
	}
	/*
	 SQL to create the test data
   INSERT INTO cirr_telecommunications_ob (tcm_ob_id, tcm_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (4, 900001, 'INSERTED', 'admin', sysdate, 'admin', sysdate);
   INSERT INTO cirr_telecommunications_ob (tcm_ob_id, tcm_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (5, 900002, 'UPDATED', 'admin', sysdate, 'admin', sysdate);
   INSERT INTO cirr_telecommunications_ob (tcm_ob_id, tcm_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (6, 900003, 'DELETED', 'admin', sysdate, 'admin', sysdate);
   */

	
}
