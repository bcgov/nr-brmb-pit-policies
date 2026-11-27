package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeSyncDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CodeSyncDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CodeSyncDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetCodeByStrKey() throws Exception {
		logger.debug("<testGetCodeByStrKey");

		String codeTableType = "PerilTypes";
		String uniqueKeyString = "EXCESSMOISTURE";
		Integer uniqueKeyInteger = null;
		String description = "Excessive Moisture";
		Boolean active = true;

		
		CodeSyncDao codeSyncDao = persistenceSpringConfig.codeSyncDao();
		CodeSyncDto dto = codeSyncDao.selectByKey(codeTableType, uniqueKeyString, uniqueKeyInteger);
		Assert.assertNotNull(dto);
		Assert.assertEquals(codeTableType, dto.getCodeTableType());
		Assert.assertEquals(uniqueKeyString, dto.getUniqueKeyString());
		Assert.assertNull(dto.getUniqueKeyInteger());
		Assert.assertEquals(description, dto.getDescription());
		Assert.assertEquals(active, dto.getIsActive());
		
		logger.debug(">testGetCodeByStrKey");
	}
		
	@Test
	public void testGetNonexistentCodeByStrKey() throws Exception {
		logger.debug("<testGetNonexistentCodeByStrKey");

		String codeTableType = "PerilTypes";
		String uniqueKeyString = "NOSUCHCODE";
		Integer uniqueKeyInteger = null;
		
		CodeSyncDao codeSyncDao = persistenceSpringConfig.codeSyncDao();
		CodeSyncDto dto = codeSyncDao.selectByKey(codeTableType, uniqueKeyString, uniqueKeyInteger);
		Assert.assertNull(dto);
		
		logger.debug(">testGetNonexistentCodeByStrKey");
	}

	@Test
	public void testGetNonexistentCodeTableByStrKey() throws Exception {
		logger.debug("<testGetNonexistentCodeTableByStrKey");

		String codeTableType = "NoSuchTable";
		String uniqueKeyString = "EXCESSMOISTURE";
		Integer uniqueKeyInteger = null;
		
		CodeSyncDao codeSyncDao = persistenceSpringConfig.codeSyncDao();

		try 
		{
			CodeSyncDto dto = codeSyncDao.selectByKey(codeTableType, uniqueKeyString, uniqueKeyInteger);
			Assert.fail();
		}
		catch (DaoException e)
		{
			// Should throw exception for invalid code table.
		}
		
		logger.debug(">testGetNonexistentCodeTableByStrKey");
	}
	
}
