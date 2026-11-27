package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilOutboxDto;


public interface CoveragePerilOutboxMapper {
	//TODO: Should this be void?
	List<CoveragePerilOutboxDto> select(Map<String, Object> parameters);

	int delete(Map<String, Object> parameters);
}
