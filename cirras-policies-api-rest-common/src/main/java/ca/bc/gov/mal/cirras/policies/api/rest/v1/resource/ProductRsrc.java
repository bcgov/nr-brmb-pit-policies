package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.Product;
import ca.bc.gov.mal.pit.common.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.PRODUCT_NAME)
@XmlSeeAlso({ ProductRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class ProductRsrc extends BaseResource implements Product {

	private static final long serialVersionUID = 1L;

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
