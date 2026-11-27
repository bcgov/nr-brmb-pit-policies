package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;



public class EmailsDto extends BaseDto<EmailsDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(EmailsDto.class);

	private Integer emailsId;
	private Integer contactsId;
	private String emailAddress;
	private Boolean isPrimaryEmailInd;
	private Boolean isActive;
	
	public EmailsDto() {
	}
	
	
	public EmailsDto(EmailsDto dto) {
		this.emailsId = dto.emailsId;
		this.contactsId = dto.contactsId;
		this.emailAddress = dto.emailAddress;
		this.isPrimaryEmailInd = dto.isPrimaryEmailInd;
		this.isActive = dto.isActive;
	}
	

	@Override
	public boolean equalsBK(EmailsDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(EmailsDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public EmailsDto copy() {
		return new EmailsDto(this);
	}

 	public Integer getEmailsId() {
		return emailsId;
	}

	public void setEmailsId(Integer emailsId) {
		this.emailsId = emailsId;
	}
 
 	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}
 
 	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
 
 	public Boolean getIsPrimaryEmailInd() {
		return isPrimaryEmailInd;
	}

	public void setIsPrimaryEmailInd(Boolean isPrimaryEmailInd) {
		this.isPrimaryEmailInd = isPrimaryEmailInd;
	}

 	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
