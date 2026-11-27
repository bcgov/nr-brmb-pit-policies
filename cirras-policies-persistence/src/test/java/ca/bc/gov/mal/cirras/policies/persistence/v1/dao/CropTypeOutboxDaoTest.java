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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CropTypeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CropTypeOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CropTypeOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testSelectCropTypeOutbox() throws Exception {
		logger.debug("<testSelectCropTypeOutbox");

		// search
		CropTypeOutboxDao cropTypeOutboxDao = persistenceSpringConfig.cropTypeOutboxDao();
		List<CropTypeOutboxDto> dtos = cropTypeOutboxDao.select(3);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
//	
//		Assert.assertEquals("Wrong CropTypeOutboxId (idx=0)", 1, dtos.get(0).getCropTypeOutboxId().intValue());
//		Assert.assertEquals("Wrong CropId (idx=0)", 3, dtos.get(0).getCropId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=0)", "UPDATED", dtos.get(0).getTransactionType());
//		
//		Assert.assertEquals("Wrong CropTypeOutboxId (idx=1)", 3, dtos.get(1).getCropTypeOutboxId().intValue());
//		Assert.assertEquals("Wrong CropId (idx=1)", 5, dtos.get(1).getCropId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=1)", "UPDATED", dtos.get(1).getTransactionType());
//
//		Assert.assertEquals("Wrong CropTypeOutboxId (idx=2)", 4, dtos.get(2).getCropTypeOutboxId().intValue());
//		Assert.assertEquals("Wrong CropId (idx=2)", 7, dtos.get(2).getCropId().intValue());
//		Assert.assertEquals("Wrong TransactionType (idx=2)", "UPDATED", dtos.get(2).getTransactionType());
		
		logger.debug(">testSelectCropTypeOutbox");
	}
	
	@Test
	public void testDeleteCropTypeOutbox() throws Exception {
		logger.debug("<testDeleteCropTypeOutbox");

		// search
		CropTypeOutboxDao cropTypeOutboxDao = persistenceSpringConfig.cropTypeOutboxDao();
		List<CropTypeOutboxDto> dtos = cropTypeOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//	
//		Assert.assertEquals("Wrong CropTypeOutboxId (before)", 1, dtos.get(0).getCropTypeOutboxId().intValue());
//		Assert.assertEquals("Wrong CropId (before)", 3, dtos.get(0).getCropId().intValue());
//		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(0).getTransactionType());
//
//		Assert.assertEquals("Wrong CropTypeOutboxId (before)", 3, dtos.get(1).getCropTypeOutboxId().intValue());
//		Assert.assertEquals("Wrong CropId (before)", 5, dtos.get(1).getCropId().intValue());
//		Assert.assertEquals("Wrong TransactionType (before)", "UPDATED", dtos.get(1).getTransactionType());		
		
		cropTypeOutboxDao.delete(1);

		dtos = cropTypeOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//		
//		Assert.assertEquals("Wrong CropTypeOutboxId (after)", 3, dtos.get(0).getCropTypeOutboxId().intValue());
//		Assert.assertEquals("Wrong CropId (after)", 5, dtos.get(0).getCropId().intValue());
//		Assert.assertEquals("Wrong TransactionType (after)", "UPDATED", dtos.get(0).getTransactionType());
		
		logger.debug(">testDeleteCropTypeOutbox");
	}
	
}
