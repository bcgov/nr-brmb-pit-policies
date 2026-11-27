package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;



public class CommodityTypeCodeSyncDto extends BaseDto<CommodityTypeCodeSyncDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CommodityTypeCodeSyncDto.class);

	private String commodityTypeCode;
	private String description;
	private Integer cropId;
	private Boolean isActive;
	
	public CommodityTypeCodeSyncDto() {
	}
	
	
	public CommodityTypeCodeSyncDto(CommodityTypeCodeSyncDto dto) {
		this.commodityTypeCode = dto.commodityTypeCode;
		this.description = dto.description;
		this.cropId = dto.cropId;
		this.isActive = dto.isActive;
	}
	

	@Override
	public boolean equalsBK(CommodityTypeCodeSyncDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CommodityTypeCodeSyncDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CommodityTypeCodeSyncDto copy() {
		return new CommodityTypeCodeSyncDto(this);
	}

	public String getCommodityTypeCode() {
		return commodityTypeCode;
	}

	public void setCommodityTypeCode(String commodityTypeCode) {
		this.commodityTypeCode = commodityTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
