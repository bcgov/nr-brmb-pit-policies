package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeSyncDto;


public interface CodeSyncDao extends Serializable {
	CodeSyncDto selectByKey(String codeTableType, String uniqueKeyString, Integer uniqueKeyInteger) throws DaoException;
}
