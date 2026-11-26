package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface GrowerContractYear extends Serializable {

	public Integer getGrowerContractYearId();
	public void setGrowerContractYearId(Integer growerContractYearId);

	public Integer getContractId();
	public void setContractId(Integer contractId);

	public Integer getGrowerId();
	public void setGrowerId(Integer growerId);

	public Integer getInsurancePlanId();
	public void setInsurancePlanId(Integer insurancePlanId);

	public Integer getCropYear();
	public void setCropYear(Integer cropYear);
}
