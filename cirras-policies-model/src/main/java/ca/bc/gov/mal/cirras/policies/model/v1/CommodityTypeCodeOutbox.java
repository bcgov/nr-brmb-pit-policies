package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class CommodityTypeCodeOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer commodityTypeCodeOutboxId;
	private String commodityTypeCode;


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
	
	@Override
	public String getSourceKey() {
		return commodityTypeCode;
	}
	
	@Override
	public Integer getOutboxKey() {
		return commodityTypeCodeOutboxId;
	}
}
