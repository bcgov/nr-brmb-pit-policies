package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrowerContacts;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsDto;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public interface InsuredGrowerContactsFactory {

	InsuredGrowerContacts getInsuredGrowerContacts(InsuredGrowerContactsDto dto) throws FactoryException;
}
