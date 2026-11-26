package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import ca.bc.gov.mal.cirras.policies.model.v1.ClaimCalculationSubmit;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimCalculationSubmitDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.UserDto;

public interface ClaimCalculationSubmitFactory {

	void updateClaimDto(ClaimCalculationSubmitDto dto, UserDto userDto, ClaimCalculationSubmit model);

}
