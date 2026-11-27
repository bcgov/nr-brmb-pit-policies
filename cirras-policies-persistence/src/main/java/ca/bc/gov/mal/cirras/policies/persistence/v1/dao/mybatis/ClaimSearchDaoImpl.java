package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimSearchDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.ClaimSearchMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.TooManyRecordsException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;
import ca.bc.gov.mal.pit.common.persistence.dto.PagedDtos;


@Repository
public class ClaimSearchDaoImpl extends BaseDao implements ClaimSearchDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ClaimSearchDaoImpl.class);

	@Autowired
	private ClaimSearchMapper mapper;

	
	@Override
	public List<ClaimSearchDto> searchClaims(
    		Integer claimNumber,
        	String policyNumber
        ) throws DaoException {
		
		List<ClaimSearchDto> dtos = null;

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("claimNumber", claimNumber);
			parameters.put("policyNumber", policyNumber);
			
			mapper.select(parameters);
			
			dtos = (List<ClaimSearchDto>) parameters.get("dataCursor");

		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">searchClaims " + dtos);
		return dtos;
	}
}
