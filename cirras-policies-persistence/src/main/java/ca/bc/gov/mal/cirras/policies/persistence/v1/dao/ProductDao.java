package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import java.io.Serializable;
import java.util.List;

import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductDto;


public interface ProductDao extends Serializable {
	List<ProductDto> selectByPolicyId(Integer insurancePolicyId) throws DaoException;

	List<ProductDto> selectProductsDetailsByPolicyId(Integer insurancePolicyId, Integer productId, String commodityCoverageCode) throws DaoException;
	
	ProductDto selectByProductId(Integer productId) throws DaoException;
}
