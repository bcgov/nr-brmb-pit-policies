package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;



public class CodeSyncDto extends BaseDto<CodeSyncDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CodeSyncDto.class);

	private String codeTableType;
	private String uniqueKeyString;
	private Integer uniqueKeyInteger;
	private String description;
	private Boolean isActive;
	
	public CodeSyncDto() {
	}
	
	
	public CodeSyncDto(CodeSyncDto dto) {
		this.codeTableType = dto.codeTableType;
		this.uniqueKeyString = dto.uniqueKeyString;
		this.uniqueKeyInteger = dto.uniqueKeyInteger;
		this.description = dto.description;
		this.isActive = dto.isActive;
	}
	

	@Override
	public boolean equalsBK(CodeSyncDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CodeSyncDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CodeSyncDto copy() {
		return new CodeSyncDto(this);
	}

 	public String getCodeTableType() {
		return codeTableType;
	}

	public void setCodeTableType(String codeTableType) {
		this.codeTableType = codeTableType;
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
 
 	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
 
 	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
