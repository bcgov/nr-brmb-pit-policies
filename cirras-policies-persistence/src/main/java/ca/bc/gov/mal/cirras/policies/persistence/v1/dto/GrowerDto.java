package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;



public class GrowerDto extends BaseDto<GrowerDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(GrowerDto.class);

	private Integer growerId;
	private Integer growerNumber;
	private String vendorNumber;
	private String growerName;
	private String growerAddressLine1;
	private String growerAddressLine2;
	private String growerPostalCode;
	private Integer growerCityId;
	private String growerCity;
	private String growerProvince;

	
	public GrowerDto() {
	}
	
	
	public GrowerDto(GrowerDto dto) {
		this.growerId = dto.growerId;
		this.growerNumber = dto.growerNumber;
		this.vendorNumber = dto.vendorNumber;
		this.growerName = dto.growerName;
		this.growerAddressLine1 = dto.growerAddressLine1;
		this.growerAddressLine2 = dto.growerAddressLine2;
		this.growerPostalCode = dto.growerPostalCode;
		this.growerCityId = dto.growerCityId;		
		this.growerCity = dto.growerCity;
		this.growerProvince = dto.growerProvince;
	}
	

	@Override
	public boolean equalsBK(GrowerDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(GrowerDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public GrowerDto copy() {
		return new GrowerDto(this);
	}

	public Integer getGrowerId() {
		return growerId;
	}
	
	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
	}

	public Integer getGrowerNumber() {
		return growerNumber;
	}

	public void setGrowerNumber(Integer growerNumber) {
		this.growerNumber = growerNumber;
	}

	public String getVendorNumber() {
		return vendorNumber;
	}

	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}

	public String getGrowerName() {
		return growerName;
	}

	public void setGrowerName(String growerName) {
		this.growerName = growerName;
	}

	public String getGrowerAddressLine1() {
		return growerAddressLine1;
	}

	public void setGrowerAddressLine1(String growerAddressLine1) {
		this.growerAddressLine1 = growerAddressLine1;
	}

	public String getGrowerAddressLine2() {
		return growerAddressLine2;
	}

	public void setGrowerAddressLine2(String growerAddressLine2) {
		this.growerAddressLine2 = growerAddressLine2;
	}

	public String getGrowerPostalCode() {
		return growerPostalCode;
	}

	public void setGrowerPostalCode(String growerPostalCode) {
		this.growerPostalCode = growerPostalCode;
	}

	public Integer getGrowerCityId() {
		return growerCityId;
	}
	
	public void setGrowerCityId(Integer growerCityId) {
		this.growerCityId = growerCityId;
	}

	public String getGrowerCity() {
		return growerCity;
	}
	
	public void setGrowerCity(String growerCity) {
		this.growerCity = growerCity;
	}
	
	public String getGrowerProvince() {
		return growerProvince;
	}
	
	public void setGrowerProvince(String growerProvince) {
		this.growerProvince = growerProvince;
	}
	
}
