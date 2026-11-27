package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class InsuredGrowerContactsOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer insuredGrowerContactsOutboxId;
	private Integer insuredGrowerContactsId;

	
	public Integer getInsuredGrowerContactsOutboxId() {
		return insuredGrowerContactsOutboxId;
	}
		
	public void setInsuredGrowerContactsOutboxId(Integer insuredGrowerContactsOutboxId) {
		this.insuredGrowerContactsOutboxId = insuredGrowerContactsOutboxId;
	}
	
	public Integer getInsuredGrowerContactsId() {
		return insuredGrowerContactsId;
	}
		
	public void setInsuredGrowerContactsId(Integer insuredGrowerContactsId) {
		this.insuredGrowerContactsId = insuredGrowerContactsId;
	}

	@Override
	public String getSourceKey() {
		return insuredGrowerContactsId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return insuredGrowerContactsOutboxId;
	}
	
}
