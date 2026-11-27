package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface Telecom extends Serializable {

 	public Integer getTelecomId();
	public void setTelecomId(Integer telecomId);
 
 	public Integer getContactsId();
	public void setContactsId(Integer contactsId);
 
 	public String getPhoneNumber();
	public void setPhoneNumber(String phoneNumber);
 
 	public String getExtension();
	public void setExtension(String extension);
 
 	public Boolean getIsPrimaryPhoneInd();
	public void setIsPrimaryPhoneInd(Boolean isPrimaryPhoneInd);
 
 	public String getTelecomTypeCode();
	public void setTelecomTypeCode(String telecomTypeCode);
 
 	public Boolean getIsActive();
	public void setIsActive(Boolean isActive);
 
}
