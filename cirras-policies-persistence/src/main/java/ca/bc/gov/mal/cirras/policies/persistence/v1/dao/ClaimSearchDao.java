package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.TooManyRecordsException;
import ca.bc.gov.mal.pit.common.persistence.dto.PagedDtos;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;


public interface ClaimSearchDao extends Serializable {

    List<ClaimSearchDto> searchClaims(
    		Integer claimNumber,
        	String policyNumber
        ) throws DaoException;


}
