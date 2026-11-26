package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyOutboxDto;


public interface PolicyOutboxDao extends Serializable {
    List<PolicyOutboxDto> select(Integer maxRecords) throws DaoException;

    void delete(Integer policyOutboxId) throws DaoException, NotFoundDaoException;
}
