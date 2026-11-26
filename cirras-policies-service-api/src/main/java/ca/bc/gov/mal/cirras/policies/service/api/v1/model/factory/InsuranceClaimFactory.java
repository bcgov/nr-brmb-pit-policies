package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import java.util.List;

import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaim;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaimList;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryContext;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public interface InsuranceClaimFactory {

	InsuranceClaim getInsuranceClaim(
		ClaimDto dto, 
		boolean createSelfLink,
		FactoryContext context, 
		WebAdeAuthentication authentication
	) throws FactoryException;
	
	InsuranceClaimList<? extends InsuranceClaim> getClaimCalculationList(
		List<ClaimSearchDto> dtos,
		Integer claimNumber,
		String policyNumber,
		FactoryContext context, 
		WebAdeAuthentication authentication
	) 
	throws FactoryException, DaoException;
	
}
