package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.Emails;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.EmailsDto;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public interface EmailsFactory {

	Emails getEmails(EmailsDto dto) throws FactoryException;
}
