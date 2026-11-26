package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class CropTypeOutboxDto extends BaseDto<CropTypeOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CropTypeOutboxDto.class);
	
	private Integer cropTypeOutboxId;
	private Integer cropId;
	private String transactionType;
	private Date entryTimestamp;
	
	public CropTypeOutboxDto() {
	}

	
	public CropTypeOutboxDto(CropTypeOutboxDto dto) {
		this.cropTypeOutboxId = dto.cropTypeOutboxId;
		this.cropId = dto.cropId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(CropTypeOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CropTypeOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CropTypeOutboxDto copy() {
		return new CropTypeOutboxDto(this);
	}

	public Integer getCropTypeOutboxId() {
		return cropTypeOutboxId;
	}
		
	public void setCropTypeOutboxId(Integer cropTypeOutboxId) {
		this.cropTypeOutboxId = cropTypeOutboxId;
	}
	
	public Integer getCropId() {
		return cropId;
	}
		
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
		
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}	
	
	public Date getEntryTimestamp() {
		return entryTimestamp;
	}
	
	public void setEntryTimestamp(Date entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

}
