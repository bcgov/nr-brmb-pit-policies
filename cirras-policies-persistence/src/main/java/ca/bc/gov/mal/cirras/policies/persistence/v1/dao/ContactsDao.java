package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsDto;


public interface ContactsDao extends Serializable {
	ContactsDto selectByContactsId(Integer contactsId) throws DaoException;
}
