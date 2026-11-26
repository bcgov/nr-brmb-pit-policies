package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeOutboxDto;


public interface CodeOutboxDao extends Serializable {
    List<CodeOutboxDto> select(Integer maxRecords) throws DaoException;

    void delete(String codeTableType, Integer codeOutboxId) throws DaoException, NotFoundDaoException;
}
