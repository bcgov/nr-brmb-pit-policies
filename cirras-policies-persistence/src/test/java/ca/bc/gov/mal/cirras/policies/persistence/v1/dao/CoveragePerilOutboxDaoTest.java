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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CoveragePerilOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CoveragePerilOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testSelectCoveragePerilOutbox() throws Exception {
		logger.debug("<testSelectCoveragePerilOutbox");

		// search
		CoveragePerilOutboxDao coveragePerilOutboxDao = persistenceSpringConfig.coveragePerilOutboxDao();
		List<CoveragePerilOutboxDto> dtos = coveragePerilOutboxDao.select(3);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong CoveragePerilOutboxId (idx=0)", 1, dtos.get(0).getCoveragePerilOutboxId().intValue());
		Assert.assertEquals("Wrong CoveragePerilId (idx=0)", 3, dtos.get(0).getCoveragePerilId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
		
		Assert.assertEquals("Wrong CoveragePerilOutboxId (idx=1)", 2, dtos.get(1).getCoveragePerilOutboxId().intValue());
		Assert.assertEquals("Wrong CoveragePerilId (idx=1)", 5, dtos.get(1).getCoveragePerilId().intValue());
		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());

		logger.debug(">testSelectCoveragePerilOutbox");
	}
	
	@Test
	public void testDeleteCoveragePerilOutbox() throws Exception {
		logger.debug("<testDeleteCoveragePerilOutbox");

		// search
		CoveragePerilOutboxDao coveragePerilOutboxDao = persistenceSpringConfig.coveragePerilOutboxDao();
		List<CoveragePerilOutboxDto> dtos = coveragePerilOutboxDao.select(2);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
	
		Assert.assertEquals("Wrong CoveragePerilOutboxId (before)", 1, dtos.get(0).getCoveragePerilOutboxId().intValue());
		Assert.assertEquals("Wrong CoveragePerilId (before)", 3, dtos.get(0).getCoveragePerilId().intValue());
		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(0).getTransactionType());

		Assert.assertEquals("Wrong CoveragePerilOutboxId (before)", 2, dtos.get(1).getCoveragePerilOutboxId().intValue());
		Assert.assertEquals("Wrong CoveragePerilId (before)", 5, dtos.get(1).getCoveragePerilId().intValue());
		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(1).getTransactionType());		
		
		coveragePerilOutboxDao.delete(1);

		dtos = coveragePerilOutboxDao.select(2);
		Assert.assertNotNull(dtos);
		Assert.assertEquals("Wrong number of elements", 1, dtos.size());
		
		Assert.assertEquals("Wrong CoveragePerilOutboxId (after)", 2, dtos.get(0).getCoveragePerilOutboxId().intValue());
		Assert.assertEquals("Wrong CoveragePerilId (after)", 5, dtos.get(0).getCoveragePerilId().intValue());
		Assert.assertEquals("Wrong TransactionType (after)", "UPDATED", dtos.get(0).getTransactionType());
		
		logger.debug(">testDeleteCoveragePerilOutbox");
	}
	
}
