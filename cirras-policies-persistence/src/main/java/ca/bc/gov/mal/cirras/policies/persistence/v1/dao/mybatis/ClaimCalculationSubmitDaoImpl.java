package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimCalculationSubmitDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.ClaimCalculationSubmitMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimCalculationSubmitDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BaseDao;


@Repository
public class ClaimCalculationSubmitDaoImpl extends BaseDao implements ClaimCalculationSubmitDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ClaimCalculationSubmitDaoImpl.class);

	@Autowired
	private ClaimCalculationSubmitMapper mapper;

	
	@SuppressWarnings("unchecked")
	@Override
	public ClaimCalculationSubmitDto getClaim(Integer claimNumber) throws DaoException {

		logger.debug("<getClaim");
		
		ClaimCalculationSubmitDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("claimNumber", claimNumber);
			mapper.select(parameters);
			
			List<ClaimCalculationSubmitDto> dtos = (List<ClaimCalculationSubmitDto>) parameters.get("dataCursor");

			if ( dtos != null && !dtos.isEmpty() ) {
				dto = dtos.get(0);
			}
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">getClaim " + dto);
		return dto;
	}
	
	@Override
	public void updateClaimAndPayments(ClaimCalculationSubmitDto dto) throws DaoException, NotFoundDaoException {
		logger.debug("<updateClaimAndPayments");
		
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("dto", dto);
			this.mapper.updateClaimAndPayments(parameters);

		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">updateClaimAndPayments");
	}	

	

}
