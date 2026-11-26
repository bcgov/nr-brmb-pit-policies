package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.ClaimMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class ClaimDaoImpl extends BaseDao implements ClaimDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ClaimDaoImpl.class);

	@Autowired
	private ClaimMapper mapper;

	
	@SuppressWarnings("unchecked")
	@Override
	public ClaimDto selectByClaimNumber(Integer claimNumber) throws DaoException {
		ClaimDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("claimNumber", claimNumber);
			parameters.put("claimId", null);
			mapper.select(parameters);
			
			List<ClaimDto> dtos = (List<ClaimDto>) parameters.get("dataCursor");

			if ( dtos != null && !dtos.isEmpty() ) {
				dto = dtos.get(0);
			}
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">selectByClaimNumber " + dto);
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClaimDto selectByClaimId(Integer claimId) throws DaoException {
		ClaimDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("claimNumber", null);
			parameters.put("claimId", claimId);
			mapper.select(parameters);
			
			List<ClaimDto> dtos = (List<ClaimDto>) parameters.get("dataCursor");
			
			if ( dtos != null && !dtos.isEmpty() ) {
				dto = dtos.get(0);
			}
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">selectByClaimId " + dto);
		return dto;
	}

}
