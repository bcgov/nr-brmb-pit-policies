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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class ClaimOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testSelectClaimOutbox() throws Exception {
		logger.debug("<testSelectClaimOutbox");

		// search
		ClaimOutboxDao claimOutboxDao = persistenceSpringConfig.claimOutboxDao();
		List<ClaimOutboxDto> dtos = claimOutboxDao.select(3);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
//	
//		Assert.assertEquals("Wrong ClaimOutboxId (idx=0)", 1, dtos.get(0).getClaimOutboxId().intValue());
//		Assert.assertEquals("Wrong ClaimId (idx=0)", 1038127, dtos.get(0).getClaimId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
//		
//		Assert.assertEquals("Wrong ClaimOutboxId (idx=1)", 2, dtos.get(1).getClaimOutboxId().intValue());
//		Assert.assertEquals("Wrong ClaimId (idx=1)", 1038127, dtos.get(1).getClaimId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());
//
//		Assert.assertEquals("Wrong ClaimOutboxId (idx=2)", 3, dtos.get(2).getClaimOutboxId().intValue());
//		Assert.assertEquals("Wrong ClaimId (idx=2)", 1038293, dtos.get(2).getClaimId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=2)", "UPDATED", dtos.get(2).getTransactionType());
		
		logger.debug(">testSelectClaimOutbox");
	}
	
	@Test
	public void testDeleteClaimOutbox() throws Exception {
		logger.debug("<testDeleteClaimOutbox");

		// search
		ClaimOutboxDao claimOutboxDao = persistenceSpringConfig.claimOutboxDao();
		List<ClaimOutboxDto> dtos = claimOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//	
//		Assert.assertEquals("Wrong ClaimOutboxId (before)", 1, dtos.get(0).getClaimOutboxId().intValue());
//		Assert.assertEquals("Wrong ClaimId (before)", 1038127, dtos.get(0).getClaimId().intValue());
//		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(0).getTransactionType());
//
//		Assert.assertEquals("Wrong ClaimOutboxId (before)", 2, dtos.get(1).getClaimOutboxId().intValue());
//		Assert.assertEquals("Wrong ClaimId (before)", 1038127, dtos.get(1).getClaimId().intValue());
//		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(1).getTransactionType());		
		
		claimOutboxDao.delete(1);

		dtos = claimOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//		
//		Assert.assertEquals("Wrong ClaimOutboxId (after)", 2, dtos.get(0).getClaimOutboxId().intValue());
//		Assert.assertEquals("Wrong ClaimId (after)", 1038127, dtos.get(0).getClaimId().intValue());
//		Assert.assertEquals("Wrong TransactionType (after)", "UPDATED", dtos.get(0).getTransactionType());
		
		logger.debug(">testDeleteClaimOutbox");
	}
	
}
