package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.EmailsRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.Emails;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.EmailsDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.EmailsFactory;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public class EmailsRsrcFactory extends BaseResourceFactory implements EmailsFactory {

	@Override
	public Emails getEmails(EmailsDto dto) throws FactoryException {

		EmailsRsrc resource = new EmailsRsrc();

		populateResource(resource, dto);

		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.

		return resource;
	}

	private void populateResource(EmailsRsrc resource, EmailsDto dto) {

		resource.setEmailsId(dto.getEmailsId());
		resource.setContactsId(dto.getContactsId());
		resource.setEmailAddress(dto.getEmailAddress());
		resource.setIsPrimaryEmailInd(dto.getIsPrimaryEmailInd());
		resource.setIsActive(dto.getIsActive());

	}

}
