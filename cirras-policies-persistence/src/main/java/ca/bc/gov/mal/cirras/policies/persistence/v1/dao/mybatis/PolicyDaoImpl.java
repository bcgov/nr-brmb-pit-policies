package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.PolicyDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.PolicyMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BaseDao;


@Repository
public class PolicyDaoImpl extends BaseDao implements PolicyDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(PolicyDaoImpl.class);

	@Autowired
	private PolicyMapper mapper;


	@SuppressWarnings("unchecked")
	@Override
	public PolicyDto selectByPolicyId(Integer insurancePolicyId) throws DaoException {
		PolicyDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("insurancePolicyId", insurancePolicyId);
			mapper.select(parameters);

			List<PolicyDto> dtos = (List<PolicyDto>) parameters.get("dataCursor");
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
