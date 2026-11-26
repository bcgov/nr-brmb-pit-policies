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
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class InsuredGrowerContactsOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(InsuredGrowerContactsOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testInsuredGrowerContactsOutbox() throws Exception {
		logger.debug("<testInsuredGrowerContactsOutbox");

		// search
		InsuredGrowerContactsOutboxDao insuredGrowerContactsOutboxDao = persistenceSpringConfig.insuredGrowerContactsOutboxDao();
		List<InsuredGrowerContactsOutboxDto> dtos = insuredGrowerContactsOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
	
		Assert.assertEquals("Wrong InsuredGrowerContactsOutboxId (idx=0)", 4, dtos.get(0).getInsuredGrowerContactsOutboxId().intValue());
		Assert.assertEquals("Wrong InsuredGrowerContactsId (idx=0)", 900001, dtos.get(0).getInsuredGrowerContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "INSERTED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong InsuredGrowerContactsOutboxId (idx=1)", 5, dtos.get(1).getInsuredGrowerContactsOutboxId().intValue());
		Assert.assertEquals("Wrong InsuredGrowerContactsId (idx=1)", 900002, dtos.get(1).getInsuredGrowerContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());

		Assert.assertEquals("Wrong InsuredGrowerContactsOutboxId (idx=2)", 6, dtos.get(2).getInsuredGrowerContactsOutboxId().intValue());
		Assert.assertEquals("Wrong InsuredGrowerContactsId (idx=2)", 900003, dtos.get(2).getInsuredGrowerContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=2)", "DELETED", dtos.get(2).getTransactionType());

		insuredGrowerContactsOutboxDao.delete(4);

		dtos = insuredGrowerContactsOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong InsuredGrowerContactsOutboxId (idx=0)", 5, dtos.get(0).getInsuredGrowerContactsOutboxId().intValue());
		Assert.assertEquals("Wrong InsuredGrowerContactsId (idx=0)", 900002, dtos.get(0).getInsuredGrowerContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong InsuredGrowerContactsOutboxId (idx=1)", 6, dtos.get(1).getInsuredGrowerContactsOutboxId().intValue());
		Assert.assertEquals("Wrong InsuredGrowerContactsId (idx=1)", 900003, dtos.get(1).getInsuredGrowerContactsId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "DELETED", dtos.get(1).getTransactionType());
		
		insuredGrowerContactsOutboxDao.delete(5);
		insuredGrowerContactsOutboxDao.delete(6);

		dtos = insuredGrowerContactsOutboxDao.select(3);
		Assert.assertEquals("Wrong number of elements", 0, dtos.size());

		logger.debug(">testInsuredGrowerContactsOutbox");
	}
	/*
	 SQL to create the test data
   INSERT INTO cirr_insured_grower_contacts_ob (igc_ob_id, igc_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (4, 900001, 'INSERTED', 'admin', sysdate, 'admin', sysdate);
   INSERT INTO cirr_insured_grower_contacts_ob (igc_ob_id, igc_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (5, 900002, 'UPDATED', 'admin', sysdate, 'admin', sysdate);
   INSERT INTO cirr_insured_grower_contacts_ob (igc_ob_id, igc_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
   VALUES (6, 900003, 'DELETED', 'admin', sysdate, 'admin', sysdate);
   */

	
}
