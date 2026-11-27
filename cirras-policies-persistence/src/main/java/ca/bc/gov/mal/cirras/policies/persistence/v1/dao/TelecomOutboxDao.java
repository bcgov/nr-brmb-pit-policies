package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomOutboxDto;


public interface TelecomOutboxDao extends Serializable {
    List<TelecomOutboxDto> select(Integer maxRecords) throws DaoException;

    void delete(Integer telecomOutboxId) throws DaoException, NotFoundDaoException;
}
