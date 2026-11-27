package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.Telecom;
import ca.bc.gov.nrs.common.wfone.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.TELECOM_NAME)
@XmlSeeAlso({ TelecomRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class TelecomRsrc extends BaseResource implements Telecom {

	private static final long serialVersionUID = 1L;

	private Integer telecomId;
	private Integer contactsId;
	private String phoneNumber;
	private String extension;
	private Boolean isPrimaryPhoneInd;
	private String telecomTypeCode;
	private Boolean isActive;

 	public Integer getTelecomId() {
		return telecomId;
	}

	public void setTelecomId(Integer telecomId) {
		this.telecomId = telecomId;
	}
 
 	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}
 
 	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
 
 	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
 
 	public Boolean getIsPrimaryPhoneInd() {
		return isPrimaryPhoneInd;
	}

	public void setIsPrimaryPhoneInd(Boolean isPrimaryPhoneInd) {
		this.isPrimaryPhoneInd = isPrimaryPhoneInd;
	}

	public String getTelecomTypeCode() {
		return telecomTypeCode;
	}

	public void setTelecomTypeCode(String telecomTypeCode) {
		this.telecomTypeCode = telecomTypeCode;
	}

 	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
