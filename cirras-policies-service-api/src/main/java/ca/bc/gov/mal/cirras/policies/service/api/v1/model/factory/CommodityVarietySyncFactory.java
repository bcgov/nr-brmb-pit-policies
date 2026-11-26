package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.CommodityVarietySync;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityVarietySyncDto;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public interface CommodityVarietySyncFactory {

	CommodityVarietySync getCommodityVarietySync(CommodityVarietySyncDto dto) throws FactoryException;
}
