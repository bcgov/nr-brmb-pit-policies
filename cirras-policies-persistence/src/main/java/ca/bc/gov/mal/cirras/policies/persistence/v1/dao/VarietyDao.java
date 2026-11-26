package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.VarietyDto;

public interface VarietyDao extends Serializable {
    List<VarietyDto> select(
    	Integer cropYear,
    	Integer cnId,
    	Integer ipId,
    	Integer crptId
    ) throws DaoException;
}
