package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;


public interface ClaimDao extends Serializable {
    ClaimDto selectByClaimNumber(Integer claimNumber) throws DaoException;
    ClaimDto selectByClaimId(Integer claimId) throws DaoException;
}
