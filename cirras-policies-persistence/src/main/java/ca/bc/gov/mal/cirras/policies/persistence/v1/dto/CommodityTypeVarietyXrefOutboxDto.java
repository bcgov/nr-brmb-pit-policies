package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;

public class CommodityTypeVarietyXrefOutboxDto extends BaseDto<CommodityTypeVarietyXrefOutboxDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CommodityTypeVarietyXrefOutboxDto.class);
	
	private Integer commodityTypeVarietyXrefOutboxId;
	private String commodityTypeCode;
	private Integer varietyId;
	private String transactionType;
	private Date entryTimestamp;
	
	public CommodityTypeVarietyXrefOutboxDto() {
	}

	
	public CommodityTypeVarietyXrefOutboxDto(CommodityTypeVarietyXrefOutboxDto dto) {
		this.commodityTypeVarietyXrefOutboxId = dto.commodityTypeVarietyXrefOutboxId;
		this.commodityTypeCode = dto.commodityTypeCode;
		this.varietyId = dto.varietyId;
		this.transactionType = dto.transactionType;
		this.entryTimestamp = dto.entryTimestamp;
	}

	@Override
	public boolean equalsBK(CommodityTypeVarietyXrefOutboxDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(CommodityTypeVarietyXrefOutboxDto other) {
		//Only called when updating a record, which never happens for outboxes.
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public CommodityTypeVarietyXrefOutboxDto copy() {
		return new CommodityTypeVarietyXrefOutboxDto(this);
	}

	public Integer getCommodityTypeVarietyXrefOutboxId() {
		return commodityTypeVarietyXrefOutboxId;
	}

	public void setCommodityTypeVarietyXrefOutboxId(Integer commodityTypeVarietyXrefOutboxId) {
		this.commodityTypeVarietyXrefOutboxId = commodityTypeVarietyXrefOutboxId;
	}

	public String getCommodityTypeCode() {
		return commodityTypeCode;
	}

	public void setCommodityTypeCode(String commodityTypeCode) {
		this.commodityTypeCode = commodityTypeCode;
	}

	public Integer getVarietyId() {
		return varietyId;
	}

	public void setVarietyId(Integer varietyId) {
		this.varietyId = varietyId;
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
