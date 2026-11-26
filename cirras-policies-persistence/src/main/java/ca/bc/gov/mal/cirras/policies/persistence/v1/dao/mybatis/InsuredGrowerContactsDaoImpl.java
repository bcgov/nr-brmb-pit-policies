package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.InsuredGrowerContactsDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.InsuredGrowerContactsMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class InsuredGrowerContactsDaoImpl extends BaseDao implements InsuredGrowerContactsDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(InsuredGrowerContactsDaoImpl.class);

	@Autowired
	private InsuredGrowerContactsMapper mapper;


	@SuppressWarnings("unchecked")
	@Override
	public InsuredGrowerContactsDto selectByGrowerContactsId(Integer growerContactsId) throws DaoException {
		InsuredGrowerContactsDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("growerContactsId", growerContactsId);
			mapper.select(parameters);

			List<InsuredGrowerContactsDto> dtos = (List<InsuredGrowerContactsDto>) parameters.get("dataCursor");
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
