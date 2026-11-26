package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class GrowerContractYearOutboxDto extends BaseDto<GrowerContractYearOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(GrowerContractYearOutboxDto.class);
	
	private Integer growerContractYearOutboxId;
	private Integer growerContractYearId;
	private String transactionType;
	private Date entryTimestamp;
	
	public GrowerContractYearOutboxDto() {
	}

	
	public GrowerContractYearOutboxDto(GrowerContractYearOutboxDto dto) {
		this.growerContractYearOutboxId = dto.growerContractYearOutboxId;
		this.growerContractYearId = dto.growerContractYearId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(GrowerContractYearOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(GrowerContractYearOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public GrowerContractYearOutboxDto copy() {
		return new GrowerContractYearOutboxDto(this);
	}

	
	public Integer getGrowerContractYearOutboxId() {
		return growerContractYearOutboxId;
	}
		
	public void setGrowerContractYearOutboxId(Integer growerContractYearOutboxId) {
		this.growerContractYearOutboxId = growerContractYearOutboxId;
	}
	
	public Integer getGrowerContractYearId() {
		return growerContractYearId;
	}
		
	public void setGrowerContractYearId(Integer growerContractYearId) {
		this.growerContractYearId = growerContractYearId;
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
