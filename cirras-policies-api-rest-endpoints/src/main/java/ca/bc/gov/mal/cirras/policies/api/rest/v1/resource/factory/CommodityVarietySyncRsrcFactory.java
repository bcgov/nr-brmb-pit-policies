package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.CommodityVarietySyncRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityVarietySync;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityVarietySyncDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.CommodityVarietySyncFactory;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public class CommodityVarietySyncRsrcFactory extends BaseResourceFactory implements CommodityVarietySyncFactory {
	
	@Override
	public CommodityVarietySync getCommodityVarietySync(CommodityVarietySyncDto dto) throws FactoryException {
		
		CommodityVarietySyncRsrc resource = new CommodityVarietySyncRsrc();
		
		populateResource(resource, dto);
		
		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.
		
		return resource;
	}
	
	private void populateResource(CommodityVarietySyncRsrc resource, CommodityVarietySyncDto dto) {
		resource.setCropId(dto.getCropId());
		resource.setCropName(dto.getCropName());
		resource.setParentCropId(dto.getParentCropId());
		resource.setIsProductInsurable(dto.getIsProductInsurable());
		resource.setIsInventoryCrop(dto.getIsInventoryCrop());
		resource.setInsurancePlanId(dto.getInsurancePlanId());
		resource.setShortLabel(dto.getShortLabel());
		resource.setPlantDurationTypeCode(dto.getPlantDurationTypeCode());
		resource.setIsYieldCrop(dto.getIsYieldCrop());
		resource.setIsUnderwritingCrop(dto.getIsUnderwritingCrop());
		resource.setYieldMeasUnitTypeCode(dto.getYieldMeasUnitTypeCode());
		resource.setYieldDecimalPrecision(dto.getYieldDecimalPrecision());
		resource.setIsCropInsuranceEligible(dto.getIsCropInsuranceEligible());
		resource.setIsPlantInsuranceEligible(dto.getIsPlantInsuranceEligible());
		resource.setIsOtherInsuranceEligible(dto.getIsOtherInsuranceEligible());

	}

}
