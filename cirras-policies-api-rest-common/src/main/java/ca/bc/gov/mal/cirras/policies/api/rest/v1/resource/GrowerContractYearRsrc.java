package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerContractYear;
import ca.bc.gov.nrs.common.wfone.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.GROWER_CONTRACT_YEAR_NAME)
@XmlSeeAlso({ GrowerContractYearRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class GrowerContractYearRsrc extends BaseResource implements GrowerContractYear {

	private static final long serialVersionUID = 1L;

	private Integer growerContractYearId;
	private Integer contractId;
	private Integer growerId;
	private Integer insurancePlanId;
	private Integer cropYear;

 	public Integer getGrowerContractYearId() {
		return growerContractYearId;
	}

	public void setGrowerContractYearId(Integer growerContractYearId) {
		this.growerContractYearId = growerContractYearId;
	}
 
 	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
 
 	public Integer getGrowerId() {
		return growerId;
	}

	public void setGrowerId(Integer growerId) {
		this.growerId = growerId;
	}
 
 	public Integer getInsurancePlanId() {
		return insurancePlanId;
	}

	public void setInsurancePlanId(Integer insurancePlanId) {
		this.insurancePlanId = insurancePlanId;
	}
 
 	public Integer getCropYear() {
		return cropYear;
	}

	public void setCropYear(Integer cropYear) {
		this.cropYear = cropYear;
	}
	
}
