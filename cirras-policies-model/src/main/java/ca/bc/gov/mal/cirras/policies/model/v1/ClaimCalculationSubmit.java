package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface ClaimCalculationSubmit extends Serializable {

	public Integer getClaimNumber();
	public void setClaimNumber(Integer claimNumber);

 	public Double getClaimAmount();
	public void setClaimAmount(Double claimAmount);

 	public String getUserId();
	public void setUserId(String userId);
}
