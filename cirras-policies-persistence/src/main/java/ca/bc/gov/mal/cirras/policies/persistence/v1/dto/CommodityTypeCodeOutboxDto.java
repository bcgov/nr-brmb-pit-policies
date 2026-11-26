package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;

public class CommodityTypeCodeOutboxDto extends BaseDto<CommodityTypeCodeOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CommodityTypeCodeOutboxDto.class);
	
	private Integer commodityTypeCodeOutboxId;
	private String commodityTypeCode;
	private String transactionType;
	private Date entryTimestamp;
	
	public CommodityTypeCodeOutboxDto() {
	}

	
	public CommodityTypeCodeOutboxDto(CommodityTypeCodeOutboxDto dto) {
		this.commodityTypeCodeOutboxId = dto.commodityTypeCodeOutboxId;
		this.commodityTypeCode = dto.commodityTypeCode;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}	

	@Override
	public boolean equalsBK(CommodityTypeCodeOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CommodityTypeCodeOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CommodityTypeCodeOutboxDto copy() {
		return new CommodityTypeCodeOutboxDto(this);
	}

	public Integer getCommodityTypeCodeOutboxId() {
		return commodityTypeCodeOutboxId;
	}

	public void setCommodityTypeCodeOutboxId(Integer commodityTypeCodeOutboxId) {
		this.commodityTypeCodeOutboxId = commodityTypeCodeOutboxId;
	}

	public String getCommodityTypeCode() {
		return commodityTypeCode;
	}

	public void setCommodityTypeCode(String commodityTypeCode) {
		this.commodityTypeCode = commodityTypeCode;
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
