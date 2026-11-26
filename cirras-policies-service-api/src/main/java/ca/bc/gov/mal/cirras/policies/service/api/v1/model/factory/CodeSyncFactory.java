package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.CodeSync;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeSyncDto;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public interface CodeSyncFactory {

	CodeSync getCodeSync(CodeSyncDto dto) throws FactoryException;
}
