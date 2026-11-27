package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilSyncDto;


public interface CoveragePerilSyncDao extends Serializable {
	CoveragePerilSyncDto selectByCoveragePerilId(Integer coveragePerilId) throws DaoException;
}
