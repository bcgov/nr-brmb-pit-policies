package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class Variety implements Serializable {
	private static final long serialVersionUID = 5726905902897809547L;

	private Integer cropVarietyId;
	private String varietyName;
	private Double averagePrice;
	
	public Integer getCropVarietyId() {
		return cropVarietyId;
	}

	public void setCropVarietyId(Integer cropVarietyId) {
		this.cropVarietyId = cropVarietyId;
	}

	public String getVarietyName() {
		return varietyName;
	}

	public void setVarietyName(String varietyName) {
		this.varietyName = varietyName;
	}

	public Double getAveragePrice() {
		return averagePrice;
	}
	
	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}

}
