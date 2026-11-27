package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.TelecomDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.TelecomMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BaseDao;


@Repository
public class TelecomDaoImpl extends BaseDao implements TelecomDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(TelecomDaoImpl.class);

	@Autowired
	private TelecomMapper mapper;


	@SuppressWarnings("unchecked")
	@Override
	public TelecomDto selectByTelecomId(Integer telecomId) throws DaoException {
		TelecomDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("telecomId", telecomId);
			mapper.select(parameters);

			List<TelecomDto> dtos = (List<TelecomDto>) parameters.get("dataCursor");
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
