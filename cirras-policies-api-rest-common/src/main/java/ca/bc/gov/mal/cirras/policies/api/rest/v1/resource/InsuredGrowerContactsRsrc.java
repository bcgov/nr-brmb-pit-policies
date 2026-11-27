package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrowerContacts;
import ca.bc.gov.nrs.common.wfone.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.INSURED_GROWER_CONTACTS_NAME)
@XmlSeeAlso({ InsuredGrowerContactsRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class InsuredGrowerContactsRsrc extends BaseResource implements InsuredGrowerContacts {

	private static final long serialVersionUID = 1L;

	private Integer growerContactsId;
	private Integer growerId;
	private Integer contactsId;
	private Boolean isPrimaryContactInd;
	private Boolean isActivelyInvolvedInd;

 	public Integer getGrowerContactsId() {
		return growerContactsId;
	}

	public void setGrowerContactsId(Integer growerContactsId) {
		this.growerContactsId = growerContactsId;
	}
 
 	public Integer getGrowerId() {
		return growerId;
	}

	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
	}
 
 	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}
 
 	public Boolean getIsPrimaryContactInd() {
		return isPrimaryContactInd;
	}

	public void setIsPrimaryContactInd(Boolean isPrimaryContactInd) {
		this.isPrimaryContactInd = isPrimaryContactInd;
	}
 
 	public Boolean getIsActivelyInvolvedInd() {
		return isActivelyInvolvedInd;
	}

	public void setIsActivelyInvolvedInd(Boolean isActivelyInvolvedInd) {
		this.isActivelyInvolvedInd = isActivelyInvolvedInd;
	}

}
