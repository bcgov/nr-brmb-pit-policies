package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class PolicyOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer policyOutboxId;
	private Integer insurancePolicyId;

	
	public Integer getPolicyOutboxId() {
		return policyOutboxId;
	}
		
	public void setPolicyOutboxId(Integer policyOutboxId) {
		this.policyOutboxId = policyOutboxId;
	}
	
	public Integer getInsurancePolicyId() {
		return insurancePolicyId;
	}
		
	public void setInsurancePolicyId(Integer insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}

	@Override
	public String getSourceKey() {
		return insurancePolicyId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return policyOutboxId;
	}
}
