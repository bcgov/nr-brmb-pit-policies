package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface Contacts extends Serializable {

 	public Integer getContactsId();
	public void setContactsId(Integer contactsId);
 
 	public String getFirstName();
	public void setFirstName(String firstName);
 
 	public String getLastName();
	public void setLastName(String lastName);
	
}
