package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class VarietyDto extends BaseDto<VarietyDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(VarietyDto.class);
	

	// from CIRRAS
	private Integer cropVarietyId;
	private String varietyName;
	private Double averagePrice;
	
	public VarietyDto() {
	}
	
	
	public VarietyDto(VarietyDto dto) {
	}
	

	@Override
	public boolean equalsBK(VarietyDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(VarietyDto other) {
		boolean result = false;
		return result;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public VarietyDto copy() {
		return new VarietyDto(this);
	}

	
	public Integer getCropVarietyId() {
		return cropVarietyId;
	}

	public void setCropVarietyId(Integer cropVarietyId) {
		this.cropVarietyId = cropVarietyId;
	}
	
	public String getVarietyName() {
		return varietyName;
	}

	public void setVarietyName(String varietyName) {
		this.varietyName = varietyName;
	}

	public Double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}
	
}
