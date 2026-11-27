package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface Emails extends Serializable {

 	public Integer getEmailsId();
	public void setEmailsId(Integer emailsId);
 
 	public Integer getContactsId();
	public void setContactsId(Integer contactsId);
 
 	public String getEmailAddress();
	public void setEmailAddress(String emailAddress);
 
 	public Boolean getIsPrimaryEmailInd();
	public void setIsPrimaryEmailInd(Boolean isPrimaryEmailInd);
 
 	public Boolean getIsActive();
	public void setIsActive(Boolean isActive);
 
}
