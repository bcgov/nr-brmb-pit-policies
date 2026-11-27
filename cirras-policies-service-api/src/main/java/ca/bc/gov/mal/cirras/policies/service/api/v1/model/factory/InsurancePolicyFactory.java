package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.InsurancePolicy;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyDto;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public interface InsurancePolicyFactory {

	InsurancePolicy getInsurancePolicy(PolicyDto dto) throws FactoryException;
}
