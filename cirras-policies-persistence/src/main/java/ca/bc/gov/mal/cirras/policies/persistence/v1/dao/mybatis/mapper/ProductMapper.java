package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper;

import java.util.Map;


public interface ProductMapper {
	void select(Map<String, Object> parameters);

	void selectProductsDetails(Map<String, Object> parameters);

	void selectProduct(Map<String, Object> parameters);
}
