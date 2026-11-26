package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;



public class ContactsDto extends BaseDto<ContactsDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ContactsDto.class);

	private Integer contactsId;
	private String firstName;
	private String lastName;
	
	public ContactsDto() {
	}
	
	
	public ContactsDto(ContactsDto dto) {
		this.contactsId = dto.contactsId;
		this.firstName = dto.firstName;
		this.lastName = dto.lastName;
	}
	

	@Override
	public boolean equalsBK(ContactsDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ContactsDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ContactsDto copy() {
		return new ContactsDto(this);
	}

	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}
 
 	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
 	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 	
}
