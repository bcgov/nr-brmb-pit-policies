package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeSyncDto;


public interface CommodityTypeCodeSyncDao extends Serializable {
	CommodityTypeCodeSyncDto selectByCommodityTypeCode(String commodityTypeCode) throws DaoException;
}
