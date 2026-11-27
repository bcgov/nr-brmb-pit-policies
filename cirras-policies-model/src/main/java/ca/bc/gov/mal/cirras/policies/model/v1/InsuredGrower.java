package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface InsuredGrower extends Serializable {

	public Integer getGrowerId();
	public void setGrowerId(Integer growerId);
	
	public Integer getGrowerNumber();
	public void setGrowerNumber(Integer growerNumber);
	
	public String getVendorNumber();
	public void setVendorNumber(String vendorNumber);
	
	public String getGrowerName();
	public void setGrowerName(String growerName) ;

	public String getGrowerAddressLine1();
	public void setGrowerAddressLine1(String growerAddressLine1) ;

	public String getGrowerAddressLine2();
	public void setGrowerAddressLine2(String growerAddressLine2);

	public String getGrowerPostalCode() ;
	public void setGrowerPostalCode(String growerPostalCode);

	public Integer getGrowerCityId();
	public void setGrowerCityId(Integer growerCityId);

	public String getGrowerCity();
	public void setGrowerCity(String growerCity);
	
	public String getGrowerProvince();
	public void setGrowerProvince(String growerProvince);

}
