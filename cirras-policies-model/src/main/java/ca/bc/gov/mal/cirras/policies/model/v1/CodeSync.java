package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface CodeSync extends Serializable {
	
 	public String getCodeTableType();
	public void setCodeTableType(String codeTableType);

	public String getUniqueKeyString();
	public void setUniqueKeyString(String uniqueKeyString);
 
 	public Integer getUniqueKeyInteger();
 	public void setUniqueKeyInteger(Integer uniqueKeyInteger);
 
 	public String getDescription();
	public void setDescription(String description);
 
 	public Boolean getIsActive();
	public void setIsActive(Boolean isActive);
	
}
