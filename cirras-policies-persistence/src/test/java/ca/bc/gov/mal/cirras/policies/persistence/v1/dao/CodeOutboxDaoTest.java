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

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class CodeOutboxDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CodeOutboxDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testSelectCodeOutbox() throws Exception {
		logger.debug("<testSelectCodeOutbox");

		// search
		CodeOutboxDao codeOutboxDao = persistenceSpringConfig.codeOutboxDao();
		List<CodeOutboxDto> dtos = codeOutboxDao.select(3);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 3, dtos.size());
//	
//		Assert.assertEquals("Wrong CodeTableType (idx=0)", "PerilTypes", dtos.get(0).getCodeTableType());
//		Assert.assertEquals("Wrong CodeOutboxId (idx=0)", 1, dtos.get(0).getCodeOutboxId().intValue());
//		Assert.assertEquals("Wrong UniqueKeyString (idx=0)", "TESTPERIL", dtos.get(0).getUniqueKeyString());
//		Assert.assertNull("Wrong UniqueKeyInteger (idx=0)", dtos.get(0).getUniqueKeyInteger());
//		Assert.assertEquals("Wrong TransactionType (idx=0)", "INSERTED", dtos.get(0).getTransactionType());
//		
//		Assert.assertEquals("Wrong CodeTableType (idx=1)", "PerilTypes", dtos.get(1).getCodeTableType());
//		Assert.assertEquals("Wrong CodeOutboxId (idx=1)", 3, dtos.get(1).getCodeOutboxId().intValue());
//		Assert.assertEquals("Wrong UniqueKeyString (idx=1)", "TESTPERIL", dtos.get(1).getUniqueKeyString());
//		Assert.assertNull("Wrong UniqueKeyInteger (idx=1)", dtos.get(1).getUniqueKeyInteger());
//		Assert.assertEquals("Wrong TransactionType (idx=1)", "DELETED", dtos.get(1).getTransactionType());
//
//		Assert.assertEquals("Wrong CodeTableType (idx=2)", "PerilTypes", dtos.get(2).getCodeTableType());
//		Assert.assertEquals("Wrong CodeOutboxId (idx=2)", 4, dtos.get(2).getCodeOutboxId().intValue());
//		Assert.assertEquals("Wrong UniqueKeyString (idx=2)", "FLOOD", dtos.get(2).getUniqueKeyString());
//		Assert.assertNull("Wrong UniqueKeyInteger (idx=2)", dtos.get(2).getUniqueKeyInteger());
//		Assert.assertEquals("Wrong TransactionType (idx=2)", "UPDATED", dtos.get(2).getTransactionType());
		
		logger.debug(">testSelectCodeOutbox");
	}
	
	@Test
	public void testDeleteCodeOutbox() throws Exception {
		logger.debug("<testDeleteCodeOutbox");

		// search
		CodeOutboxDao codeOutboxDao = persistenceSpringConfig.codeOutboxDao();
		List<CodeOutboxDto> dtos = codeOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//	
//		Assert.assertEquals("Wrong CodeTableType (before)", "PerilTypes", dtos.get(0).getCodeTableType());
//		Assert.assertEquals("Wrong CodeOutboxId (before)", 1, dtos.get(0).getCodeOutboxId().intValue());
//		Assert.assertEquals("Wrong UniqueKeyString (before)", "TESTPERIL", dtos.get(0).getUniqueKeyString());
//		Assert.assertNull("Wrong UniqueKeyInteger (before)", dtos.get(0).getUniqueKeyInteger());
//		Assert.assertEquals("Wrong TransactionType (before)", "INSERTED", dtos.get(0).getTransactionType());
//		
//		Assert.assertEquals("Wrong CodeTableType (before)", "PerilTypes", dtos.get(1).getCodeTableType());
//		Assert.assertEquals("Wrong CodeOutboxId (before)", 3, dtos.get(1).getCodeOutboxId().intValue());
//		Assert.assertEquals("Wrong UniqueKeyString (before)", "TESTPERIL", dtos.get(1).getUniqueKeyString());
//		Assert.assertNull("Wrong UniqueKeyInteger (before)", dtos.get(1).getUniqueKeyInteger());
//		Assert.assertEquals("Wrong TransactionType (before)", "DELETED", dtos.get(1).getTransactionType());
		
		codeOutboxDao.delete("PerilTypes", 1);

		dtos = codeOutboxDao.select(2);
//		Assert.assertNotNull(dtos);
//		Assert.assertEquals("Wrong number of elements", 2, dtos.size());
//		
//		Assert.assertEquals("Wrong CodeTableType (after)", "PerilTypes", dtos.get(0).getCodeTableType());
//		Assert.assertEquals("Wrong CodeOutboxId (after)", 3, dtos.get(0).getCodeOutboxId().intValue());
//		Assert.assertEquals("Wrong UniqueKeyString (after)", "TESTPERIL", dtos.get(0).getUniqueKeyString());
//		Assert.assertNull("Wrong UniqueKeyInteger (after)", dtos.get(0).getUniqueKeyInteger());
//		Assert.assertEquals("Wrong TransactionType (after)", "DELETED", dtos.get(0).getTransactionType());

		try 
		{
			codeOutboxDao.delete("NoSuchCodeTable", -1);
			Assert.fail();
		}
		catch (DaoException e)
		{
			//Correct.
		}
		
		logger.debug(">testDeleteCodeOutbox");
	}
	
}
