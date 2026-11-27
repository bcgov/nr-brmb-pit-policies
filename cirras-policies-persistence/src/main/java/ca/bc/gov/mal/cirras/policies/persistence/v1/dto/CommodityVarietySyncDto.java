package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;



public class CommodityVarietySyncDto extends BaseDto<CommodityVarietySyncDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CommodityVarietySyncDto.class);

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
	
	public CommodityVarietySyncDto() {
	}
	
	
	public CommodityVarietySyncDto(CommodityVarietySyncDto dto) {
		this.cropId = dto.cropId;
		this.cropName = dto.cropName;
		this.parentCropId = dto.parentCropId;
		this.isProductInsurable = dto.isProductInsurable;
		this.isInventoryCrop = dto.isInventoryCrop;	
		this.insurancePlanId = dto.insurancePlanId;
		this.shortLabel = dto.shortLabel;
		this.plantDurationTypeCode = dto.plantDurationTypeCode;
		this.isYieldCrop = dto.isYieldCrop;
		this.isUnderwritingCrop = dto.isUnderwritingCrop;
		this.yieldMeasUnitTypeCode = dto.yieldMeasUnitTypeCode;
		this.yieldDecimalPrecision = dto.yieldDecimalPrecision;
		this.isCropInsuranceEligible = dto.isCropInsuranceEligible;
		this.isPlantInsuranceEligible = dto.isPlantInsuranceEligible;
		this.isOtherInsuranceEligible = dto.isOtherInsuranceEligible;

	}
	

	@Override
	public boolean equalsBK(CommodityVarietySyncDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CommodityVarietySyncDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CommodityVarietySyncDto copy() {
		return new CommodityVarietySyncDto(this);
	}

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
