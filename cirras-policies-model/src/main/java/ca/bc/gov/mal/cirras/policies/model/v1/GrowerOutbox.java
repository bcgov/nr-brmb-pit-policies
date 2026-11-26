package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class GrowerOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer growerOutboxId;
	private Integer growerId;

	
	public Integer getGrowerOutboxId() {
		return growerOutboxId;
	}
		
	public void setGrowerOutboxId(Integer growerOutboxId) {
		this.growerOutboxId = growerOutboxId;
	}
	
	public Integer getGrowerId() {
		return growerId;
	}
		
	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
	}

	@Override
	public String getSourceKey() {
		return growerId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return growerOutboxId;
	}
}
