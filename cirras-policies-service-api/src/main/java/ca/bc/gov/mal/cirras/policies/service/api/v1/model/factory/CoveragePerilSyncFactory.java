package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.CoveragePerilSync;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilSyncDto;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public interface CoveragePerilSyncFactory {

	CoveragePerilSync getCoveragePerilSync(CoveragePerilSyncDto dto) throws FactoryException;
}
