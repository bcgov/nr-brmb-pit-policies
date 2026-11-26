package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class CommodityTypeVarietyXrefOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer commodityTypeVarietyXrefOutboxId;
	private String commodityTypeCode;
	private Integer varietyId;


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
	
	
	@Override
	public String getSourceKey() {
		return commodityTypeCode + "_" + varietyId;
	}
	
	@Override
	public Integer getOutboxKey() {
		return commodityTypeVarietyXrefOutboxId;
	}
}
