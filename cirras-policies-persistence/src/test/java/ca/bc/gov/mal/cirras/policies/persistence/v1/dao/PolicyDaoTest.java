package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class PolicyDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PolicyDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetPolicyById() throws Exception {
		logger.debug("<testGetPolicyById");

		Integer insurancePolicyId = 1062521;
		Integer growerId = 541861;
		Integer insurancePlanId = 3;
		Integer contractId = 723946;
		Integer cropYear = 2021;
		Integer officeId = 1;
		

		PolicyDao policyDao = persistenceSpringConfig.policyDao();
		PolicyDto dto = policyDao.selectByPolicyId(insurancePolicyId);
		Assert.assertNotNull(dto);
		Assert.assertEquals(insurancePolicyId, dto.getInsurancePolicyId());
		Assert.assertEquals(growerId, dto.getGrowerId());
		Assert.assertEquals("PANORA ANITA NORA CRAIG TYRONE HENRY OSCAR", dto.getGrowerName());
		Assert.assertEquals(insurancePlanId, dto.getInsurancePlanId());
		Assert.assertEquals(contractId, dto.getContractId());
		Assert.assertEquals(cropYear, dto.getCropYear());
		Assert.assertEquals(officeId, dto.getOfficeId());
		Assert.assertEquals("ACTIVE", dto.getPolicyStatusCode());
		Assert.assertEquals("711877-21", dto.getPolicyNumber());
		Assert.assertEquals("711877", dto.getContractNumber());
		
		logger.debug(">testGetPolicyById");
	}

	@Test
	public void testGetNonexistentPolicyById() throws Exception {
		logger.debug("<testGetNonexistentPolicyById");

		// search
		Integer insurancePolicyId = 999999;
		PolicyDao policyDao = persistenceSpringConfig.policyDao();
		PolicyDto dto = policyDao.selectByPolicyId(insurancePolicyId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentPolicyById");
	}

}
