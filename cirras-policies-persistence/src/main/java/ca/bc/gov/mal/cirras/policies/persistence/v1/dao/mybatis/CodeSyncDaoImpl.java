package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CodeSyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.CodeSyncMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeSyncDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BaseDao;


@Repository
public class CodeSyncDaoImpl extends BaseDao implements CodeSyncDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CodeSyncDaoImpl.class);

	@Autowired
	private CodeSyncMapper mapper;


	@SuppressWarnings("unchecked")
	@Override
	public CodeSyncDto selectByKey(String codeTableType, String uniqueKeyString, Integer uniqueKeyInteger) throws DaoException {
		CodeSyncDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("codeTableType", codeTableType);
			parameters.put("uniqueKeyString", uniqueKeyString);
			parameters.put("uniqueKeyInteger", uniqueKeyInteger);
			mapper.select(parameters);

			List<CodeSyncDto> dtos = (List<CodeSyncDto>) parameters.get("dataCursor");
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
