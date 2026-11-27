package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;


public class ProductDto extends BaseDto<ProductDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ProductDto.class);

	private Integer productId;
	private Integer insurancePolicyId;
	private Integer cropYear;
	private Integer icuId;
	private Integer insurancePlanId;
	private Integer cropCommodityId;
	private String commodityName;
	private String commodityCoverageCode;
	private String productStatusCode;
	private Integer deductibleLevel;
	private Double acres;
	private Double productionGuarantee;
	private Double probableYield;
	private String insuredByMeasType;
	private Double selectedInsurableValue;
	private Double insurableValueHundredPercent;
	private Double unseededSelectedInsurableValue;
	private Double unseededInsurableValueHundredPercent;
	private Double coverageDollars;
	private Double spotLossCoverageAmountPerAcre;
	
	
	public ProductDto() {
	}
	
	
	public ProductDto(ProductDto dto) {
		this.productId = dto.productId;
		this.insurancePolicyId = dto.insurancePolicyId;
		this.cropYear = dto.cropYear;
		this.icuId = dto.icuId;
		this.insurancePlanId = dto.insurancePlanId;
		this.cropCommodityId = dto.cropCommodityId;
		this.commodityName = dto.commodityName;
		this.commodityCoverageCode = dto.commodityCoverageCode;
		this.productStatusCode = dto.productStatusCode;
		this.deductibleLevel = dto.deductibleLevel;
		this.acres = dto.acres;
		this.productionGuarantee = dto.productionGuarantee;
		this.probableYield = dto.probableYield;
		this.insuredByMeasType = dto.insuredByMeasType;
		this.selectedInsurableValue = dto.selectedInsurableValue;
		this.insurableValueHundredPercent = dto.insurableValueHundredPercent;
		this.unseededSelectedInsurableValue = dto.unseededSelectedInsurableValue;
		this.unseededInsurableValueHundredPercent = dto.unseededInsurableValueHundredPercent;
		this.coverageDollars = dto.coverageDollars;
		this.spotLossCoverageAmountPerAcre = dto.spotLossCoverageAmountPerAcre;

	}
	

	@Override
	public boolean equalsBK(ProductDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ProductDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ProductDto copy() {
		return new ProductDto(this);
	}

	public Integer getProductId() {
		return productId;
	}	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getInsurancePolicyId() {
		return insurancePolicyId;
	}	
	public void setInsurancePolicyId(Integer insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}

	public Integer getCropYear() {
		return cropYear;
	}
	public void setCropYear(Integer cropYear) {
		this.cropYear = cropYear;
	}	
	
	public Integer getIcuId() {
		return icuId;
	}	
	public void setIcuId(Integer icuId) {
		this.icuId = icuId;
	}

	public Integer getInsurancePlanId() {
		return insurancePlanId;
	}
	public void setInsurancePlanId(Integer insurancePlanId) {
		this.insurancePlanId = insurancePlanId;
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
		
	public String getCommodityCoverageCode() {
		return commodityCoverageCode;
	}
	public void setCommodityCoverageCode(String commodityCoverageCode) {
		this.commodityCoverageCode = commodityCoverageCode;
	}

	public String getProductStatusCode() {
		return productStatusCode;
	}
	public void setProductStatusCode(String productStatusCode) {
		this.productStatusCode = productStatusCode;
	}

	public Integer getDeductibleLevel() {
		return deductibleLevel;
	}
	public void setDeductibleLevel(Integer deductibleLevel) {
		this.deductibleLevel = deductibleLevel;
	}

	public Double getAcres() {
		return acres;
	}
	public void setAcres(Double acres) {
		this.acres = acres;
	}
		
	public Double getProductionGuarantee() {
		return productionGuarantee;
	}
	public void setProductionGuarantee(Double productionGuarantee) {
		this.productionGuarantee = productionGuarantee;
	}

	public Double getProbableYield() {
		return probableYield;
	}
	public void setProbableYield(Double probableYield) {
		this.probableYield = probableYield;
	}

	public String getInsuredByMeasType() {
		return insuredByMeasType;
	}
	public void setInsuredByMeasType(String insuredByMeasType) {
		this.insuredByMeasType = insuredByMeasType;
	}

	public Double getSelectedInsurableValue() {
		return selectedInsurableValue;
	}
	public void setSelectedInsurableValue(Double selectedInsurableValue) {
		this.selectedInsurableValue = selectedInsurableValue;
	}

	public Double getInsurableValueHundredPercent() {
		return insurableValueHundredPercent;
	}
	public void setInsurableValueHundredPercent(Double insurableValueHundredPercent) {
		this.insurableValueHundredPercent = insurableValueHundredPercent;
	}

	public Double getUnseededSelectedInsurableValue() {
		return unseededSelectedInsurableValue;
	}
	public void setUnseededSelectedInsurableValue(Double unseededSelectedInsurableValue) {
		this.unseededSelectedInsurableValue = unseededSelectedInsurableValue;
	}

	public Double getUnseededInsurableValueHundredPercent() {
		return unseededInsurableValueHundredPercent;
	}
	public void setUnseededInsurableValueHundredPercent(Double unseededInsurableValueHundredPercent) {
		this.unseededInsurableValueHundredPercent = unseededInsurableValueHundredPercent;
	}
		
	public Double getCoverageDollars() {
		return coverageDollars;
	}
	public void setCoverageDollars(Double coverageDollars) {
		this.coverageDollars = coverageDollars;
	}

	public Double getSpotLossCoverageAmountPerAcre() {
		return spotLossCoverageAmountPerAcre;
	}
	public void setSpotLossCoverageAmountPerAcre(Double spotLossCoverageAmountPerAcre) {
		this.spotLossCoverageAmountPerAcre = spotLossCoverageAmountPerAcre;
	}

}
