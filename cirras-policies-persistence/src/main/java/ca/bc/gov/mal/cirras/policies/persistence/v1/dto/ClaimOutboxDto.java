package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class ClaimOutboxDto extends BaseDto<ClaimOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ClaimOutboxDto.class);
	
	private Integer claimOutboxId;
	private Integer claimId;
	private String transactionType;
	private Date entryTimestamp;
	
	public ClaimOutboxDto() {
	}

	
	public ClaimOutboxDto(ClaimOutboxDto dto) {
		this.claimOutboxId = dto.claimOutboxId;
		this.claimId = dto.claimId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(ClaimOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ClaimOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ClaimOutboxDto copy() {
		return new ClaimOutboxDto(this);
	}

	
	public Integer getClaimOutboxId() {
		return claimOutboxId;
	}
		
	public void setClaimOutboxId(Integer claimOutboxId) {
		this.claimOutboxId = claimOutboxId;
	}
	
	public Integer getClaimId() {
		return claimId;
	}
		
	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
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
