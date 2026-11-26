package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;



public class ProductNolDto extends BaseDto<ProductNolDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ProductNolDto.class);
	
	private Integer productNolId;
	private Integer nolId;
	private Integer colId;
	private Integer ippId;
	private String perilTypeCode;

	
	public ProductNolDto() {
	}
	
	
	public ProductNolDto(ProductNolDto dto) {
	}
	

	@Override
	public boolean equalsBK(ProductNolDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ProductNolDto other) {
		// this is a search results and this method only gets called when doing updates to records
		return false;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ProductNolDto copy() {
		return new ProductNolDto(this);
	}


	public Integer getProductNolId() {
		return productNolId;
	}


	public void setProductNolId(Integer productNolId) {
		this.productNolId = productNolId;
	}


	public Integer getNolId() {
		return nolId;
	}


	public void setNolId(Integer nolId) {
		this.nolId = nolId;
	}


	public Integer getColId() {
		return colId;
	}


	public void setColId(Integer colId) {
		this.colId = colId;
	}


	public Integer getIppId() {
		return ippId;
	}


	public void setIppId(Integer ippId) {
		this.ippId = ippId;
	}


	public String getPerilTypeCode() {
		return perilTypeCode;
	}


	public void setPerilTypeCode(String perilTypeCode) {
		this.perilTypeCode = perilTypeCode;
	}
}
