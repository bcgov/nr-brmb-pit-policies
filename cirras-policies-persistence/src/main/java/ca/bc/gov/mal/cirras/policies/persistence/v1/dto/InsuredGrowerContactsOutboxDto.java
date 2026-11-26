package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;

public class InsuredGrowerContactsOutboxDto extends BaseDto<InsuredGrowerContactsOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(InsuredGrowerContactsOutboxDto.class);
	
	private Integer insuredGrowerContactsOutboxId;
	private Integer insuredGrowerContactsId;
	private String transactionType;
	private Date entryTimestamp;
	
	public InsuredGrowerContactsOutboxDto() {
	}

	
	public InsuredGrowerContactsOutboxDto(InsuredGrowerContactsOutboxDto dto) {
		this.insuredGrowerContactsOutboxId = dto.insuredGrowerContactsOutboxId;
		this.insuredGrowerContactsId = dto.insuredGrowerContactsId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(InsuredGrowerContactsOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(InsuredGrowerContactsOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public InsuredGrowerContactsOutboxDto copy() {
		return new InsuredGrowerContactsOutboxDto(this);
	}

	public Integer getInsuredGrowerContactsOutboxId() {
		return insuredGrowerContactsOutboxId;
	}
		
	public void setInsuredGrowerContactsOutboxId(Integer insuredGrowerContactsOutboxId) {
		this.insuredGrowerContactsOutboxId = insuredGrowerContactsOutboxId;
	}
	
	public Integer getInsuredGrowerContactsId() {
		return insuredGrowerContactsId;
	}
		
	public void setInsuredGrowerContactsId(Integer insuredGrowerContactsId) {
		this.insuredGrowerContactsId = insuredGrowerContactsId;
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
