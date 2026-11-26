package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.UserDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.UserMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.UserDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private UserMapper mapper;

	
	@SuppressWarnings("unchecked")
	@Override
	public UserDto getUser(String loginUserId) throws DaoException {

		logger.debug("<getUser");
		
		UserDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("loginUserId", loginUserId);
			mapper.select(parameters);
			
			List<UserDto> dtos = (List<UserDto>) parameters.get("dataCursor");

			if ( dtos != null && !dtos.isEmpty() ) {
				dto = dtos.get(0);
			}
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">getUser " + dto);
		return dto;
	}

	

}
