package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerOutboxDto;


public interface GrowerOutboxDao extends Serializable {
    List<GrowerOutboxDto> select(Integer maxRecords) throws DaoException;

    void delete(Integer growerOutboxId) throws DaoException, NotFoundDaoException;
}
