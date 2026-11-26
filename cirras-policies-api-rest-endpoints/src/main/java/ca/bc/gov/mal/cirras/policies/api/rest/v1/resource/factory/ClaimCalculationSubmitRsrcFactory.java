package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import java.util.Date;

import ca.bc.gov.mal.cirras.policies.model.v1.ClaimCalculationSubmit;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimCalculationSubmitDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.UserDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.ClaimCalculationSubmitFactory;
import ca.bc.gov.mal.cirras.policies.service.api.v1.util.PoliciesServiceEnums;
import ca.bc.gov.mal.pit.common.rest.endpoints.resource.factory.BaseResourceFactory;

public class ClaimCalculationSubmitRsrcFactory extends BaseResourceFactory implements ClaimCalculationSubmitFactory {
	
	@Override
	public void updateClaimDto(ClaimCalculationSubmitDto dto, UserDto userDto, ClaimCalculationSubmit model) {

		//Set claim type to Claim if the claim amount is greater 0. Else set it to Zero Claim
		if(model.getClaimAmount() > 0) {
			dto.setClaimType(PoliciesServiceEnums.ClaimType.Claim.getClaimType());
		} else {
			dto.setClaimType(PoliciesServiceEnums.ClaimType.ZeroClaim.getClaimType());
			//holdback amount is set to 0 if it's a zero claim, no matter if the claim has been amended or not 
			dto.setHoldbackAmount((double)0); 
		}

		//These fields are only updated if the claim is in status open (no payments, not amended)
		if(dto.getClaimStatus().equalsIgnoreCase(PoliciesServiceEnums.ClaimStatusCodes.Open.getCode())) {
			dto.setClaimReceived(new Date());
			dto.setMonitoredBy(userDto.getUsrId());
			dto.setMonitoredDate(new Date());
			dto.setHoldbackAmount((double)0); 
		}

		dto.setClaimAmount(model.getClaimAmount());
		dto.setClaimStatus(PoliciesServiceEnums.ClaimStatusCodes.InProgress.getCode());
		dto.setUpdateUserid(userDto.getUserid());
		dto.setUsrUsrIdApprovedBy(-1); //Never approved when submitting - Needs to be -1 because of the stored procedure
		dto.setOverwriteSavedNotice("N"); //Always N
		

	}
	
}
