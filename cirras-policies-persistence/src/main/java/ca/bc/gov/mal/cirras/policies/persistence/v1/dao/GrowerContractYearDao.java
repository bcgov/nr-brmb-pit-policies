package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearDto;


public interface GrowerContractYearDao extends Serializable {
	GrowerContractYearDto selectByGrowerContractYearId(Integer growerContractYearId) throws DaoException;
}
