package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsDto;


public interface InsuredGrowerContactsDao extends Serializable {
	InsuredGrowerContactsDto selectByGrowerContactsId(Integer growerContactsId) throws DaoException;
}
