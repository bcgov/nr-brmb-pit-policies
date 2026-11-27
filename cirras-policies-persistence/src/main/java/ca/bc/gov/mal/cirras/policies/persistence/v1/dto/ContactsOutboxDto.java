package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;

public class ContactsOutboxDto extends BaseDto<ContactsOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ContactsOutboxDto.class);
	
	private Integer contactsOutboxId;
	private Integer contactsId;
	private String transactionType;
	private Date entryTimestamp;
	
	public ContactsOutboxDto() {
	}

	
	public ContactsOutboxDto(ContactsOutboxDto dto) {
		this.contactsOutboxId = dto.contactsOutboxId;
		this.contactsId = dto.contactsId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(ContactsOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ContactsOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ContactsOutboxDto copy() {
		return new ContactsOutboxDto(this);
	}

	public Integer getContactsOutboxId() {
		return contactsOutboxId;
	}
		
	public void setContactsOutboxId(Integer contactsOutboxId) {
		this.contactsOutboxId = contactsOutboxId;
	}
	
	public Integer getContactsId() {
		return contactsId;
	}
		
	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
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
