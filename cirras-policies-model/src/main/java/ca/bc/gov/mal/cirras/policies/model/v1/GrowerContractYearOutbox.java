package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class GrowerContractYearOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer growerContractYearOutboxId;
	private Integer growerContractYearId;

	
	public Integer getGrowerContractYearOutboxId() {
		return growerContractYearOutboxId;
	}
		
	public void setGrowerContractYearOutboxId(Integer growerContractYearOutboxId) {
		this.growerContractYearOutboxId = growerContractYearOutboxId;
	}
	
	public Integer getGrowerContractYearId() {
		return growerContractYearId;
	}
		
	public void setGrowerContractYearId(Integer growerContractYearId) {
		this.growerContractYearId = growerContractYearId;
	}

	@Override
	public String getSourceKey() {
		return growerContractYearId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return growerContractYearOutboxId;
	}
}
