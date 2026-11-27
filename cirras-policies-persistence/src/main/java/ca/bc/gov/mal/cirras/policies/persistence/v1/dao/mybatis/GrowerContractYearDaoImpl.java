package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerContractYearDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.GrowerContractYearMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class GrowerContractYearDaoImpl extends BaseDao implements GrowerContractYearDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(GrowerContractYearDaoImpl.class);

	@Autowired
	private GrowerContractYearMapper mapper;


	@SuppressWarnings("unchecked")
	@Override
	public GrowerContractYearDto selectByGrowerContractYearId(Integer growerContractYearId) throws DaoException {
		GrowerContractYearDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("growerContractYearId", growerContractYearId);
			mapper.select(parameters);

			List<GrowerContractYearDto> dtos = (List<GrowerContractYearDto>) parameters.get("dataCursor");
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
