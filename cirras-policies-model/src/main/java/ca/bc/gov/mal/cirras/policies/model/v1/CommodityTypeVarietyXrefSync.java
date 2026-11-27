package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface CommodityTypeVarietyXrefSync extends Serializable {

	public String getCommodityTypeCode();
	public void setCommodityTypeCode(String commodityTypeCode);

	public Integer getVarietyId();
	public void setVarietyId(Integer varietyId);
 
}
