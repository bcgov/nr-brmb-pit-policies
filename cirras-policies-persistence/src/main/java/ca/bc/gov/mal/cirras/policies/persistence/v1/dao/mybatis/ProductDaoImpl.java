package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ProductDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.ProductMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class ProductDaoImpl extends BaseDao implements ProductDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	private ProductMapper mapper;

	@Override
	public List<ProductDto> selectByPolicyId(Integer insurancePolicyId) throws DaoException {
		logger.debug("<selectByPolicyId");
		
		List<ProductDto> dtos = null;

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("insurancePolicyId", insurancePolicyId);
			
			mapper.select(parameters);
			
			dtos = (List<ProductDto>) parameters.get("dataCursor");

		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">selectByPolicyId " + dtos);
		return dtos;
	}

	@Override
	public List<ProductDto> selectProductsDetailsByPolicyId(Integer insurancePolicyId, Integer productId, String commodityCoverageCode) throws DaoException {
		logger.debug("<selectProductsDetailsByPolicyId");
		
		List<ProductDto> dtos = null;

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("insurancePolicyId", insurancePolicyId);
			parameters.put("productId", productId);
			parameters.put("commodityCoverageCode", commodityCoverageCode);
			
			mapper.selectProductsDetails(parameters);			
			
			dtos = (List<ProductDto>) parameters.get("dataCursor");

		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">selectProductsDetailsByPolicyId " + dtos);
		return dtos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ProductDto selectByProductId(Integer productId) throws DaoException {

		logger.debug("<selectByProductId");
		
		ProductDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("productId", productId);
			mapper.selectProduct(parameters);

			List<ProductDto> dtos = (List<ProductDto>) parameters.get("dataCursor");
			if ( dtos != null && !dtos.isEmpty() ) {
				dto = dtos.get(0);
			}
			
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">selectByProductId " + dto);
		return dto;
	}	
}
