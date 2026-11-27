package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.UserDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.spring.PersistenceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class, PersistenceSpringConfig.class})
public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Autowired 
	private PersistenceSpringConfig persistenceSpringConfig;

	@Test
	public void testGetUser() throws Exception {
		logger.debug("<testGetUser");

		// search
		String loginUser = "mhostett";
		UserDao dao = persistenceSpringConfig.userDao();
		UserDto dto = dao.getUser(loginUser);
		Assert.assertNotNull(dto);
		
		logger.debug(">testGetUser");
	}

	@Test
	public void testGetNonExistentUser() throws Exception {
		logger.debug("<testGetNonExistentUser");

		// search
		String loginUser = "nonsense";
		UserDao dao = persistenceSpringConfig.userDao();
		UserDto dto = dao.getUser(loginUser);
		Assert.assertNull(dto);

		logger.debug(">testGetNonExistentUser");
	}
	
	
}
