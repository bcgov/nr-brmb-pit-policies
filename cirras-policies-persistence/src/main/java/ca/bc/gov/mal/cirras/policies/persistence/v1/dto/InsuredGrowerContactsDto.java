package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;



public class InsuredGrowerContactsDto extends BaseDto<InsuredGrowerContactsDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(InsuredGrowerContactsDto.class);

	private Integer growerContactsId;
	private Integer growerId;
	private Integer contactsId;
	private Boolean isPrimaryContactInd;
	private Boolean isActivelyInvolvedInd;

	
	public InsuredGrowerContactsDto() {
	}
	
	
	public InsuredGrowerContactsDto(InsuredGrowerContactsDto dto) {
		this.growerContactsId = dto.growerContactsId;
		this.growerId = dto.growerId;
		this.contactsId = dto.contactsId;
		this.isPrimaryContactInd = dto.isPrimaryContactInd;
		this.isActivelyInvolvedInd = dto.isActivelyInvolvedInd;
	}
	

	@Override
	public boolean equalsBK(InsuredGrowerContactsDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(InsuredGrowerContactsDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public InsuredGrowerContactsDto copy() {
		return new InsuredGrowerContactsDto(this);
	}

 	public Integer getGrowerContactsId() {
		return growerContactsId;
	}

	public void setGrowerContactsId(Integer growerContactsId) {
		this.growerContactsId = growerContactsId;
	}
 
 	public Integer getGrowerId() {
		return growerId;
	}

	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
	}
 
 	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}
 
 	public Boolean getIsPrimaryContactInd() {
		return isPrimaryContactInd;
	}

	public void setIsPrimaryContactInd(Boolean isPrimaryContactInd) {
		this.isPrimaryContactInd = isPrimaryContactInd;
	}
 
 	public Boolean getIsActivelyInvolvedInd() {
		return isActivelyInvolvedInd;
	}

	public void setIsActivelyInvolvedInd(Boolean isActivelyInvolvedInd) {
		this.isActivelyInvolvedInd = isActivelyInvolvedInd;
	}
 	
}
