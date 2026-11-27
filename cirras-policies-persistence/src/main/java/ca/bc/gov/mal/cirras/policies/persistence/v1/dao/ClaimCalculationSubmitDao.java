package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.NotFoundDaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimCalculationSubmitDto;


public interface ClaimCalculationSubmitDao extends Serializable {
	ClaimCalculationSubmitDto getClaim(Integer claimNumber) throws DaoException;

	void updateClaimAndPayments(ClaimCalculationSubmitDto dto) throws DaoException, NotFoundDaoException;
}
