package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityVarietySyncDto;


public interface CommodityVarietySyncDao extends Serializable {
	CommodityVarietySyncDto selectByCropId(Integer cropId) throws DaoException;
}
