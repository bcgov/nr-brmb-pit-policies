package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.nrs.wfone.common.persistence.dto.BaseDto;

public class ProductOutboxDto extends BaseDto<ProductOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ProductOutboxDto.class);
	
	private Integer productOutboxId;
	private Integer productId;
	private String transactionType;
	private Date entryTimestamp;
	
	public ProductOutboxDto() {
	}

	
	public ProductOutboxDto(ProductOutboxDto dto) {
		this.productOutboxId = dto.productOutboxId;
		this.productId = dto.productId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(ProductOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ProductOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ProductOutboxDto copy() {
		return new ProductOutboxDto(this);
	}

	public Integer getProductOutboxId() {
		return productOutboxId;
	}
		
	public void setProductOutboxId(Integer productOutboxId) {
		this.productOutboxId = productOutboxId;
	}
	
	public Integer getProductId() {
		return productId;
	}
		
	public void setProductId(Integer productId) {
		this.productId = productId;
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
