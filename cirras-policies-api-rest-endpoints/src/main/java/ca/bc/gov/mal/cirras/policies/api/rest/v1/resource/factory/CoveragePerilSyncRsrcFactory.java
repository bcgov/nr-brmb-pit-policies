package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.CoveragePerilSyncRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.CoveragePerilSync;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilSyncDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.CoveragePerilSyncFactory;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public class CoveragePerilSyncRsrcFactory extends BaseResourceFactory implements CoveragePerilSyncFactory {

	@Override
	public CoveragePerilSync getCoveragePerilSync(CoveragePerilSyncDto dto) throws FactoryException {

		CoveragePerilSyncRsrc resource = new CoveragePerilSyncRsrc();

		populateResource(resource, dto);

		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.

		return resource;
	}

	private void populateResource(CoveragePerilSyncRsrc resource, CoveragePerilSyncDto dto) {

		resource.setCoveragePerilId(dto.getCoveragePerilId());
		resource.setCropCommodityId(dto.getCropCommodityId());
		resource.setPerilCode(dto.getPerilCode());
		resource.setCommodityCoverageCode(dto.getCommodityCoverageCode());
		resource.setCropCommodityId(dto.getCropCommodityId());
		resource.setIsActive(dto.getIsActive());

	}

}
