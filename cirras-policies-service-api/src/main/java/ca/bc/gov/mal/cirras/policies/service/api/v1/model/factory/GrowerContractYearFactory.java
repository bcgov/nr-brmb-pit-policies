package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.GrowerContractYear;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearDto;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public interface GrowerContractYearFactory {

	GrowerContractYear getGrowerContractYear(GrowerContractYearDto dto) throws FactoryException;
}
