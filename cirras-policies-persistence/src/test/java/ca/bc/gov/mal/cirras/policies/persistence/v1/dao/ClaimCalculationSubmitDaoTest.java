package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimCalculationSubmitDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.UserDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class ClaimCalculationSubmitDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimCalculationSubmitDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetClaim() throws Exception {
		logger.debug("<testGetClaim");

		// search
		Integer claimNumber = new Integer(23624); //23624
		ClaimCalculationSubmitDao claimCalculationSubmitDao = persistenceSpringConfig.claimCalculationSubmitDao();
		ClaimCalculationSubmitDto dto = claimCalculationSubmitDao.getClaim(claimNumber);
		Assert.assertNotNull(dto);
		
		logger.debug(">testGetClaim");
	}

	@Test
	public void testGetNonExistentClaim() throws Exception {
		logger.debug("<testGetNonExistentClaim");

		// search
		Integer claimNumber = new Integer(999999);
		ClaimCalculationSubmitDao claimCalculationSubmitDao = persistenceSpringConfig.claimCalculationSubmitDao();
		ClaimCalculationSubmitDto dto = claimCalculationSubmitDao.getClaim(claimNumber);
		Assert.assertNull(dto);

		logger.debug(">testGetNonExistentClaim");
	}
	
	
	@Test
	public void testUpdateClaim() throws Exception {
		logger.debug("<testUpdateClaim");

		// Get Claim
		Integer claimNumber = new Integer(28168); //23624 --> Must be a claim in status Open and claim type NEW
		ClaimCalculationSubmitDao claimCalculationSubmitDao = persistenceSpringConfig.claimCalculationSubmitDao();
		ClaimCalculationSubmitDto dto = claimCalculationSubmitDao.getClaim(claimNumber);
		Assert.assertNotNull(dto);
		
		// Get User
		String loginUser = "mhostett";
		UserDao dao = persistenceSpringConfig.userDao();
		UserDto dtoUser = dao.getUser(loginUser);
		Assert.assertNotNull(dtoUser);
		
		Date updateDate = new Date();
		double claimAmount = (double)12345;
		String claimStatus = "IN PROGRESS";
		String claimType = "CLAIM";

		dto.setClaimAmount(claimAmount);
		dto.setHoldbackAmount((double)0);
		dto.setClaimStatus(claimStatus);
		dto.setClaimType(claimType);
		dto.setUpdateUserid(dtoUser.getUserid());
		dto.setUsrUsrIdApprovedBy(-1);
		dto.setClaimReceived(updateDate);
		dto.setMonitoredBy(dtoUser.getUsrId());
		dto.setMonitoredDate(updateDate);
		dto.setOverwriteSavedNotice("N");
		
		claimCalculationSubmitDao.updateClaimAndPayments(dto);
		
		// Get Claim
		dto = claimCalculationSubmitDao.getClaim(claimNumber);
		Assert.assertNotNull(dto);	
		
		Assert.assertEquals("ClaimStatus", claimStatus, dto.getClaimStatus());
		Assert.assertEquals("ClaimType", claimType, dto.getClaimType());
		
		logger.debug(">testUpdateClaim");
	}
	
}
