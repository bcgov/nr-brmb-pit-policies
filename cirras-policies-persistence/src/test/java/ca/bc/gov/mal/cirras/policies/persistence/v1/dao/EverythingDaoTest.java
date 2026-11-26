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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ClaimSearchDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductNolDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.VarietyDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class EverythingDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(EverythingDaoTest.class);
	
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
//	@Test
//	public void testGetEverything() throws Exception {
//		// search
//		Integer claimNumber = new Integer(27773);
//		ClaimSearchDao claimSearchDao = persistenceSpringConfig.claimSearchDao();
//		List<ClaimSearchDto> dtos = claimSearchDao.select(claimNumber); 
//		Assert.assertEquals(1, dtos.size());
//		
//		ClaimSearchDto claimSearchDto = dtos.get(0);
//		Assert.assertEquals(claimNumber.intValue(), claimSearchDto.getClaimNumber().intValue());
//		Assert.assertEquals("OTQIMTFJC, USDED", claimSearchDto.getGrowersLegalName());
//		
//		// claim
//		Integer colId = claimSearchDto.getClaimNumber();
//		ClaimDao claimDao = persistenceSpringConfig.claimDao();
//		ClaimDto claimDto = claimDao.select(colId);
//		Assert.assertEquals(colId.intValue(), claimDto.getColId().intValue());
//		Assert.assertEquals(claimNumber.intValue(), claimDto.getClaimNumber().intValue());
//		
//		// grower
////		Integer igId = claimSearchDto.getIgId();
////		GrowerDao growerDao = persistenceSpringConfig.growerDao();
////		GrowerDto growerDto = growerDao.select(igId);
////		Assert.assertEquals(igId.intValue(), growerDto.getIgId().intValue());
////		Assert.assertEquals(claimSearchDto.getGrowersLegalName(), growerDto.getGrowersLegalName());
//		
//		// product purchase
//		Integer insurancePlanId = claimSearchDto.getInsurancePlanId();
//		ProductPurchaseDao productPurchaseDao = persistenceSpringConfig.productPurchaseDao();
//		List<ProductPurchaseDto> productPurchases = productPurchaseDao.select(insurancePlanId);
//		Assert.assertEquals(3, productPurchases.size());
//		
//		logger.debug("claimDto.getCnId() = " + claimDto.getCnId());
//		logger.debug("claimDto.getIpId() = " + claimDto.getIpId());
//		logger.debug("claimDto.getCrptId() = " + claimDto.getCrptId());
//		logger.debug("claimDto.getCcCcId() = " + claimDto.getCcCcId());
//		
//		// varieties
//		VarietyInsurableValueDao varietyInsurableValueDao = persistenceSpringConfig.varietyInsurableValueDao();
//		List<VarietyInsurableValueDto> vatieties = varietyInsurableValueDao.select(
//			claimDto.getCropYear(),
//			claimDto.getCnId(),
//			claimDto.getIpId(),
//			claimDto.getCrptId(),
//			claimDto.getCcCcId()
//		);
//		Assert.assertEquals(11, vatieties.size());
//		
//		for(VarietyInsurableValueDto v: vatieties) {
//			Assert.assertNotNull(v.getVarietyCrptId());
//			Assert.assertNotNull(v.getAveragePrice());
//		}
//		
//		// product nols
//		ProductNolDao productNolDao = persistenceSpringConfig.productNolDao();
//		List<ProductNolDto> productNols = productNolDao.select(insurancePlanId);
//		Assert.assertEquals(2, productNols.size());
//	}
}
