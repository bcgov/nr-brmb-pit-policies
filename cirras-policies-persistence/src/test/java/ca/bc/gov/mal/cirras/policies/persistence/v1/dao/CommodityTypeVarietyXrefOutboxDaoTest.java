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
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeVarietyXrefOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CommodityTypeVarietyXrefOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CommodityTypeVarietyXrefOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testCommodityTypeVarietyXrefOutbox() throws Exception {
		logger.debug("<testCommodityTypeVarietyXrefOutbox");

		// search
		CommodityTypeVarietyXrefOutboxDao dao = persistenceSpringConfig.commodityTypeVarietyXrefOutboxDao();
		List<CommodityTypeVarietyXrefOutboxDto> dtos = dao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
	
		Assert.assertEquals("Wrong CommodityTypeVarietyXrefOutboxId (idx=0)", 9000001, dtos.get(0).getCommodityTypeVarietyXrefOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=0)", "Three Row", dtos.get(0).getCommodityTypeCode());
		Assert.assertEquals("Wrong VarietyId (idx=0)", 1010995, dtos.get(0).getVarietyId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "INSERTED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong CommodityTypeVarietyXrefOutboxId (idx=1)", 9000002, dtos.get(1).getCommodityTypeVarietyXrefOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=1)", "Three Row", dtos.get(1).getCommodityTypeCode());
		Assert.assertEquals("Wrong VarietyId (idx=1)", 1010995, dtos.get(1).getVarietyId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());

		Assert.assertEquals("Wrong CommodityTypeVarietyXrefOutboxId (idx=2)", 9000003, dtos.get(2).getCommodityTypeVarietyXrefOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=2)", "Three Row", dtos.get(2).getCommodityTypeCode());
		Assert.assertEquals("Wrong VarietyId (idx=2)", 1010995, dtos.get(2).getVarietyId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=2)", "DELETED", dtos.get(2).getTransactionType());
		
		dao.delete(9000001);

		dtos = dao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong CommodityTypeVarietyXrefOutboxId (idx=0)", 9000002, dtos.get(0).getCommodityTypeVarietyXrefOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=0)", "Three Row", dtos.get(0).getCommodityTypeCode());
		Assert.assertEquals("Wrong VarietyId (idx=0)", 1010995, dtos.get(0).getVarietyId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());

		Assert.assertEquals("Wrong CommodityTypeVarietyXrefOutboxId (idx=1)", 9000003, dtos.get(1).getCommodityTypeVarietyXrefOutboxId().intValue());
		Assert.assertEquals("Wrong CommodityTypeCode (idx=1)", "Three Row", dtos.get(1).getCommodityTypeCode());
		Assert.assertEquals("Wrong VarietyId (idx=1)", 1010995, dtos.get(1).getVarietyId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "DELETED", dtos.get(1).getTransactionType());
		
		dao.delete(9000002);
		dao.delete(9000003);

		dtos = dao.select(3);
		Assert.assertEquals("Wrong number of elements", 0, dtos.size());

		logger.debug(">testCommodityTypeVarietyXrefOutbox");
	}

	/*
	 SQL to create the test data
insert into cirr_commodity_tp_vrty_xref_ob (ctvx_ob_id,commodity_type_code,variety_crpt_id,journal_transaction_type_code,entry_userid,entry_timestamp,update_userid,update_timestamp)
values (9000001, 'Three Row', 1010995, 'INSERTED', 'admin', sysdate, 'admin', sysdate);

insert into cirr_commodity_tp_vrty_xref_ob (ctvx_ob_id,commodity_type_code,variety_crpt_id,journal_transaction_type_code,entry_userid,entry_timestamp,update_userid,update_timestamp)
values (9000002, 'Three Row', 1010995, 'UPDATED', 'admin', sysdate, 'admin', sysdate);

insert into cirr_commodity_tp_vrty_xref_ob (ctvx_ob_id,commodity_type_code,variety_crpt_id,journal_transaction_type_code,entry_userid,entry_timestamp,update_userid,update_timestamp)
values (9000003, 'Three Row', 1010995, 'DELETED', 'admin', sysdate, 'admin', sysdate);
   */

	
}
