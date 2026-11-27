package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.CodeSyncRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.CodeSync;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeSyncDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.CodeSyncFactory;
import ca.bc.gov.mal.pit.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public class CodeSyncRsrcFactory extends BaseResourceFactory implements CodeSyncFactory {
	
	@Override
	public CodeSync getCodeSync(CodeSyncDto dto) throws FactoryException {
		
		CodeSyncRsrc resource = new CodeSyncRsrc();
		
		populateResource(resource, dto);
		
		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.
		
		return resource;
	}
	
	private void populateResource(CodeSyncRsrc resource, CodeSyncDto dto) {
		resource.setCodeTableType(dto.getCodeTableType());
		resource.setUniqueKeyString(dto.getUniqueKeyString());
		resource.setUniqueKeyInteger(dto.getUniqueKeyInteger());
		resource.setDescription(dto.getDescription());
		resource.setIsActive(dto.getIsActive());
	}
}
