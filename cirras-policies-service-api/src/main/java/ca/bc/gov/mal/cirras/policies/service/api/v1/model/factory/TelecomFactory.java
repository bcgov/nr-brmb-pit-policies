package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.Telecom;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomDto;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public interface TelecomFactory {

	Telecom getTelecom(TelecomDto dto) throws FactoryException;
}
