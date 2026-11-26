package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;



public class GrowerContractYearDto extends BaseDto<GrowerContractYearDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(GrowerContractYearDto.class);

	private Integer growerContractYearId;
	private Integer contractId;
	private Integer growerId;
	private Integer insurancePlanId;
	private Integer cropYear;

	public GrowerContractYearDto() {
	}
	
	
	public GrowerContractYearDto(GrowerContractYearDto dto) {
		this.growerContractYearId = dto.growerContractYearId;
		this.contractId = dto.contractId;
		this.growerId = dto.growerId;
		this.insurancePlanId = dto.insurancePlanId;
		this.cropYear = dto.cropYear;
	}
	

	@Override
	public boolean equalsBK(GrowerContractYearDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(GrowerContractYearDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public GrowerContractYearDto copy() {
		return new GrowerContractYearDto(this);
	}

 	public Integer getGrowerContractYearId() {
		return growerContractYearId;
	}

	public void setGrowerContractYearId(Integer growerContractYearId) {
		this.growerContractYearId = growerContractYearId;
	}
 
 	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
 
 	public Integer getGrowerId() {
		return growerId;
	}

	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
	}
 
 	public Integer getInsurancePlanId() {
		return insurancePlanId;
	}

	public void setInsurancePlanId(Integer insurancePlanId) {
		this.insurancePlanId = insurancePlanId;
	}
 
 	public Integer getCropYear() {
		return cropYear;
	}

	public void setCropYear(Integer cropYear) {
		this.cropYear = cropYear;
	}
	
}
