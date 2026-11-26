package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.ClaimCalculationSubmit;
import ca.bc.gov.nrs.common.wfone.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.CLAIM_CALCULATION_SUBMIT_NAME)
@XmlSeeAlso({ ClaimCalculationSubmitRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class ClaimCalculationSubmitRsrc extends BaseResource implements ClaimCalculationSubmit {

	private static final long serialVersionUID = 1L;

	private Integer claimNumber;
	private Double claimAmount;
	private String userId;
	
	public Integer getClaimNumber() {
		return claimNumber;
	}
	
	public void setClaimNumber(Integer claimNumber) {
		this.claimNumber = claimNumber;
	}

 	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

 	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

}
