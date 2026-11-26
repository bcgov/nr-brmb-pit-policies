package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;



public class CoveragePerilSyncDto extends BaseDto<CoveragePerilSyncDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CoveragePerilSyncDto.class);

	private Integer coveragePerilId;
	private Integer cropCommodityId;
	private String perilCode;
	private String commodityCoverageCode;
	private Integer cropCoverageId;
	private Boolean isActive;
	
	public CoveragePerilSyncDto() {
	}
	
	
	public CoveragePerilSyncDto(CoveragePerilSyncDto dto) {
		this.coveragePerilId = dto.coveragePerilId;
		this.cropCommodityId = dto.cropCommodityId;
		this.perilCode = dto.perilCode;
		this.commodityCoverageCode = dto.commodityCoverageCode;
		this.cropCoverageId = dto.cropCoverageId;
		this.isActive = dto.isActive;
	}
	

	@Override
	public boolean equalsBK(CoveragePerilSyncDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CoveragePerilSyncDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CoveragePerilSyncDto copy() {
		return new CoveragePerilSyncDto(this);
	}

 	public Integer getCoveragePerilId() {
		return coveragePerilId;
	}

	public void setCoveragePerilId(Integer coveragePerilId) {
		this.coveragePerilId = coveragePerilId;
	}
 
 	public Integer getCropCommodityId() {
		return cropCommodityId;
	}

	public void setCropCommodityId(Integer cropCommodityId) {
		this.cropCommodityId = cropCommodityId;
	}
 
 	public String getPerilCode() {
		return perilCode;
	}

	public void setPerilCode(String perilCode) {
		this.perilCode = perilCode;
	}
 
 	public String getCommodityCoverageCode() {
		return commodityCoverageCode;
	}

	public void setCommodityCoverageCode(String commodityCoverageCode) {
		this.commodityCoverageCode = commodityCoverageCode;
	}

 	public Integer getCropCoverageId() {
		return cropCoverageId;
	}

	public void setCropCoverageId(Integer cropCoverageId) {
		this.cropCoverageId = cropCoverageId;
	}

 	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
