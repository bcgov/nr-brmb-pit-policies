package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class PolicyOutboxDto extends BaseDto<PolicyOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(PolicyOutboxDto.class);
	
	private Integer policyOutboxId;
	private Integer insurancePolicyId;
	private String transactionType;
	private Date entryTimestamp;
	
	public PolicyOutboxDto() {
	}

	
	public PolicyOutboxDto(PolicyOutboxDto dto) {
		this.policyOutboxId = dto.policyOutboxId;
		this.insurancePolicyId = dto.insurancePolicyId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(PolicyOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(PolicyOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public PolicyOutboxDto copy() {
		return new PolicyOutboxDto(this);
	}

	
	public Integer getPolicyOutboxId() {
		return policyOutboxId;
	}
		
	public void setPolicyOutboxId(Integer policyOutboxId) {
		this.policyOutboxId = policyOutboxId;
	}
	
	public Integer getInsurancePolicyId() {
		return insurancePolicyId;
	}
		
	public void setInsurancePolicyId(Integer insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
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
