package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.Contacts;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsDto;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public interface ContactsFactory {

	Contacts getContacts(ContactsDto dto) throws FactoryException;
}
