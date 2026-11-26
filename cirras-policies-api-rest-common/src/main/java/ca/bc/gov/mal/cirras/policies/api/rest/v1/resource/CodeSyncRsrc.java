package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.CodeSync;
import ca.bc.gov.mal.pit.common.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.CODE_SYNC_NAME)
@XmlSeeAlso({ CodeSyncRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class CodeSyncRsrc extends BaseResource implements CodeSync {

	private static final long serialVersionUID = 1L;

	private String codeTableType;
	private String uniqueKeyString;
	private Integer uniqueKeyInteger;
	private String description;
	private Boolean isActive;

 	public String getCodeTableType() {
		return codeTableType;
	}

	public void setCodeTableType(String codeTableType) {
		this.codeTableType = codeTableType;
	}
 
 	public String getUniqueKeyString() {
		return uniqueKeyString;
	}

	public void setUniqueKeyString(String uniqueKeyString) {
		this.uniqueKeyString = uniqueKeyString;
	}
 
 	public Integer getUniqueKeyInteger() {
		return uniqueKeyInteger;
	}

	public void setUniqueKeyInteger(Integer uniqueKeyInteger) {
		this.uniqueKeyInteger = uniqueKeyInteger;
	}
 
 	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
 
 	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
