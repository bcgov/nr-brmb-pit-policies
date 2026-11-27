package ca.bc.gov.mal.cirras.policies.service.api.v1.validation.constraints;

import ca.bc.gov.mal.cirras.policies.service.api.v1.validation.Errors;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface GroupTemplatePositionConstraints {
	@NotBlank(message=Errors.RESOURCE_GROUP_POSITION_NAME_NOTBLANK, groups= GroupTemplatePositionConstraints.class)
	@Size(min=1, max=4000, message=Errors.RESOURCE_GROUP_POSITION_NAME_SIZE, groups= GroupTemplatePositionConstraints.class)
	public String getPositionName();

}
