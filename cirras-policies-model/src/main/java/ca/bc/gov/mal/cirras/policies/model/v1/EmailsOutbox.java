package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class EmailsOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer emailsOutboxId;
	private Integer emailsId;

	
	public Integer getEmailsOutboxId() {
		return emailsOutboxId;
	}
		
	public void setEmailsOutboxId(Integer emailsOutboxId) {
		this.emailsOutboxId = emailsOutboxId;
	}
	
	public Integer getEmailsId() {
		return emailsId;
	}
		
	public void setEmailsId(Integer emailsId) {
		this.emailsId = emailsId;
	}

	@Override
	public String getSourceKey() {
		return emailsId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return emailsOutboxId;
	}
	
}
