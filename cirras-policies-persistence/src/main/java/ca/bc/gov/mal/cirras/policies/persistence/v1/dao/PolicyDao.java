package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyDto;


public interface PolicyDao extends Serializable {
	PolicyDto selectByPolicyId(Integer insurancePolicyId) throws DaoException;
}
