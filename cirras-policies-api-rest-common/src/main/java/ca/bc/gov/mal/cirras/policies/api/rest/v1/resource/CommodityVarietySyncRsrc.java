package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityVarietySync;
import ca.bc.gov.nrs.common.wfone.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.COMMODITY_VARIETY_SYNC_NAME)
@XmlSeeAlso({ CommodityVarietySyncRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class CommodityVarietySyncRsrc extends BaseResource implements CommodityVarietySync {

	private static final long serialVersionUID = 1L;

	private Integer cropId;
	private String cropName;
	private Integer parentCropId;
	private Boolean isProductInsurable;
	private Boolean isInventoryCrop;
	private Integer insurancePlanId;
	private String shortLabel;
	private String plantDurationTypeCode;
	private Boolean isYieldCrop;
	private Boolean isUnderwritingCrop;
	private String yieldMeasUnitTypeCode;
	private Integer yieldDecimalPrecision;
	private Boolean isCropInsuranceEligible;
	private Boolean isPlantInsuranceEligible;
	private Boolean isOtherInsuranceEligible;

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}


	public String getCropName() {
		return cropName;
	}
	
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	

	public Integer getParentCropId() {
		return parentCropId;
	}
	
	public void setParentCropId(Integer parentCropId) {
		this.parentCropId = parentCropId;
	}


	public Boolean getIsProductInsurable() {
		return isProductInsurable;
	}
	
	public void setIsProductInsurable(Boolean isProductInsurable) {
		this.isProductInsurable = isProductInsurable;
	}


	public Boolean getIsInventoryCrop() {
		return isInventoryCrop;
	}

	public void setIsInventoryCrop(Boolean isInventoryCrop) {
		this.isInventoryCrop = isInventoryCrop;
	}
	
	public Integer getInsurancePlanId() {
		return insurancePlanId;
	}

	public void setInsurancePlanId(Integer insurancePlanId) {
		this.insurancePlanId = insurancePlanId;
	}

	public String getShortLabel() {
		return shortLabel;
	}

	public void setShortLabel(String shortLabel) {
		this.shortLabel = shortLabel;
	}

	public String getPlantDurationTypeCode() {
		return plantDurationTypeCode;
	}

	public void setPlantDurationTypeCode(String plantDurationTypeCode) {
		this.plantDurationTypeCode = plantDurationTypeCode;
	}

	public Boolean getIsYieldCrop() {
		return isYieldCrop;
	}

	public void setIsYieldCrop(Boolean isYieldCrop) {
		this.isYieldCrop = isYieldCrop;
	}

	public Boolean getIsUnderwritingCrop() {
		return isUnderwritingCrop;
	}

	public void setIsUnderwritingCrop(Boolean isUnderwritingCrop) {
		this.isUnderwritingCrop = isUnderwritingCrop;
	}

	public String getYieldMeasUnitTypeCode() {
		return yieldMeasUnitTypeCode;
	}

	public void setYieldMeasUnitTypeCode(String yieldMeasUnitTypeCode) {
		this.yieldMeasUnitTypeCode = yieldMeasUnitTypeCode;
	}

	public Integer getYieldDecimalPrecision() {
		return yieldDecimalPrecision;
	}

	public void setYieldDecimalPrecision(Integer yieldDecimalPrecision) {
		this.yieldDecimalPrecision = yieldDecimalPrecision;
	}

	public Boolean getIsCropInsuranceEligible() {
		return isCropInsuranceEligible;
	}

	public void setIsCropInsuranceEligible(Boolean isCropInsuranceEligible) {
		this.isCropInsuranceEligible = isCropInsuranceEligible;
	}

	public Boolean getIsPlantInsuranceEligible() {
		return isPlantInsuranceEligible;
	}

	public void setIsPlantInsuranceEligible(Boolean isPlantInsuranceEligible) {
		this.isPlantInsuranceEligible = isPlantInsuranceEligible;
	}

	public Boolean getIsOtherInsuranceEligible() {
		return isOtherInsuranceEligible;
	}

	public void setIsOtherInsuranceEligible(Boolean isOtherInsuranceEligible) {
		this.isOtherInsuranceEligible = isOtherInsuranceEligible;
	}
	
}
