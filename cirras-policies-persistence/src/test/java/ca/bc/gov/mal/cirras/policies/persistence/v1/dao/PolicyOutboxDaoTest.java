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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class PolicyOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PolicyOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testSelectPolicyOutbox() throws Exception {
		logger.debug("<testSelectPolicyOutbox");

		// search
		PolicyOutboxDao policyOutboxDao = persistenceSpringConfig.policyOutboxDao();
		List<PolicyOutboxDto> dtos = policyOutboxDao.select(3);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
//	
//		Assert.assertEquals("Wrong PolicyOutboxId (idx=0)", 3, dtos.get(0).getPolicyOutboxId().intValue());
//		Assert.assertEquals("Wrong PolicyId (idx=0)", 1062521, dtos.get(0).getInsurancePolicyId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
//		
//		Assert.assertEquals("Wrong PolicyOutboxId (idx=1)", 4, dtos.get(1).getPolicyOutboxId().intValue());
//		Assert.assertEquals("Wrong PolicyId (idx=1)", 1062521, dtos.get(1).getInsurancePolicyId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());
//
//		Assert.assertEquals("Wrong PolicyOutboxId (idx=2)", 5, dtos.get(2).getPolicyOutboxId().intValue());
//		Assert.assertEquals("Wrong PolicyId (idx=2)", 1062285, dtos.get(2).getInsurancePolicyId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=2)", "UPDATED", dtos.get(2).getTransactionType());
		
		logger.debug(">testSelectPolicyOutbox");
	}
	
	@Test
	public void testDeletePolicyOutbox() throws Exception {
		logger.debug("<testDeletePolicyOutbox");

		// search
		PolicyOutboxDao policyOutboxDao = persistenceSpringConfig.policyOutboxDao();
		List<PolicyOutboxDto> dtos = policyOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//	
//		Assert.assertEquals("Wrong PolicyOutboxId (before)", 3, dtos.get(0).getPolicyOutboxId().intValue());
//		Assert.assertEquals("Wrong PolicyId (before)", 1062521, dtos.get(0).getInsurancePolicyId().intValue());
//		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(0).getTransactionType());
//
//		Assert.assertEquals("Wrong PolicyOutboxId (before)", 4, dtos.get(1).getPolicyOutboxId().intValue());
//		Assert.assertEquals("Wrong PolicyId (before)", 1062521, dtos.get(1).getInsurancePolicyId().intValue());
//		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(1).getTransactionType());		
		
		policyOutboxDao.delete(3);

		dtos = policyOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//		
//		Assert.assertEquals("Wrong PolicyOutboxId (after)", 4, dtos.get(0).getPolicyOutboxId().intValue());
//		Assert.assertEquals("Wrong PolicyId (after)", 1062521, dtos.get(0).getInsurancePolicyId().intValue());
//		Assert.assertEquals("Wrong TransactionType (after)", "UPDATED", dtos.get(0).getTransactionType());
		
		logger.debug(">testDeletePolicyOutbox");
	}
	
}
