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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class GrowerContractYearOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(GrowerContractYearOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGrowerContractYearOutbox() throws Exception {
		logger.debug("<testGrowerContractYearOutbox");

		// search
		GrowerContractYearOutboxDao growerContractYearOutboxDao = persistenceSpringConfig.growerContractYearOutboxDao();
		List<GrowerContractYearOutboxDto> dtos = growerContractYearOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
	
		Assert.assertEquals("Wrong GrowerContractYearOutboxId (idx=0)", 4, dtos.get(0).getGrowerContractYearOutboxId().intValue());
		Assert.assertEquals("Wrong GrowerContractYearId (idx=0)", 900001, dtos.get(0).getGrowerContractYearId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "INSERTED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong GrowerContractYearOutboxId (idx=1)", 5, dtos.get(1).getGrowerContractYearOutboxId().intValue());
		Assert.assertEquals("Wrong GrowerContractYearId (idx=1)", 900002, dtos.get(1).getGrowerContractYearId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());

		Assert.assertEquals("Wrong GrowerContractYearOutboxId (idx=2)", 6, dtos.get(2).getGrowerContractYearOutboxId().intValue());
		Assert.assertEquals("Wrong GrowerContractYearId (idx=2)", 900003, dtos.get(2).getGrowerContractYearId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=2)", "DELETED", dtos.get(2).getTransactionType());

		growerContractYearOutboxDao.delete(4);

		dtos = growerContractYearOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong GrowerContractYearOutboxId (idx=0)", 5, dtos.get(0).getGrowerContractYearOutboxId().intValue());
		Assert.assertEquals("Wrong GrowerContractYearId (idx=0)", 900002, dtos.get(0).getGrowerContractYearId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong GrowerContractYearOutboxId (idx=1)", 6, dtos.get(1).getGrowerContractYearOutboxId().intValue());
		Assert.assertEquals("Wrong GrowerContractYearId (idx=1)", 900003, dtos.get(1).getGrowerContractYearId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "DELETED", dtos.get(1).getTransactionType());

		growerContractYearOutboxDao.delete(5);
		growerContractYearOutboxDao.delete(6);

		dtos = growerContractYearOutboxDao.select(3);
		Assert.assertEquals("Wrong number of elements", 0, dtos.size());

		logger.debug(">testGrowerContractYearOutbox");
	}
	
	/*
	 SQL to create the test data
	 	INSERT INTO CIRR_GROWER_CONTRACT_YEARS_OB (gcy_ob_id, grower_contract_year_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
		VALUES (4, 900001, 'INSERTED', 'admin', sysdate, 'admin', sysdate);
		INSERT INTO CIRR_GROWER_CONTRACT_YEARS_OB (gcy_ob_id, grower_contract_year_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
		VALUES (5, 900002, 'UPDATED', 'admin', sysdate, 'admin', sysdate);
		INSERT INTO CIRR_GROWER_CONTRACT_YEARS_OB (gcy_ob_id, grower_contract_year_id, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
		VALUES (6, 900003, 'DELETED', 'admin', sysdate, 'admin', sysdate);
*/
	
}
