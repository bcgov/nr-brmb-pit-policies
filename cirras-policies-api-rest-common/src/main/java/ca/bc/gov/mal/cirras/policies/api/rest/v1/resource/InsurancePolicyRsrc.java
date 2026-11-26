package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.InsurancePolicy;
import ca.bc.gov.nrs.common.wfone.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.INSURANCE_POLICY_NAME)
@XmlSeeAlso({ InsurancePolicyRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class InsurancePolicyRsrc extends BaseResource implements InsurancePolicy {

	private static final long serialVersionUID = 1L;

	private Integer insurancePolicyId;
	private Integer growerId;
	private String growerName;
	private Integer insurancePlanId;
	private Integer contractId;
	private Integer cropYear;
	private Integer officeId;
	private String policyStatusCode;
	private String policyNumber;
	private String contractNumber;
	

	public Integer getInsurancePolicyId() {
		return insurancePolicyId;
	}
	
	public void setInsurancePolicyId(Integer insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}

	public Integer getGrowerId() {
		return growerId;
	}
	
	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
	}

	public String getGrowerName() {
		return growerName;
	}

	public void setGrowerName(String growerName) {
		this.growerName = growerName;
	}
	
	public Integer getInsurancePlanId() {
		return insurancePlanId;
	}

	public void setInsurancePlanId(Integer insurancePlanId) {
		this.insurancePlanId = insurancePlanId;
	}

	public Integer getContractId() {
		return contractId;
	}
	
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Integer getCropYear() {
		return cropYear;
	}

	public void setCropYear(Integer cropYear) {
		this.cropYear = cropYear;
	}
	
	public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public String getPolicyStatusCode() {
		return policyStatusCode;
	}

	public void setPolicyStatusCode(String policyStatusCode) {
		this.policyStatusCode = policyStatusCode;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	
}
