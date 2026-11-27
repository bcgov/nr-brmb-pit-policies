package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface InsuredGrowerContacts extends Serializable {

 	public Integer getGrowerContactsId();
	public void setGrowerContactsId(Integer growerContactsId);
 
 	public Integer getGrowerId();
	public void setGrowerId(Integer growerId);
 
 	public Integer getContactsId();
	public void setContactsId(Integer contactsId);
 
 	public Boolean getIsPrimaryContactInd();
	public void setIsPrimaryContactInd(Boolean isPrimaryContactInd);
 
 	public Boolean getIsActivelyInvolvedInd();
	public void setIsActivelyInvolvedInd(Boolean isActivelyInvolvedInd);
 
}
