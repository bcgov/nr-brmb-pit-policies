package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilOutboxDto;


public interface CoveragePerilOutboxDao extends Serializable {
    List<CoveragePerilOutboxDto> select(Integer maxRecords) throws DaoException;

    void delete(Integer coveragePerilOutboxId) throws DaoException, NotFoundDaoException;
}
