package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.GrowerMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BaseDao;


@Repository
public class GrowerDaoImpl extends BaseDao implements GrowerDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(GrowerDaoImpl.class);

	@Autowired
	private GrowerMapper mapper;


	@SuppressWarnings("unchecked")
	@Override
	public GrowerDto selectByGrowerId(Integer growerId) throws DaoException {
		GrowerDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("growerId", growerId);
			mapper.select(parameters);

			List<GrowerDto> dtos = (List<GrowerDto>) parameters.get("dataCursor");
			if ( dtos != null && !dtos.isEmpty() ) {
				dto = dtos.get(0);
			}
			
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">select " + dto);
		return dto;
	}
}
