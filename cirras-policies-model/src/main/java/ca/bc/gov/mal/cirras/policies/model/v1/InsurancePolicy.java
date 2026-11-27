package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

public interface InsurancePolicy extends Serializable {

	public Integer getInsurancePolicyId();
	public void setInsurancePolicyId(Integer insurancePolicyId);

	public Integer getGrowerId();
	public void setGrowerId(Integer growerId);

	public String getGrowerName();
	public void setGrowerName(String growerName);	
	
	public Integer getInsurancePlanId();
	public void setInsurancePlanId(Integer insurancePlanId);

	public Integer getContractId();
	public void setContractId(Integer contractId);

	public Integer getCropYear();
	public void setCropYear(Integer cropYear);

	public Integer getOfficeId();
	public void setOfficeId(Integer officeId);

	public String getPolicyStatusCode();
	public void setPolicyStatusCode(String policyStatusCode);

	public String getPolicyNumber();
	public void setPolicyNumber(String policyNumber);

	public String getContractNumber();
	public void setContractNumber(String contractNumber);

}
