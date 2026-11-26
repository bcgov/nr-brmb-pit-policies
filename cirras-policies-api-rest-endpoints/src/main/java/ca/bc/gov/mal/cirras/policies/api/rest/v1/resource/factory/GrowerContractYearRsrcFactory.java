package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.GrowerContractYearRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerContractYear;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.GrowerContractYearFactory;
import ca.bc.gov.mal.pit.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public class GrowerContractYearRsrcFactory extends BaseResourceFactory implements GrowerContractYearFactory {
	
	@Override
	public GrowerContractYear getGrowerContractYear(GrowerContractYearDto dto) throws FactoryException {
		
		GrowerContractYearRsrc resource = new GrowerContractYearRsrc();
		
		populateResource(resource, dto);
		
		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.
		
		return resource;
	}
	
	private void populateResource(GrowerContractYearRsrc resource, GrowerContractYearDto dto) {
		resource.setGrowerContractYearId(dto.getGrowerContractYearId());
		resource.setContractId(dto.getContractId());
		resource.setGrowerId(dto.getGrowerId());
		resource.setInsurancePlanId(dto.getInsurancePlanId());
		resource.setCropYear(dto.getCropYear());
	}

}
