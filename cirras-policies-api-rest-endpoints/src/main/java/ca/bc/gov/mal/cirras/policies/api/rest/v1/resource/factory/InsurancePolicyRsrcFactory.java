package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsurancePolicyRsrc;
import ca.bc.gov.mal.cirras.policies.model.v1.InsurancePolicy;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.InsurancePolicyFactory;
import ca.bc.gov.mal.pit.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.mal.pit.common.service.api.model.factory.FactoryException;

public class InsurancePolicyRsrcFactory extends BaseResourceFactory implements InsurancePolicyFactory {
	
	@Override
	public InsurancePolicy getInsurancePolicy(PolicyDto dto) throws FactoryException {
		
		InsurancePolicyRsrc resource = new InsurancePolicyRsrc();
		
		populateResource(resource, dto);
		
		String eTag = getEtag(resource);
		resource.setETag(eTag);

		// Not creating self-link because there is no endpoint.
		
		return resource;
	}
	
	private void populateResource(InsurancePolicyRsrc resource, PolicyDto dto) {
		resource.setContractId(dto.getContractId());
		resource.setCropYear(dto.getCropYear());
		resource.setGrowerId(dto.getGrowerId());
		resource.setGrowerName(dto.getGrowerName());
		resource.setInsurancePlanId(dto.getInsurancePlanId());
		resource.setInsurancePolicyId(dto.getInsurancePolicyId());
		resource.setContractNumber(dto.getContractNumber());
		resource.setOfficeId(dto.getOfficeId());
		resource.setPolicyNumber(dto.getPolicyNumber());
		resource.setPolicyStatusCode(dto.getPolicyStatusCode());
	}

}
