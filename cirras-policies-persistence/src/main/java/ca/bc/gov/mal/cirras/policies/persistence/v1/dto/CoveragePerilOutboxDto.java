package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class CoveragePerilOutboxDto extends BaseDto<CoveragePerilOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CoveragePerilOutboxDto.class);
	
	private Integer coveragePerilOutboxId;
	private Integer coveragePerilId;
	private String transactionType;
	private Date entryTimestamp;
	
	public CoveragePerilOutboxDto() {
	}

	
	public CoveragePerilOutboxDto(CoveragePerilOutboxDto dto) {
		this.coveragePerilOutboxId = dto.coveragePerilOutboxId;
		this.coveragePerilId = dto.coveragePerilId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(CoveragePerilOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CoveragePerilOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CoveragePerilOutboxDto copy() {
		return new CoveragePerilOutboxDto(this);
	}

	public Integer getCoveragePerilOutboxId() {
		return coveragePerilOutboxId;
	}
		
	public void setCoveragePerilOutboxId(Integer coveragePerilOutboxId) {
		this.coveragePerilOutboxId = coveragePerilOutboxId;
	}
	
	public Integer getCoveragePerilId() {
		return coveragePerilId;
	}
		
	public void setCoveragePerilId(Integer coveragePerilId) {
		this.coveragePerilId = coveragePerilId;
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
