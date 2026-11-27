package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrower;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerDto;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public interface InsuredGrowerFactory {

	InsuredGrower getInsuredGrower(GrowerDto dto) throws FactoryException;
}
