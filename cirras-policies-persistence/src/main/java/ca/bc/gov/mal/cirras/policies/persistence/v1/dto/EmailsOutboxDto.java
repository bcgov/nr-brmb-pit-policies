package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;

public class EmailsOutboxDto extends BaseDto<EmailsOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(EmailsOutboxDto.class);
	
	private Integer emailsOutboxId;
	private Integer emailsId;
	private String transactionType;
	private Date entryTimestamp;
	
	public EmailsOutboxDto() {
	}

	
	public EmailsOutboxDto(EmailsOutboxDto dto) {
		this.emailsOutboxId = dto.emailsOutboxId;
		this.emailsId = dto.emailsId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(EmailsOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(EmailsOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public EmailsOutboxDto copy() {
		return new EmailsOutboxDto(this);
	}

	public Integer getEmailsOutboxId() {
		return emailsOutboxId;
	}
		
	public void setEmailsOutboxId(Integer emailsOutboxId) {
		this.emailsOutboxId = emailsOutboxId;
	}
	
	public Integer getEmailsId() {
		return emailsId;
	}
		
	public void setEmailsId(Integer emailsId) {
		this.emailsId = emailsId;
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
