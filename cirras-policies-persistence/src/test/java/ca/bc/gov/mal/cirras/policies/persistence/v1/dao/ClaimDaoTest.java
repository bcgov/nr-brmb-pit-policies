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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.VarietyDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class ClaimDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetClaim() throws Exception {
		logger.debug("<testGetClaim");

		// search
		Integer claimNumber = new Integer(28027);
		ClaimDao claimDao = persistenceSpringConfig.claimDao();
		ClaimDto dto = claimDao.selectByClaimNumber(claimNumber);
		Assert.assertNotNull(dto);
		Assert.assertEquals(claimNumber, dto.getClaimNumber());
		//Assert.assertEquals(dto.getCalculateIivInd(), "N");
		
		//Get varieties
		VarietyDao varietyDao = persistenceSpringConfig.varietyDao();
		List<VarietyDto> varietyDtos = varietyDao.select(
				dto.getCropYear(),
				dto.getContractId(),
				dto.getInsurancePlanId(),
				dto.getCropCommodityId()
			);		

		Assert.assertNotNull(varietyDtos);

		logger.debug(">testGetClaim");
	}

	@Test
	public void testGetNonExistentClaim() throws Exception {
		logger.debug("<testGetNonExistentClaim");

		// search
		Integer claimNumber = new Integer(999999);
		ClaimDao claimDao = persistenceSpringConfig.claimDao();
		ClaimDto dto = claimDao.selectByClaimNumber(claimNumber);
		Assert.assertNull(dto);

		logger.debug(">testGetNonExistentClaim");
	}
	
	
	@Test
	public void testGetBerriesPlantClaim() throws Exception {
		logger.debug("<testGetBerriesPlantClaim");

		// search blueberry
		Integer claimNumber = new Integer(28201); //blueberry: 28201; strawberry: 28061
		ClaimDao claimDao = persistenceSpringConfig.claimDao();
		ClaimDto dto = claimDao.selectByClaimNumber(claimNumber);
		Assert.assertNotNull(dto);
		Assert.assertEquals(claimNumber, dto.getClaimNumber());
//		claim: 28201
//		units: 47,353.00
//		IV: 4
//		Deductible: 5
//		measurement: UNITS		
		
		// search strawberry
		claimNumber = new Integer(28061); //blueberry: 28201; strawberry: 28061
		dto = claimDao.selectByClaimNumber(claimNumber);
		Assert.assertNotNull(dto);
		Assert.assertEquals(claimNumber, dto.getClaimNumber());
		
		logger.debug(">testGetBerriesPlantClaim");
		
//		claim: 28061
//		units: 2
//		IV: 3430
//		Deductible: 10
//		measurement: ACRES
	}

	@Test
	public void testGetClaimById() throws Exception {
		logger.debug("<testGetClaimById");

		// search
		Integer claimId = new Integer(1038084);
		Integer policyId = new Integer(1062003);

		ClaimDao claimDao = persistenceSpringConfig.claimDao();
		ClaimDto dto = claimDao.selectByClaimId(claimId);
		Assert.assertNotNull(dto);
		Assert.assertEquals(claimId, dto.getClaimId());
		Assert.assertEquals(policyId, dto.getInsurancePolicyId());
		
		logger.debug(">testGetClaimById");
	}

	@Test
	public void testGetNonexistentClaimById() throws Exception {
		logger.debug("<testGetNonexistentClaimById");

		// search
		Integer claimId = new Integer(9999999);
		ClaimDao claimDao = persistenceSpringConfig.claimDao();
		ClaimDto dto = claimDao.selectByClaimId(claimId);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentClaimById");
	}

	@Test
	public void testGetClaimHasChequeReqInd() throws Exception {
		logger.debug("<testGetClaimHasChequeReqInd");

		// search
		Integer claimNumber = new Integer(28084);
		Boolean hasChequeReqInd = Boolean.FALSE;

		ClaimDao claimDao = persistenceSpringConfig.claimDao();
		ClaimDto dto = claimDao.selectByClaimNumber(claimNumber);
		Assert.assertNotNull(dto);
		Assert.assertEquals(claimNumber, dto.getClaimNumber());
		Assert.assertEquals(hasChequeReqInd, dto.getHasChequeReqInd());

		claimNumber = new Integer(25528);
		hasChequeReqInd = Boolean.TRUE;
		
		dto = claimDao.selectByClaimNumber(claimNumber);
		Assert.assertNotNull(dto);
		Assert.assertEquals(claimNumber, dto.getClaimNumber());
		Assert.assertEquals(hasChequeReqInd, dto.getHasChequeReqInd());
		
		logger.debug(">testGetClaimHasChequeReqInd");
	}	
	
}
