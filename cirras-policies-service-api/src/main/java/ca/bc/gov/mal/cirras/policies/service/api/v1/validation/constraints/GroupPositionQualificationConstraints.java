package ca.bc.gov.mal.cirras.policies.service.api.v1.validation.constraints;

import ca.bc.gov.mal.cirras.policies.service.api.v1.validation.Errors;

import jakarta.validation.constraints.NotBlank;

public interface GroupPositionQualificationConstraints {
	@NotBlank(message=Errors.RESOURCE_POSITION_QUALIFICATION_CLASS_NAME_NOTBLANK, groups= GroupPositionQualificationConstraints.class)
	public String getResourceClassificationName();

}
