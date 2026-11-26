package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper;

import java.util.Map;


public interface GrowerContractYearOutboxMapper {

	void select(Map<String, Object> parameters);

	int delete(Map<String, Object> parameters);
}
