package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.VarietyDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.VarietyMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.VarietyDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class VarietyDaoImpl extends BaseDao implements VarietyDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(VarietyDaoImpl.class);

	@Autowired
	private VarietyMapper mapper;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<VarietyDto> select(
		Integer cropYear,
	    Integer cnId,
	    Integer ipId,
	    Integer crptId
    ) throws DaoException {
		List<VarietyDto> dtos = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("cropYear", cropYear);
			parameters.put("cnId", cnId); 
			parameters.put("ipId", ipId); 
			parameters.put("crptId", crptId); 
			mapper.select(parameters);
			
			dtos = (List<VarietyDto>) parameters.get("dataCursor");
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">select " + dtos);
		return dtos;
	}
}
