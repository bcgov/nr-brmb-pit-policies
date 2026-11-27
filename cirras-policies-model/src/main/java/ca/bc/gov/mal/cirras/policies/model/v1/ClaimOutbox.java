package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class ClaimOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer claimOutboxId;
	private Integer claimId;

	
	public Integer getClaimOutboxId() {
		return claimOutboxId;
	}
		
	public void setClaimOutboxId(Integer claimOutboxId) {
		this.claimOutboxId = claimOutboxId;
	}
	
	public Integer getClaimId() {
		return claimId;
	}
		
	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}

	@Override
	public String getSourceKey() {
		return claimId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return claimOutboxId;
	}
	
}
