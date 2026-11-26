package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.EmailsOutboxDto;


public interface EmailsOutboxDao extends Serializable {
    List<EmailsOutboxDto> select(Integer maxRecords) throws DaoException;

    void delete(Integer emailsOutboxId) throws DaoException, NotFoundDaoException;
}
