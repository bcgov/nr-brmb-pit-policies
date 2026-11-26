package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class ContactsOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer contactsOutboxId;
	private Integer contactsId;

	
	public Integer getContactsOutboxId() {
		return contactsOutboxId;
	}
		
	public void setContactsOutboxId(Integer contactsOutboxId) {
		this.contactsOutboxId = contactsOutboxId;
	}
	
	public Integer getContactsId() {
		return contactsId;
	}
		
	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}

	@Override
	public String getSourceKey() {
		return contactsId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return contactsOutboxId;
	}
	
}
