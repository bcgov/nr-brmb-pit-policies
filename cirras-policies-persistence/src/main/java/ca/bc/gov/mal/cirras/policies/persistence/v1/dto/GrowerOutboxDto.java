package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class GrowerOutboxDto extends BaseDto<GrowerOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(GrowerOutboxDto.class);
	
	private Integer growerOutboxId;
	private Integer growerId;
	private String transactionType;
	private Date entryTimestamp;
	
	public GrowerOutboxDto() {
	}

	
	public GrowerOutboxDto(GrowerOutboxDto dto) {
		this.growerOutboxId = dto.growerOutboxId;
		this.growerId = dto.growerId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(GrowerOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(GrowerOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public GrowerOutboxDto copy() {
		return new GrowerOutboxDto(this);
	}

	
	public Integer getGrowerOutboxId() {
		return growerOutboxId;
	}
		
	public void setGrowerOutboxId(Integer growerOutboxId) {
		this.growerOutboxId = growerOutboxId;
	}
	
	public Integer getGrowerId() {
		return growerId;
	}
		
	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
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
