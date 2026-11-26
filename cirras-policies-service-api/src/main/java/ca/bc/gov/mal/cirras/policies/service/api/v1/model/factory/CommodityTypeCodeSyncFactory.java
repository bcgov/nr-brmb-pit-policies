package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeCodeSync;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeSyncDto;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public interface CommodityTypeCodeSyncFactory {

	CommodityTypeCodeSync getCommodityTypeCodeSync(CommodityTypeCodeSyncDto dto) throws FactoryException;
}
