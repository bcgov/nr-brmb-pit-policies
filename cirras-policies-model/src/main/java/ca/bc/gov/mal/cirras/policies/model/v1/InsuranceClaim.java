package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface InsuranceClaim extends Serializable {


	public Integer getGrowerId();
	public void setGrowerId(Integer growerId);
	
	public Integer getPurchaseId();
	public void setPurchaseId(Integer purchaseId);
	
	public Integer getClaimNumber();
	public void setClaimNumber(Integer claimNumber);

	public Integer getClaimId();
	public void setClaimId(Integer claimId);
	
	public String getPolicyNumber();
	public void setPolicyNumber(String policyNumber);

	public Integer getInsurancePolicyId();
	public void setInsurancePolicyId(Integer insurancePolicyId);
	
	public Integer getGrowerNumber();
	public void setGrowerNumber(Integer growerNumber);

	public String getGrowerName();
	public void setGrowerName(String growerName) ;

	public Integer getInsurancePlanId();
	public void setInsurancePlanId(Integer insurancePlanId);

	public String getInsurancePlanName();
	public void setInsurancePlanName(String insurancePlanName);

	public Integer getContractId();
	public void setContractId(Integer contractId);

	public String getCoverageName();
	public void setCoverageName(String coverageName);
	
	public String getCommodityCoverageCode();
	public void setCommodityCoverageCode(String commodityCoverageCode);
	
	public String getCommodityName();
	public void setCommodityName(String commodityName);
	
	public Integer getCropCommodityId();
	public void setCropCommodityId(Integer cropCommodityId);
	
	public String getClaimStatus();
	public void setClaimStatus(String claimStatus);
	
	public String getClaimStatusCode();
	public void setClaimStatusCode(String claimStatusCode);
	
	public String getClaimType();
	public void setClaimType(String claimType);

	public String getGrowerAddressLine1();
	public void setGrowerAddressLine1(String growerAddressLine1) ;

	public String getGrowerAddressLine2();
	public void setGrowerAddressLine2(String growerAddressLine2);

	public String getGrowerPostalCode() ;
	public void setGrowerPostalCode(String growerPostalCode);

	public String getGrowerCity();
	public void setGrowerCity(String growerCity);

	public String getGrowerProvince();
	public void setGrowerProvince(String growerProvince);

	public Integer getCropYear();
	public void setCropYear(Integer cropYear);

	public Double getInsurableValueSelected() ;
	public void setInsurableValueSelected(Double insurableValueSelected);

	public Double getInsurableValueHundredPercent();
	public void setInsurableValueHundredPercent(Double insurableValueHundredPercent);
	
	public Double getProductionGuarantee();
	public void setProductionGuarantee(Double productionGuarantee);
	
	public Double getCoverageAmount();
	public void setCoverageAmount(Double coverageAmount);

	public String getPrimaryPerilCode();
	public void setPrimaryPerilCode(String primaryPerilCode);

	public String getSecondaryPerilCode();
	public void setSecondaryPerilCode(String secondaryPerilCode);

	public String getSubmittedByUserid();
	public void setSubmittedByUserid(String submittedByUserid);
	
	public String getSubmittedByName();
	public void setSubmittedByName(String submittedByName);
	
	public Date getSubmittedByDate();
	public void setSubmittedByDate(Date submittedByDate);
	
	public String getRecommendedByUserid();
	public void setRecommendedByUserid(String recommendedByUserid);
	
	public String getRecommendedByName();
	public void setRecommendedByName(String recommendedByName);
	
	public Date getRecommendedByDate();
	public void setRecommendedByDate(Date recommendedByDate);
	
	public String getApprovedByUserid();
	public void setApprovedByUserid(String approvedByUserid);
	
	public String getApprovedByName();
	public void setApprovedByName(String approvedByName);
	
	public Date getApprovedByDate();
	public void setApprovedByDate(Date approvedByDate);

	public String getCalculateIivInd();
	public void setCalculateIivInd(String calculateIivInd);
	
	public Double getTotalProbableYield();
	public void setTotalProbableYield(Double totalProbableYield);
	
	public Double getDeclaredAcres();
	public void setDeclaredAcres(Double declaredAcres);	
	
	public Integer getDeductibleLevel();
	public void setDeductibleLevel(Integer deductibleLevel);
	
	public Double getPlantDeclaredAcres();
	public void setPlantDeclaredAcres(Double plantDeclaredAcres);
	
	public Double getPlantDeclaredUnits();
	public void setPlantDeclaredUnits(Double plantDeclaredUnits);

	public Double getPlantInsurableValue();
	public void setPlantInsurableValue(Double plantInsurableValue);
	
	public void setInsuredByMeasurementType(String insuredByMeasurementType);
	public String getInsuredByMeasurementType();

	public Boolean getHasChequeReqInd();
	public void setHasChequeReqInd(Boolean hasChequeReqInd);
	
	
	List<Variety> getVarieties();
	void setVarieties(List<Variety> value);

}
