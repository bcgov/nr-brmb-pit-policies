package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuredGrowerContactsRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrowerContacts;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.InsuredGrowerContactsFactory;
import ca.bc.gov.mal.pit.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public class InsuredGrowerContactsRsrcFactory extends BaseResourceFactory implements InsuredGrowerContactsFactory {

	@Override
	public InsuredGrowerContacts getInsuredGrowerContacts(InsuredGrowerContactsDto dto) throws FactoryException {

		InsuredGrowerContactsRsrc resource = new InsuredGrowerContactsRsrc();

		populateResource(resource, dto);

		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.

		return resource;
	}

	private void populateResource(InsuredGrowerContactsRsrc resource, InsuredGrowerContactsDto dto) {

		resource.setGrowerContactsId(dto.getGrowerContactsId());
		resource.setGrowerId(dto.getGrowerId());
		resource.setContactsId(dto.getContactsId());
		resource.setIsPrimaryContactInd(dto.getIsPrimaryContactInd());
		resource.setIsActivelyInvolvedInd(dto.getIsActivelyInvolvedInd());

	}

}
