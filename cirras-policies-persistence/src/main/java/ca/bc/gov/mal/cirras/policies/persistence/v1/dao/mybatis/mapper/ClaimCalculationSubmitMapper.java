package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper;

import java.util.Map;


public interface ClaimCalculationSubmitMapper {
	void select(Map<String, Object> parameters);
	
	void updateClaimAndPayments(Map<String, Object> parameters);

}
