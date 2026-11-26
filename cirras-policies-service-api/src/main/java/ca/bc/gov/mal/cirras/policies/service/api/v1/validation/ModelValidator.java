package ca.bc.gov.mal.cirras.policies.service.api.v1.validation;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.cirras.policies.model.v1.ClaimCalculationSubmit;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimCalculationSubmitDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.UserDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.util.CachedCodeTables;
import ca.bc.gov.mal.cirras.policies.service.api.v1.util.PoliciesServiceEnums;
import ca.bc.gov.mal.pit.common.model.Message;
import ca.bc.gov.mal.pit.common.persistence.code.dto.CodeDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.service.api.validation.BaseValidator;
import ca.bc.gov.mal.pit.common.utils.MessageBuilder;


public class ModelValidator extends BaseValidator {
	
	private static final Logger logger = LoggerFactory.getLogger(ModelValidator.class);

	private CachedCodeTables cachedCodeTables;

	//TODO need to update to handle custom code tables otherwise fails on fetch
	//    Currently fails on custom code table WILDFIRE_RESOURCE_TYPE_CODE
	public List<Message> validateCode(String codeTableName, String value, LocalDate effectiveAsOfDate, String propertyName, String message) throws DaoException {
		
		List<Message> results = new ArrayList<>();

		if (value != null && value.trim().length()>0) {
			
			CodeDto codeDto = this.cachedCodeTables.get(codeTableName, value, effectiveAsOfDate);
			
			if(codeDto==null) {

				MessageBuilder messageBuilder = new MessageBuilder(propertyName, 
						message, 
						message);
				
				messageBuilder.addArg("value", value);
				
				results.add(messageBuilder.getMessage());
			}
		}

		return results;
	}
	
	public List<Message> validateSubmitClaimCalculation(
			ClaimCalculationSubmit claimCalculationSubmit,
			UserDto userDto, 
			ClaimCalculationSubmitDto claimDto
			) throws DaoException {
		
		List<Message> results = new ArrayList<>();
		String path = "Policies-Api-Submit-Claim-Calculation";
		
		if(userDto == null) {
			String message = "User does not exist in CIRRAS. Add the user in CIRRAS and assign a role to resolve this issue.";
			MessageBuilder messageBuilder = new MessageBuilder(
					path, 
					message, 
					message);
			messageBuilder.addArg("User Login", claimCalculationSubmit.getUserId());
			
			results.add(messageBuilder.getMessage());
		}
		
		if(claimDto != null) {
			//claim amount > total coverage
			if(claimDto.getTotalCoverage() != null && claimCalculationSubmit.getClaimAmount() > claimDto.getTotalCoverage()) {
				String message = "Claim amount cannot be higher than the total coverage in CIRRAS. Refresh the calculation to resolve this issue.";
				MessageBuilder messageBuilder = new MessageBuilder(
						path, 
						message, 
						message);
				messageBuilder.addArg("Claim Amount", claimCalculationSubmit.getClaimAmount());
				messageBuilder.addArg("Total Coverage", claimDto.getTotalCoverage());

				results.add(messageBuilder.getMessage());
			}
			
			//holdback amount > claim amount 
			if(claimDto.getHoldbackAmount() != null && claimDto.getHoldbackAmount() > claimCalculationSubmit.getClaimAmount()) {
				String message = "There exists at least one holdback amount that is greater than the total claim amount. Please update the holdback amount in the claim in CIRRAS.";
				MessageBuilder messageBuilder = new MessageBuilder(
						path, 
						message, 
						message);
				messageBuilder.addArg("Claim Amount", claimCalculationSubmit.getClaimAmount());
				messageBuilder.addArg("Holdback Amount", claimDto.getHoldbackAmount());

				results.add(messageBuilder.getMessage());
			}
			
			
			//Status and type check
			Boolean hasChequeReq = claimDto.getHasChequeReqInd();
			Boolean claimStatusIncorrect = false;
			Boolean claimTypeIncorrect = false;
			String correctClaimStatusMessage = PoliciesServiceEnums.ClaimStatusCodes.Open.getCode();
			String correctClaimTypeMessage = PoliciesServiceEnums.ClaimType.New.getClaimType();
			//Status incorrect if
			//no cheque req and not in status Open
			//OR there is a cheque req and not in status In Progress
			if((hasChequeReq == false && claimDto.getClaimStatus().equalsIgnoreCase(PoliciesServiceEnums.ClaimStatusCodes.Open.getCode()) == false)
					|| (hasChequeReq == true && claimDto.getClaimStatus().equalsIgnoreCase(PoliciesServiceEnums.ClaimStatusCodes.InProgress.getCode()) == false)) {
				claimStatusIncorrect = true;
			}
		
			//Type incorrect if
			//no cheque req and not in type New
			//OR there is a cheque req and not in type Claim or Zero Claim
			if((hasChequeReq == false && claimDto.getClaimType().equalsIgnoreCase(PoliciesServiceEnums.ClaimType.New.getClaimType()) == false)
					|| (hasChequeReq == true 
						&& claimDto.getClaimType().equalsIgnoreCase(PoliciesServiceEnums.ClaimType.Claim.getClaimType()) == false
						&&  claimDto.getClaimType().equalsIgnoreCase(PoliciesServiceEnums.ClaimType.ZeroClaim.getClaimType()) == false)) {
				claimTypeIncorrect = true;
			}
			
			if(hasChequeReq == true) {
				correctClaimStatusMessage = PoliciesServiceEnums.ClaimStatusCodes.InProgress.getCode();
				correctClaimTypeMessage = PoliciesServiceEnums.ClaimType.Claim.getClaimType() + " or " + PoliciesServiceEnums.ClaimType.ZeroClaim.getClaimType();
			}
			

			if(claimStatusIncorrect == true && claimTypeIncorrect == true) {
				String message = "Claim Status has to be " + correctClaimStatusMessage + " and Claim Type has to be " + correctClaimTypeMessage + ". Roll back the claim in CIRRAS to resolve this issue.";
				MessageBuilder messageBuilder = new MessageBuilder(
						path, 
						message, 
						message);
				messageBuilder.addArg("Claim Status", claimDto.getClaimStatus());
				messageBuilder.addArg("Claim Type", claimDto.getClaimType());

				results.add(messageBuilder.getMessage());
				
			} else if(claimStatusIncorrect == true) {
				String message = "Claim Status has to be " + correctClaimStatusMessage + ". Roll back the claim in CIRRAS to resolve this issue.";
				MessageBuilder messageBuilder = new MessageBuilder(
						path, 
						message, 
						message);
				messageBuilder.addArg("Claim Status", claimDto.getClaimStatus());

				results.add(messageBuilder.getMessage());

			} else if(claimTypeIncorrect == true) {
				String message = "Claim Type has to be " + correctClaimTypeMessage + ". Roll back the claim in CIRRAS to resolve this issue.";
				MessageBuilder messageBuilder = new MessageBuilder(
						path, 
						message, 
						message);
				messageBuilder.addArg("Claim Type", claimDto.getClaimType());

				results.add(messageBuilder.getMessage());

			}
		
		}
		return results;
	}
	

	/*
	public List<Message> validateCreateWildfireResource(WildfireResource<?> resource, LocalDate effectiveAsOfDate) {
		logger.debug("<validateCreateWildfireResource");
		Class<?>[] groups = new Class<?>[] {WildfireResourceConstraints.class};

		List<Message> results = this.validate(resource, groups);
		
		logger.debug(">validateCreateWildfireResource " + results.size());
		return results;
	}
	*/


	protected static List<Message> addParentPath(List<Message> messages, String parentPath) {
		
		for(Message message:messages) {
			
			addParentPath(message, parentPath);
		}
		
		return messages;
	}
	
	public static Message addParentPath(Message message, String parentPath) {
		
		String path = message.getPath();
		path = (path == null) ? "" : path;
		path = parentPath + "." + path;
		message.setPath(path);
		
		return message;
	}

	public void setCachedCodeTables(CachedCodeTables cachedCodeTables) {
		this.cachedCodeTables = cachedCodeTables;
	}
}
