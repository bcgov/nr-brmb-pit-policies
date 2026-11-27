package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeOutboxDto;


public interface CodeOutboxMapper {
	//TODO: Should this be void?
	List<CodeOutboxDto> select(Map<String, Object> parameters);

	int delete(Map<String, Object> parameters);
}
