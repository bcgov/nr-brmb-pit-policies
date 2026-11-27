package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;



public class ClaimSearchDto extends BaseDto<ClaimSearchDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ClaimSearchDto.class);
	
	private Integer claimNumber;
	private String policyNumber;
	private Integer growerNumber;
	private String growersLegalName;
	private Integer insurancePlanId;
	private String planName;
	private String cropCoverage;
	private String cropCoverageCode;
	private String commodityName;
	private Integer commodityId;
	private String claimStatus;
	private String claimStatusCode;
	private String claimType;

	public ClaimSearchDto() {
	}
	
	
	public ClaimSearchDto(ClaimSearchDto dto) {
		this.claimNumber = dto.claimNumber;
		this.policyNumber = dto.policyNumber;
		this.growerNumber = dto.growerNumber;
		this.growersLegalName = dto.growersLegalName;
		this.insurancePlanId = dto.insurancePlanId;
		this.planName = dto.planName;
		this.cropCoverage = dto.cropCoverage;
		this.cropCoverageCode = dto.cropCoverageCode;
		this.commodityName = dto.commodityName;
		this.commodityId = dto.commodityId;
		this.claimStatus = dto.claimStatus;
		this.claimStatusCode = dto.claimStatusCode;
		this.claimType = dto.claimType;
	}
	

	@Override
	public boolean equalsBK(ClaimSearchDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ClaimSearchDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ClaimSearchDto copy() {
		return new ClaimSearchDto(this);
	}

	public Integer getClaimNumber() {
		return claimNumber;
	}


	public void setClaimNumber(Integer claimNumber) {
		this.claimNumber = claimNumber;
	}


	public String getPolicyNumber() {
		return policyNumber;
	}


	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}


	public Integer getGrowerNumber() {
		return growerNumber;
	}


	public void setGrowerNumber(Integer growerNumber) {
		this.growerNumber = growerNumber;
	}


	public String getGrowersLegalName() {
		return growersLegalName;
	}


	public void setGrowersLegalName(String growersLegalName) {
		this.growersLegalName = growersLegalName;
	}

	
	public Integer getInsurancePlanId() {
		return insurancePlanId;
	}

	
	public void setInsurancePlanId(Integer insurancePlanId) {
		this.insurancePlanId = insurancePlanId;
	}


	public String getPlanName() {
		return planName;
	}


	public void setPlanName(String planName) {
		this.planName = planName;
	}


	public String getCropCoverage() {
		return cropCoverage;
	}

	public void setCropCoverage(String cropCoverage) {
		this.cropCoverage = cropCoverage;
	}

	public String getCropCoverageCode() {
		return cropCoverageCode;
	}

	public void setCropCoverageCode(String cropCoverageCode) {
		this.cropCoverageCode = cropCoverageCode;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getClaimStatusCode() {
		return claimStatusCode;
	}

	public void setClaimStatusCode(String claimStatusCode) {
		this.claimStatusCode = claimStatusCode;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

}
