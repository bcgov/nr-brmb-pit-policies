package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class TelecomOutboxDto extends BaseDto<TelecomOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(TelecomOutboxDto.class);
	
	private Integer telecomOutboxId;
	private Integer telecomId;
	private String transactionType;
	private Date entryTimestamp;
	
	public TelecomOutboxDto() {
	}

	
	public TelecomOutboxDto(TelecomOutboxDto dto) {
		this.telecomOutboxId = dto.telecomOutboxId;
		this.telecomId = dto.telecomId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(TelecomOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(TelecomOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public TelecomOutboxDto copy() {
		return new TelecomOutboxDto(this);
	}

	public Integer getTelecomOutboxId() {
		return telecomOutboxId;
	}
		
	public void setTelecomOutboxId(Integer telecomOutboxId) {
		this.telecomOutboxId = telecomOutboxId;
	}
	
	public Integer getTelecomId() {
		return telecomId;
	}
		
	public void setTelecomId(Integer telecomId) {
		this.telecomId = telecomId;
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
