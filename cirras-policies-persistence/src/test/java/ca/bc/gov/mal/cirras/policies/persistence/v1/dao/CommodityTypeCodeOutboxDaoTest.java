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
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CommodityTypeCodeOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CommodityTypeCodeOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testCommodityTypeCodeOutbox() throws Exception {
		logger.debug("<testCommodityTypeCodeOutbox");

		// search
		CommodityTypeCodeOutboxDao commodityTypeCodeOutboxDao = persistenceSpringConfig.commodityTypeCodeOutboxDao();
		List<CommodityTypeCodeOutboxDto> dtos = commodityTypeCodeOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
	
		Assert.assertEquals("Wrong CommodityTypeCodeOutboxId (idx=0)", 9000001, dtos.get(0).getCommodityTypeCodeOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=0)", "Three Row", dtos.get(0).getCommodityTypeCode());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "INSERTED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong CommodityTypeCodeOutboxId (idx=1)", 9000002, dtos.get(1).getCommodityTypeCodeOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=1)", "Three Row", dtos.get(1).getCommodityTypeCode());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());

		Assert.assertEquals("Wrong CommodityTypeCodeOutboxId (idx=2)", 9000003, dtos.get(2).getCommodityTypeCodeOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=2)", "Three Row", dtos.get(2).getCommodityTypeCode());
		Assert.assertEquals("Wrong TransactionType (idx=2)", "DELETED", dtos.get(2).getTransactionType());
		
		commodityTypeCodeOutboxDao.delete(9000001);

		dtos = commodityTypeCodeOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong CommodityTypeCodeOutboxId (idx=0)", 9000002, dtos.get(0).getCommodityTypeCodeOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=0)", "Three Row", dtos.get(0).getCommodityTypeCode());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong CommodityTypeCodeOutboxId (idx=1)", 9000003, dtos.get(1).getCommodityTypeCodeOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=1)", "Three Row", dtos.get(1).getCommodityTypeCode());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "DELETED", dtos.get(1).getTransactionType());
		
		commodityTypeCodeOutboxDao.delete(9000002);
		commodityTypeCodeOutboxDao.delete(9000003);

		dtos = commodityTypeCodeOutboxDao.select(3);
		Assert.assertEquals("Wrong number of elements", 0, dtos.size());

		logger.debug(">testCommodityTypeCodeOutbox");
	}

	/*
	 SQL to create the test data
insert into cirr_commodity_type_code_ob(ctcd_ob_id, commodity_type_code, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
values (9000001, 'Three Row', 'INSERTED', 'admin', sysdate, 'admin', sysdate);

insert into cirr_commodity_type_code_ob(ctcd_ob_id, commodity_type_code, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
values (9000002, 'Three Row', 'UPDATED', 'admin', sysdate, 'admin', sysdate);

insert into cirr_commodity_type_code_ob(ctcd_ob_id, commodity_type_code, journal_transaction_type_code, entry_userid, entry_timestamp, update_userid, update_timestamp)
values (9000003, 'Three Row', 'DELETED', 'admin', sysdate, 'admin', sysdate);
   */

	
}
