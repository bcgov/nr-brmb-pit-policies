package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuredGrowerRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrower;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.InsuredGrowerFactory;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public class InsuredGrowerRsrcFactory extends BaseResourceFactory implements InsuredGrowerFactory {
	
	@Override
	public InsuredGrower getInsuredGrower(GrowerDto dto) throws FactoryException {
		
		InsuredGrowerRsrc resource = new InsuredGrowerRsrc();
		
		populateResource(resource, dto);
		
		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.
		
		return resource;
	}
	
	private void populateResource(InsuredGrowerRsrc resource, GrowerDto dto) {
		resource.setGrowerId(dto.getGrowerId());
		resource.setGrowerAddressLine1(dto.getGrowerAddressLine1());
		resource.setGrowerAddressLine2(dto.getGrowerAddressLine2());
		resource.setGrowerCityId(dto.getGrowerCityId());
		resource.setGrowerName(dto.getGrowerName());
		resource.setGrowerNumber(dto.getGrowerNumber());
		resource.setGrowerPostalCode(dto.getGrowerPostalCode());
		resource.setVendorNumber(dto.getVendorNumber());
		resource.setGrowerCity(dto.getGrowerCity());
		resource.setGrowerProvince(dto.getGrowerProvince());
	}

}
