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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class GrowerOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(GrowerOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testSelectGrowerOutbox() throws Exception {
		logger.debug("<testSelectGrowerOutbox");

		// search
		GrowerOutboxDao growerOutboxDao = persistenceSpringConfig.growerOutboxDao();
		List<GrowerOutboxDto> dtos = growerOutboxDao.select(3);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
//	
//		Assert.assertEquals("Wrong GrowerOutboxId (idx=0)", 1, dtos.get(0).getGrowerOutboxId().intValue());
//		Assert.assertEquals("Wrong GrowerId (idx=0)", 4665, dtos.get(0).getGrowerId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
//		
//		Assert.assertEquals("Wrong GrowerOutboxId (idx=1)", 3, dtos.get(1).getGrowerOutboxId().intValue());
//		Assert.assertEquals("Wrong GrowerId (idx=1)", 6630, dtos.get(1).getGrowerId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());
//
//		Assert.assertEquals("Wrong GrowerOutboxId (idx=2)", 4, dtos.get(2).getGrowerOutboxId().intValue());
//		Assert.assertEquals("Wrong GrowerId (idx=2)", 6630, dtos.get(2).getGrowerId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=2)", "UPDATED", dtos.get(2).getTransactionType());
		
		logger.debug(">testSelectGrowerOutbox");
	}
	
	@Test
	public void testDeleteGrowerOutbox() throws Exception {
		logger.debug("<testDeleteGrowerOutbox");

		// search
		GrowerOutboxDao growerOutboxDao = persistenceSpringConfig.growerOutboxDao();
		List<GrowerOutboxDto> dtos = growerOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//	
//		Assert.assertEquals("Wrong GrowerOutboxId (before)", 1, dtos.get(0).getGrowerOutboxId().intValue());
//		Assert.assertEquals("Wrong GrowerId (before)", 4665, dtos.get(0).getGrowerId().intValue());
//		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(0).getTransactionType());
//
//		Assert.assertEquals("Wrong GrowerOutboxId (before)", 3, dtos.get(1).getGrowerOutboxId().intValue());
//		Assert.assertEquals("Wrong GrowerId (before)", 6630, dtos.get(1).getGrowerId().intValue());
//		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(1).getTransactionType());		
		
		growerOutboxDao.delete(1);

		dtos = growerOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//		
//		Assert.assertEquals("Wrong GrowerOutboxId (after)", 3, dtos.get(0).getGrowerOutboxId().intValue());
//		Assert.assertEquals("Wrong GrowerId (after)", 6630, dtos.get(0).getGrowerId().intValue());
//		Assert.assertEquals("Wrong TransactionType (after)", "UPDATED", dtos.get(0).getTransactionType());
		
		logger.debug(">testDeleteGrowerOutbox");
	}
	
}
