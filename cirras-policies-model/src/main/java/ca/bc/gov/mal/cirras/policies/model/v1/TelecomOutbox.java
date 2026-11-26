package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class TelecomOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer telecomOutboxId;
	private Integer telecomId;

	
	public Integer getTelecomOutboxId() {
		return telecomOutboxId;
	}
		
	public void setTelecomOutboxId(Integer telecomOutboxId) {
		this.telecomOutboxId = telecomOutboxId;
	}
	
	public Integer getTelecomId() {
		return telecomId;
	}
		
	public void setTelecomId(Integer telecomId) {
		this.telecomId = telecomId;
	}

	@Override
	public String getSourceKey() {
		return telecomId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return telecomOutboxId;
	}
	
}
