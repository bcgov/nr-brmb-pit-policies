package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface CommodityVarietySync extends Serializable {

	public Integer getCropId();
	public void setCropId(Integer cropId);

	public String getCropName();
	public void setCropName(String cropName);	
	
	public Integer getParentCropId();
	public void setParentCropId(Integer parentCropId);

	public Boolean getIsProductInsurable();
	public void setIsProductInsurable(Boolean isProductInsurable);

	public Boolean getIsInventoryCrop();
	public void setIsInventoryCrop(Boolean isInventoryCrop);
	
	public Integer getInsurancePlanId();
	public void setInsurancePlanId(Integer insurancePlanId);

	public String getShortLabel();
	public void setShortLabel(String shortLabel);

	public String getPlantDurationTypeCode();
	public void setPlantDurationTypeCode(String plantDurationTypeCode);

	public Boolean getIsYieldCrop();
	public void setIsYieldCrop(Boolean isYieldCrop);

	public Boolean getIsUnderwritingCrop();
	public void setIsUnderwritingCrop(Boolean isUnderwritingCrop);

	public String getYieldMeasUnitTypeCode();
	public void setYieldMeasUnitTypeCode(String yieldMeasUnitTypeCode);

	public Integer getYieldDecimalPrecision();
	public void setYieldDecimalPrecision(Integer yieldDecimalPrecision);
	
	public Boolean getIsCropInsuranceEligible();
	public void setIsCropInsuranceEligible(Boolean isCropInsuranceEligible);

	public Boolean getIsPlantInsuranceEligible();
	public void setIsPlantInsuranceEligible(Boolean isPlantInsuranceEligible);

	public Boolean getIsOtherInsuranceEligible();
	public void setIsOtherInsuranceEligible(Boolean isOtherInsuranceEligible);

}
