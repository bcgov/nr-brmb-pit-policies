package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;



public class ClaimDto extends BaseDto<ClaimDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ClaimDto.class);
	
	private Integer claimId;
	private Integer growerId;
	private Integer purchaseId;
	private Integer claimNumber;
	private String claimStatusCode;
	private String policyNumber;
	private Integer insurancePolicyId;
	private Integer contractId;
	private Integer insurancePlanId;
	private String planName;
	private Integer cropCommodityId;
	private String commodityName;
	private Integer growerNumber;
	private String growerName;
	private String growerAddressLine1;
	private String growerAddressLine2;
	private String growerPostalCode;
	private String growerCity;
	private String growerProvince;
	private Integer cropYear;
	private String commodityCoverageCode;
	private String cropCoverage;
	private Double insurableValueSelected;
	private Double insurableValueHundredPercent;
	private Double productionGuarantee;
	private Double coverageAmount;
	private String submittedByUserid;
	private String submittedByName;
	private Date submittedByDate;
	private String recommendedByUserid;
	private String recommendedByName;
	private Date recommendedByDate;
	private String approvedByUserid;
	private String approvedByName;
	private Date approvedByDate;
	private String calculateIivInd;
	private Double totalProbableYield;
	private Double declaredAcres;
	private Integer deductibleLevel;
	private Double plantDeclaredAcres;
	private Double plantDeclaredUnits;
	private Double plantInsurableValue;
	private String insuredByMeasurementType;
	private Boolean hasChequeReqInd;
	
	private List<VarietyDto> varieties = new ArrayList<VarietyDto>();
	
	public ClaimDto() {
	}

	
	public ClaimDto(ClaimDto dto) {
		this.claimId = dto.claimId;
		this.growerId = dto.growerId;
		this.purchaseId = dto.purchaseId;
		this.claimNumber = dto.claimNumber;
		this.claimStatusCode = dto.claimStatusCode;
		this.policyNumber = dto.policyNumber;
		this.insurancePolicyId = dto.insurancePolicyId;
		this.contractId = dto.contractId;
		this.insurancePlanId = dto.insurancePlanId;
		this.planName = dto.planName;
		this.cropCommodityId = dto.cropCommodityId;
		this.commodityName = dto.commodityName;
		this.growerNumber = dto.growerNumber;
		this.growerName = dto.growerName;
		this.growerAddressLine1 = dto.growerAddressLine1;
		this.growerAddressLine2 = dto.growerAddressLine2;
		this.growerPostalCode = dto.growerPostalCode;
		this.growerCity = dto.growerCity;
		this.growerProvince = dto.growerProvince;
		this.cropYear = dto.cropYear;
		this.commodityCoverageCode = dto.commodityCoverageCode;
		this.cropCoverage = dto.cropCoverage;
		this.insurableValueSelected = dto.insurableValueSelected;
		this.insurableValueHundredPercent = dto.insurableValueHundredPercent;
		this.productionGuarantee = dto.productionGuarantee;
		this.coverageAmount = dto.coverageAmount;
		this.submittedByUserid = dto.submittedByUserid;
		this.submittedByName = dto.submittedByName;
		this.submittedByDate = dto.submittedByDate;
		this.recommendedByUserid = dto.recommendedByUserid;
		this.recommendedByName = dto.recommendedByName;
		this.recommendedByDate = dto.recommendedByDate;
		this.approvedByUserid = dto.approvedByUserid;
		this.approvedByName = dto.approvedByName;
		this.approvedByDate = dto.approvedByDate;
		this.calculateIivInd = dto.calculateIivInd;
		this.totalProbableYield = dto.totalProbableYield;
		this.declaredAcres = dto.declaredAcres;
		this.deductibleLevel = dto.deductibleLevel;
		this.plantDeclaredAcres = dto.plantDeclaredAcres;
		this.plantDeclaredUnits = dto.plantDeclaredUnits;
		this.plantInsurableValue = dto.plantInsurableValue;
		this.insuredByMeasurementType = dto.insuredByMeasurementType;
		this.hasChequeReqInd = dto.hasChequeReqInd;
	}
	

	@Override
	public boolean equalsBK(ClaimDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ClaimDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ClaimDto copy() {
		return new ClaimDto(this);
	}

	public Integer getClaimId() {
		return claimId;
	}
	
	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}
	
	public Integer getGrowerId() {
		return growerId;
	}
	
	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}
	
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	
	public Integer getClaimNumber() {
		return claimNumber;
	}
	
	
	public void setClaimNumber(Integer claimNumber) {
		this.claimNumber = claimNumber;
	}
	
	
	public String getClaimStatusCode() {
		return claimStatusCode;
	}
	
	
	public void setClaimStatusCode(String claimStatusCode) {
		this.claimStatusCode = claimStatusCode;
	}
	
	
	public String getPolicyNumber() {
		return policyNumber;
	}
	
	
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	
	public Integer getInsurancePolicyId() {
		return insurancePolicyId;
	}
	
	public void setInsurancePolicyId(Integer insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}
	
	public Integer getContractId() {
		return contractId;
	}
	
	
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
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
	
	
	public Integer getCropCommodityId() {
		return cropCommodityId;
	}
	
	
	public void setCropCommodityId(Integer cropCommodityId) {
		this.cropCommodityId = cropCommodityId;
	}
	
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Integer getGrowerNumber() {
		return growerNumber;
	}
	
	
	public void setGrowerNumber(Integer growerNumber) {
		this.growerNumber = growerNumber;
	}
	
	
	public String getGrowerName() {
		return growerName;
	}
	
	
	public void setGrowerName(String growerName) {
		this.growerName = growerName;
	}
	
	
	public String getGrowerAddressLine1() {
		return growerAddressLine1;
	}
	
	
	public void setGrowerAddressLine1(String growerAddressLine1) {
		this.growerAddressLine1 = growerAddressLine1;
	}
	
	
	public String getGrowerAddressLine2() {
		return growerAddressLine2;
	}
	
	
	public void setGrowerAddressLine2(String growerAddressLine2) {
		this.growerAddressLine2 = growerAddressLine2;
	}
	
	
	public String getGrowerPostalCode() {
		return growerPostalCode;
	}
	
	
	public void setGrowerPostalCode(String growerPostalCode) {
		this.growerPostalCode = growerPostalCode;
	}
	
	
	public String getGrowerCity() {
		return growerCity;
	}
	
	
	public void setGrowerCity(String growerCity) {
		this.growerCity = growerCity;
	}
	
	
	public String getGrowerProvince() {
		return growerProvince;
	}
	
	
	public void setGrowerProvince(String growerProvince) {
		this.growerProvince = growerProvince;
	}
	
	
	public Integer getCropYear() {
		return cropYear;
	}
	
	
	public void setCropYear(Integer cropYear) {
		this.cropYear = cropYear;
	}
	
	
	public String getCommodityCoverageCode() {
		return commodityCoverageCode;
	}
	
	public void setCommodityCoverageCode(String commodityCoverageCode) {
		this.commodityCoverageCode = commodityCoverageCode;
	}
	
	public String getCropCoverage() {
		return cropCoverage;
	}

	public void setCropCoverage(String cropCoverage) {
		this.cropCoverage = cropCoverage;
	}

	
	public Double getInsurableValueSelected() {
		return insurableValueSelected;
	}
	
	
	public void setInsurableValueSelected(Double insurableValueSelected) {
		this.insurableValueSelected = insurableValueSelected;
	}
	
	
	public Double getInsurableValueHundredPercent() {
		return insurableValueHundredPercent;
	}
	
	
	public void setInsurableValueHundredPercent(Double insurableValueHundredPercent) {
		this.insurableValueHundredPercent = insurableValueHundredPercent;
	}
	
	
	public Double getProductionGuarantee() {
		return productionGuarantee;
	}
	
	
	public void setProductionGuarantee(Double productionGuarantee) {
		this.productionGuarantee = productionGuarantee;
	}
	
	
	public Double getCoverageAmount() {
		return coverageAmount;
	}
	
	
	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	
	
	public String getSubmittedByUserid() {
		return submittedByUserid;
	}
	
	
	public void setSubmittedByUserid(String submittedByUserid) {
		this.submittedByUserid = submittedByUserid;
	}
	
	
	public String getSubmittedByName() {
		return submittedByName;
	}
	
	
	public void setSubmittedByName(String submittedByName) {
		this.submittedByName = submittedByName;
	}
	
	
	public Date getSubmittedByDate() {
		return submittedByDate;
	}
	
	
	public void setSubmittedByDate(Date submittedByDate) {
		this.submittedByDate = submittedByDate;
	}
	
	
	public String getRecommendedByUserid() {
		return recommendedByUserid;
	}
	
	
	public void setRecommendedByUserid(String recommendedByUserid) {
		this.recommendedByUserid = recommendedByUserid;
	}
	
	
	public String getRecommendedByName() {
		return recommendedByName;
	}
	
	
	public void setRecommendedByName(String recommendedByName) {
		this.recommendedByName = recommendedByName;
	}
	
	public Date getRecommendedByDate() {
		return recommendedByDate;
	}
	
	
	public void setRecommendedByDate(Date recommendedByDate) {
		this.recommendedByDate = recommendedByDate;
	}
	
	
	public String getApprovedByUserid() {
		return approvedByUserid;
	}
	
	
	public void setApprovedByUserid(String approvedByUserid) {
		this.approvedByUserid = approvedByUserid;
	}
	
	
	public String getApprovedByName() {
		return approvedByName;
	}
	
	
	public void setApprovedByName(String approvedByName) {
		this.approvedByName = approvedByName;
	}
	
	public Date getApprovedByDate() {
		return approvedByDate;
	}
	
	
	public void setApprovedByDate(Date approvedByDate) {
		this.approvedByDate = approvedByDate;
	}
	
	public String getCalculateIivInd() {
		return calculateIivInd;
	}
	
	
	public void setCalculateIivInd(String calculateIivInd) {
		this.calculateIivInd = calculateIivInd;
	}
	

	public Double getTotalProbableYield() {
		return totalProbableYield;
	}
	
	
	public void setTotalProbableYield(Double totalProbableYield) {
		this.totalProbableYield = totalProbableYield;
	}
	
	
	public Double getDeclaredAcres() {
		return declaredAcres;
	}
	
	
	public void setDeclaredAcres(Double declaredAcres) {
		this.declaredAcres = declaredAcres;
	}
	
	
	public Integer getDeductibleLevel() {
		return deductibleLevel;
	}
	
	
	public void setDeductibleLevel(Integer deductibleLevel) {
		this.deductibleLevel = deductibleLevel;
	}
	
	
	public Double getPlantDeclaredAcres() {
		return plantDeclaredAcres;
	}
	
	
	public void setPlantDeclaredAcres(Double plantDeclaredAcres) {
		this.plantDeclaredAcres = plantDeclaredAcres;
	}
	
	
	public Double getPlantDeclaredUnits() {
		return plantDeclaredUnits;
	}
	
	
	public void setPlantDeclaredUnits(Double plantDeclaredUnits) {
		this.plantDeclaredUnits = plantDeclaredUnits;
	}	
	

	public Double getPlantInsurableValue() {
		return plantInsurableValue;
	}
	
	
	public void setPlantInsurableValue(Double plantInsurableValue) {
		this.plantInsurableValue = plantInsurableValue;
	}	
	
	
	public void setInsuredByMeasurementType(String insuredByMeasurementType) {
		this.insuredByMeasurementType = insuredByMeasurementType;
	}
	
	
	public String getInsuredByMeasurementType() {
		return insuredByMeasurementType;
	}

	
	public Boolean getHasChequeReqInd() {
		return hasChequeReqInd;
	}
	
	
	public void setHasChequeReqInd(Boolean hasChequeReqInd) {
		this.hasChequeReqInd = hasChequeReqInd;
	}
	
	
	public List<VarietyDto> getVarieties() {
		return varieties;
	}

	public void setVarieties(List<VarietyDto> varieties) {
		this.varieties = varieties;
	}

}
