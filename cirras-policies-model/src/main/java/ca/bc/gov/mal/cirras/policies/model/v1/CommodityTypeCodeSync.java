package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface CommodityTypeCodeSync extends Serializable {

	public String getCommodityTypeCode();
	public void setCommodityTypeCode(String commodityTypeCode);

	public String getDescription();
	public void setDescription(String description);

	public Integer getCropId();
	public void setCropId(Integer cropId);

	public Boolean getIsActive();
	public void setIsActive(Boolean isActive);
 
}
