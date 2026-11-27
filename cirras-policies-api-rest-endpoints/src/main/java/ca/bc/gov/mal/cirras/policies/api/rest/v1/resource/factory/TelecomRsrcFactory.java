package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.TelecomRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.Telecom;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.TelecomFactory;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public class TelecomRsrcFactory extends BaseResourceFactory implements TelecomFactory {

	@Override
	public Telecom getTelecom(TelecomDto dto) throws FactoryException {

		TelecomRsrc resource = new TelecomRsrc();

		populateResource(resource, dto);

		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.

		return resource;
	}

	private void populateResource(TelecomRsrc resource, TelecomDto dto) {

		resource.setTelecomId(dto.getTelecomId());
		resource.setContactsId(dto.getContactsId());
		resource.setPhoneNumber(dto.getPhoneNumber());
		resource.setExtension(dto.getExtension());
		resource.setIsPrimaryPhoneInd(dto.getIsPrimaryPhoneInd());
		resource.setTelecomTypeCode(dto.getTelecomTypeCode());
		resource.setIsActive(dto.getIsActive());

	}

}
