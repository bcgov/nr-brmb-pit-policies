package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;



public class PolicyDto extends BaseDto<PolicyDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(PolicyDto.class);

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
	
	
	public PolicyDto() {
	}
	
	
	public PolicyDto(PolicyDto dto) {
		this.contractId = dto.contractId;
		this.cropYear = dto.cropYear;
		this.growerId = dto.growerId;
		this.growerName = dto.growerName;
		this.insurancePlanId = dto.insurancePlanId;
		this.insurancePolicyId = dto.insurancePolicyId;
		this.officeId = dto.officeId;
		this.policyStatusCode = dto.policyStatusCode;
		this.policyNumber = dto.policyNumber;
		this.contractNumber = dto.contractNumber;
	}
	

	@Override
	public boolean equalsBK(PolicyDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(PolicyDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public PolicyDto copy() {
		return new PolicyDto(this);
	}

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
