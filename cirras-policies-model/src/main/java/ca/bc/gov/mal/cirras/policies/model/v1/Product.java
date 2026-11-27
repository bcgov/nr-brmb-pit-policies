package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface Product extends Serializable {

	public Integer getProductId();
	public void setProductId(Integer productId);
	
	public Integer getInsurancePolicyId();
	public void setInsurancePolicyId(Integer insurancePolicyId);

	public Integer getCropYear();
	public void setCropYear(Integer cropYear);
	
	public Integer getIcuId();
	public void setIcuId(Integer icuId);

	public Integer getInsurancePlanId();
	public void setInsurancePlanId(Integer insurancePlanId);
	
	public Integer getCropCommodityId();
	public void setCropCommodityId(Integer cropCommodityId);

	public String getCommodityName();
	public void setCommodityName(String commodityName);
	
	public String getCommodityCoverageCode();
	public void setCommodityCoverageCode(String commodityCoverageCode);

	public String getProductStatusCode();
	public void setProductStatusCode(String productStatusCode);

	public Integer getDeductibleLevel();
	public void setDeductibleLevel(Integer deductibleLevel);

	public Double getAcres();
	public void setAcres(Double acres);
	
	public Double getProductionGuarantee();
	public void setProductionGuarantee(Double productionGuarantee);

	public Double getProbableYield();
	public void setProbableYield(Double probableYield);

	public String getInsuredByMeasType();
	public void setInsuredByMeasType(String insuredByMeasType);

	public Double getSelectedInsurableValue();
	public void setSelectedInsurableValue(Double selectedInsurableValue);
	
	public Double getInsurableValueHundredPercent();
	public void setInsurableValueHundredPercent(Double insurableValueHundredPercent);

	public Double getUnseededSelectedInsurableValue();
	public void setUnseededSelectedInsurableValue(Double unseededSelectedInsurableValue);

	public Double getUnseededInsurableValueHundredPercent();
	public void setUnseededInsurableValueHundredPercent(Double unseededInsurableValueHundredPercent);

	public Double getCoverageDollars();
	public void setCoverageDollars(Double coverageDollars);
	
	public Double getSpotLossCoverageAmountPerAcre();
	public void setSpotLossCoverageAmountPerAcre(Double spotLossCoverageAmountPerAcre);

}
