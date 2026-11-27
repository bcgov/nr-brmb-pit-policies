package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;



public class TelecomDto extends BaseDto<TelecomDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(TelecomDto.class);

	private Integer telecomId;
	private Integer contactsId;
	private String phoneNumber;
	private String extension;
	private Boolean isPrimaryPhoneInd;
	private String telecomTypeCode;
	private Boolean isActive;
	
	public TelecomDto() {
	}
	
	
	public TelecomDto(TelecomDto dto) {
		this.telecomId = dto.telecomId;
		this.contactsId = dto.contactsId;
		this.phoneNumber = dto.phoneNumber;
		this.extension = dto.extension;
		this.isPrimaryPhoneInd = dto.isPrimaryPhoneInd;
		this.telecomTypeCode = dto.telecomTypeCode;
		this.isActive = dto.isActive;
	}
	

	@Override
	public boolean equalsBK(TelecomDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(TelecomDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public TelecomDto copy() {
		return new TelecomDto(this);
	}

 	public Integer getTelecomId() {
		return telecomId;
	}

	public void setTelecomId(Integer telecomId) {
		this.telecomId = telecomId;
	}
 
 	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}
 
 	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
 
 	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
 
 	public Boolean getIsPrimaryPhoneInd() {
		return isPrimaryPhoneInd;
	}

	public void setIsPrimaryPhoneInd(Boolean isPrimaryPhoneInd) {
		this.isPrimaryPhoneInd = isPrimaryPhoneInd;
	}

	public String getTelecomTypeCode() {
		return telecomTypeCode;
	}

	public void setTelecomTypeCode(String telecomTypeCode) {
		this.telecomTypeCode = telecomTypeCode;
	}

 	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
