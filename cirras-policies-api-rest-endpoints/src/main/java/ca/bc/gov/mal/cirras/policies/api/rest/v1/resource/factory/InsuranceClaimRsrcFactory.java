package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.factory;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.UriBuilder;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.ClaimCalculationSubmitEndpoint;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.InsuranceClaimEndpoint;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.endpoints.InsuranceClaimListEndpoint;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimListRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.InsuranceClaimRsrc;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaim;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaimList;
import ca.bc.gov.mal.cirras.policies.model.v1.Variety;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.VarietyDto;
import ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory.InsuranceClaimFactory;
import ca.bc.gov.nrs.common.wfone.rest.resource.RelLink;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.rest.endpoints.resource.factory.BaseResourceFactory;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryContext;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class InsuranceClaimRsrcFactory extends BaseResourceFactory implements InsuranceClaimFactory {
	
	@Override
	public InsuranceClaim getInsuranceClaim(
			ClaimDto dto, 
			boolean createSelfLink,
			FactoryContext context, 
			WebAdeAuthentication authentication) 
			throws FactoryException {
		
		InsuranceClaimRsrc resource = new InsuranceClaimRsrc();
		
		populateResource(resource, dto);
		
		if(!dto.getVarieties().isEmpty()) {
			List<Variety> modelVarieties = new ArrayList<Variety>();
			
			for(VarietyDto vdto: dto.getVarieties()) {
				Variety modelVariety = createVariety(vdto);
				modelVarieties.add(modelVariety);
			}
			
			resource.setVarieties(modelVarieties);
		}
		
		String eTag = getEtag(resource);
		resource.setETag(eTag);

		if ( createSelfLink ) { 
			URI baseUri = getBaseURI(context);
			setSelfLink(dto.getClaimNumber(), resource, baseUri);
		}
		
		return resource;
	}
	
	@Override
	public InsuranceClaimList<? extends InsuranceClaim> getClaimCalculationList(
			List<ClaimSearchDto> dtos,
			Integer claimNumber,
			String policyNumber,
			FactoryContext context, 
			WebAdeAuthentication authentication
	) throws FactoryException, DaoException {
		URI baseUri = getBaseURI(context);
		
		InsuranceClaimListRsrc result = null;
		
		List<InsuranceClaimRsrc> resources = new ArrayList<InsuranceClaimRsrc>();
		
		for (ClaimSearchDto dto : dtos) {
			InsuranceClaimRsrc resource = new InsuranceClaimRsrc();
			
			populateResource(resource, dto);
			// don't populate varieties for search results
			
			setSelfLink(dto.getClaimNumber(), resource, baseUri);
			resources.add(resource);
		}
		
		//ClaimCalculationListRsrc
		result = new InsuranceClaimListRsrc();
		result.setCollection(resources);
		
		String eTag = getEtag(result);
		result.setETag(eTag);		
		
		setSelfLink(result, 
				claimNumber, 
				policyNumber, 
				baseUri);
		
		return result;
	}

	private void populateResource(InsuranceClaimRsrc resource, ClaimSearchDto dto) {

		resource.setClaimNumber(dto.getClaimNumber());
		resource.setPolicyNumber(dto.getPolicyNumber());
		resource.setGrowerNumber(dto.getGrowerNumber());
		resource.setGrowerName(dto.getGrowersLegalName());
		resource.setInsurancePlanId(dto.getInsurancePlanId());
		resource.setInsurancePlanName(dto.getPlanName());
		resource.setCoverageName(dto.getCropCoverage());
		resource.setCommodityCoverageCode(dto.getCropCoverageCode());
		resource.setCommodityName(dto.getCommodityName());
		resource.setCropCommodityId(dto.getCommodityId());
		resource.setClaimStatus(dto.getClaimStatus());
		resource.setClaimStatusCode(dto.getClaimStatusCode());
		resource.setClaimType(dto.getClaimType());

	}
	
	private static void setSelfLink(
			InsuranceClaimListRsrc resource, 
			Integer claimNumber, 
			String policyNumber,
			URI baseUri) {
			
			String selfUri = getInsuranceClaimListSelfUri(
					claimNumber,
					policyNumber,
					baseUri);
			
			resource.getLinks().add(new RelLink(ResourceTypes.SELF, selfUri, "GET"));
	}
	

	public static String getInsuranceClaimListSelfUri(
		Integer claimNumber, 
		String policyNumber,
		URI baseUri) {

		String result = UriBuilder.fromUri(baseUri)
			.path(InsuranceClaimListEndpoint.class)
			.queryParam("claimNumber", nvl(claimNumber, ""))
			.queryParam("policyNumber", nvl(policyNumber, ""))
			.build()
			.toString();

		return result;
	}
	
	private Variety createVariety(VarietyDto dto) {
		Variety model = new Variety();
		
		model.setCropVarietyId(dto.getCropVarietyId());
		model.setVarietyName(dto.getVarietyName());
		model.setAveragePrice(dto.getAveragePrice());
		
		return model;
	}
	
	private void populateResource(InsuranceClaimRsrc resource, ClaimDto dto) {

		resource.setClaimId(dto.getClaimId());
		resource.setGrowerId(dto.getGrowerId());
		resource.setPurchaseId(dto.getPurchaseId());
		resource.setClaimNumber(dto.getClaimNumber());
		resource.setClaimStatusCode(dto.getClaimStatusCode());
		resource.setPolicyNumber(dto.getPolicyNumber());
		resource.setInsurancePolicyId(dto.getInsurancePolicyId());
		resource.setContractId(dto.getContractId());
		resource.setInsurancePlanId(dto.getInsurancePlanId());
		resource.setInsurancePlanName(dto.getPlanName());
		resource.setCropCommodityId(dto.getCropCommodityId());
		resource.setCommodityName(dto.getCommodityName());
		resource.setGrowerNumber(dto.getGrowerNumber());
		resource.setGrowerName(dto.getGrowerName());
		resource.setGrowerAddressLine1(dto.getGrowerAddressLine1());
		resource.setGrowerAddressLine2(dto.getGrowerAddressLine2());
		resource.setGrowerPostalCode(dto.getGrowerPostalCode());
		resource.setGrowerCity(dto.getGrowerCity());
		resource.setGrowerProvince(dto.getGrowerProvince());
		resource.setCropYear(dto.getCropYear());
		resource.setCommodityCoverageCode(dto.getCommodityCoverageCode());
		resource.setCoverageName(dto.getCropCoverage());
		resource.setInsurableValueSelected(dto.getInsurableValueSelected());
		resource.setInsurableValueHundredPercent(dto.getInsurableValueHundredPercent());
		resource.setProductionGuarantee(dto.getProductionGuarantee());
		resource.setCoverageAmount(dto.getCoverageAmount());
		resource.setSubmittedByUserid(dto.getSubmittedByUserid());
		resource.setSubmittedByName(dto.getSubmittedByName());
		resource.setSubmittedByDate(dto.getSubmittedByDate());
		resource.setRecommendedByUserid(dto.getRecommendedByUserid());
		resource.setRecommendedByName(dto.getRecommendedByName());
		resource.setRecommendedByDate(dto.getRecommendedByDate());
		resource.setApprovedByUserid(dto.getApprovedByUserid());
		resource.setApprovedByName(dto.getApprovedByName());
		resource.setApprovedByDate(dto.getApprovedByDate());
		resource.setCalculateIivInd(dto.getCalculateIivInd());
		resource.setTotalProbableYield(dto.getTotalProbableYield());
		resource.setDeclaredAcres(dto.getDeclaredAcres());
		resource.setDeductibleLevel(dto.getDeductibleLevel());
		resource.setPlantDeclaredAcres(dto.getPlantDeclaredAcres());
		resource.setPlantDeclaredUnits(dto.getPlantDeclaredUnits());
		resource.setPlantInsurableValue(dto.getPlantInsurableValue());
		resource.setInsuredByMeasurementType(dto.getInsuredByMeasurementType());
		resource.setHasChequeReqInd(dto.getHasChequeReqInd());
	}
	
	static void setSelfLink(Integer claimNumber, InsuranceClaimRsrc resource, URI baseUri) {
		String selfUri = getInsuranceClaimSelfUri(claimNumber, baseUri);
		resource.getLinks().add(new RelLink(ResourceTypes.SELF, selfUri, "GET"));
	}
	
	
	public static String getInsuranceClaimSelfUri(Integer claimNumber, URI baseUri) {
		String result = UriBuilder.fromUri(baseUri)
			.path(InsuranceClaimEndpoint.class)
			.queryParam("claimNumber", nvl(claimNumber, ""))
			.build()
			.toString();
		return result;
	}

	
	public static String getClaimsSelfUri(
		Integer claimNumber, 
		String policyNumber,
		URI baseUri) {

		String result = UriBuilder.fromUri(baseUri)
			.path(InsuranceClaimListEndpoint.class)
			.queryParam("claimNumber", nvl(claimNumber, ""))
			.queryParam("policyNumber", nvl(policyNumber, ""))
			.build()
			.toString();

		return result;
	}
	
	public static String getClaimCalculationSubmitSelfUri(URI baseUri) {

		String result = UriBuilder.fromUri(baseUri)
			.path(ClaimCalculationSubmitEndpoint.class)
			.build()
			.toString();

		return result;
	}	
	
	protected static String nvl(Integer value, String defaultValue) {
		return (value==null)?defaultValue:value.toString();
	}
}
