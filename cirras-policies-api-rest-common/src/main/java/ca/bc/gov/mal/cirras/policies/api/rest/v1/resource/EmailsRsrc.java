package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.Emails;
import ca.bc.gov.nrs.common.wfone.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.EMAILS_NAME)
@XmlSeeAlso({ EmailsRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class EmailsRsrc extends BaseResource implements Emails {

	private static final long serialVersionUID = 1L;

	private Integer emailsId;
	private Integer contactsId;
	private String emailAddress;
	private Boolean isPrimaryEmailInd;
	private Boolean isActive;

 	public Integer getEmailsId() {
		return emailsId;
	}

	public void setEmailsId(Integer emailsId) {
		this.emailsId = emailsId;
	}
 
 	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}
 
 	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
 
 	public Boolean getIsPrimaryEmailInd() {
		return isPrimaryEmailInd;
	}

	public void setIsPrimaryEmailInd(Boolean isPrimaryEmailInd) {
		this.isPrimaryEmailInd = isPrimaryEmailInd;
	}

 	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
