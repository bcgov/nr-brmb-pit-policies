package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CoveragePerilSyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.CoveragePerilSyncMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilSyncDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class CoveragePerilSyncDaoImpl extends BaseDao implements CoveragePerilSyncDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CoveragePerilSyncDaoImpl.class);

	@Autowired
	private CoveragePerilSyncMapper mapper;


	@SuppressWarnings("unchecked")
	@Override
	public CoveragePerilSyncDto selectByCoveragePerilId(Integer coveragePerilId) throws DaoException {
		CoveragePerilSyncDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("coveragePerilId", coveragePerilId);
			mapper.select(parameters);

			List<CoveragePerilSyncDto> dtos = (List<CoveragePerilSyncDto>) parameters.get("dataCursor");
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
