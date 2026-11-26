package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.ContactsRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.Contacts;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.ContactsFactory;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public class ContactsRsrcFactory extends BaseResourceFactory implements ContactsFactory {

	@Override
	public Contacts getContacts(ContactsDto dto) throws FactoryException {

		ContactsRsrc resource = new ContactsRsrc();

		populateResource(resource, dto);

		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.

		return resource;
	}

	private void populateResource(ContactsRsrc resource, ContactsDto dto) {

		resource.setContactsId(dto.getContactsId());
		resource.setFirstName(dto.getFirstName());
		resource.setLastName(dto.getLastName());


	}

}
