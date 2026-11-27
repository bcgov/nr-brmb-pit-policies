package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomDto;


public interface TelecomDao extends Serializable {
	TelecomDto selectByTelecomId(Integer telecomId) throws DaoException;
}
