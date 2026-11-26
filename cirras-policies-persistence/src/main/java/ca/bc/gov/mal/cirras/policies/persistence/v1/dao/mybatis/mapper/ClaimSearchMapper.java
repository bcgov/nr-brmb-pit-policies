package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;


public interface ClaimSearchMapper {
	
	List<ClaimSearchDto> select(Map<String, Object> parameters);

}
