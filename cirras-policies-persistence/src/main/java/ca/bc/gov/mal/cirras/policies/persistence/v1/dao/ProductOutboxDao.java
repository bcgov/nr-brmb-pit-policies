package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductOutboxDto;


public interface ProductOutboxDao extends Serializable {
    List<ProductOutboxDto> select(Integer maxRecords) throws DaoException;

    void delete(Integer productOutboxId) throws DaoException, NotFoundDaoException;
}
