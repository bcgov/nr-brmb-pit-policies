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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class ClaimSearchDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimSearchDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testClaimSearch() throws Exception {
		logger.debug("<testClaimSearch");

		// search
		Integer claimNumber = new Integer(3082); //3082
		String policyNumber = null;//"401837-06";
		ClaimSearchDao claimSearchDao = persistenceSpringConfig.claimSearchDao();
		List<ClaimSearchDto> dtos = claimSearchDao.searchClaims(claimNumber, policyNumber);
		Assert.assertEquals(1, dtos.size());

		logger.debug(">testClaimSearch");
	}
}
