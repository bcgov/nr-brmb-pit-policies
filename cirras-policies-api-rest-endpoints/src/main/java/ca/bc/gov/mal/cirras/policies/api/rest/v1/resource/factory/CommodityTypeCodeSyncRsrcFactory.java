package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.CommodityTypeCodeSyncRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeCodeSync;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeSyncDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.CommodityTypeCodeSyncFactory;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public class CommodityTypeCodeSyncRsrcFactory extends BaseResourceFactory implements CommodityTypeCodeSyncFactory {

	@Override
	public CommodityTypeCodeSync getCommodityTypeCodeSync(CommodityTypeCodeSyncDto dto) throws FactoryException {

		CommodityTypeCodeSyncRsrc resource = new CommodityTypeCodeSyncRsrc();

		populateResource(resource, dto);

		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.

		return resource;
	}

	private void populateResource(CommodityTypeCodeSyncRsrc resource, CommodityTypeCodeSyncDto dto) {

		resource.setCommodityTypeCode(dto.getCommodityTypeCode());
		resource.setCropId(dto.getCropId());
		resource.setDescription(dto.getDescription());
		resource.setIsActive(dto.getIsActive());

	}

}
