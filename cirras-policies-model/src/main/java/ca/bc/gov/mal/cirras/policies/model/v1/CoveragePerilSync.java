package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface CoveragePerilSync extends Serializable {

 	public Integer getCoveragePerilId();
	public void setCoveragePerilId(Integer coveragePerilId);	
	
 	public Integer getCropCommodityId();
	public void setCropCommodityId(Integer cropCommodityId);
 
 	public String getPerilCode();
	public void setPerilCode(String perilCode);
 
 	public String getCommodityCoverageCode();
	public void setCommodityCoverageCode(String commodityCoverageCode); 
 
 	public Integer getCropCoverageId();
	public void setCropCoverageId(Integer cropCoverageId);

 	public Boolean getIsActive();
	public void setIsActive(Boolean isActive);
	
}
