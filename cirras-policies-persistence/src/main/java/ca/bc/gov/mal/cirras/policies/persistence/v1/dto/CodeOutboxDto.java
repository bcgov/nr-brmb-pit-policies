package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class CodeOutboxDto extends BaseDto<CodeOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CodeOutboxDto.class);
	
	private String codeTableType;
	private Integer codeOutboxId;
	private String uniqueKeyString;
	private Integer uniqueKeyInteger;
	private String transactionType;
	private Date entryTimestamp;
	
	public CodeOutboxDto() {
	}

	
	public CodeOutboxDto(CodeOutboxDto dto) {
		this.codeTableType = dto.codeTableType;
		this.codeOutboxId = dto.codeOutboxId;
		this.uniqueKeyString = dto.uniqueKeyString;
		this.uniqueKeyInteger = dto.uniqueKeyInteger;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(CodeOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CodeOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CodeOutboxDto copy() {
		return new CodeOutboxDto(this);
	}

 	public String getCodeTableType() {
		return codeTableType;
	}

	public void setCodeTableType(String codeTableType) {
		this.codeTableType = codeTableType;
	}
	
	public Integer getCodeOutboxId() {
		return codeOutboxId;
	}
		
	public void setCodeOutboxId(Integer codeOutboxId) {
		this.codeOutboxId = codeOutboxId;
	}

 	public String getUniqueKeyString() {
		return uniqueKeyString;
	}

	public void setUniqueKeyString(String uniqueKeyString) {
		this.uniqueKeyString = uniqueKeyString;
	}
 
 	public Integer getUniqueKeyInteger() {
		return uniqueKeyInteger;
	}

	public void setUniqueKeyInteger(Integer uniqueKeyInteger) {
		this.uniqueKeyInteger = uniqueKeyInteger;
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
