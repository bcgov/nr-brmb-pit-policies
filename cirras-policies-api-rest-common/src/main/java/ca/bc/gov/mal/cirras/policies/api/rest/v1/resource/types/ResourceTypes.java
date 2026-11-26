package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types;

import ca.bc.gov.mal.pit.common.rest.resource.types.BaseResourceTypes;

public class ResourceTypes extends BaseResourceTypes {
	
	public static final String NAMESPACE = "http://policies.cirras.mal.gov.bc.ca/v1/";

	public static final String ENDPOINTS_NAME = "endpoints";
	public static final String ENDPOINTS = NAMESPACE + ENDPOINTS_NAME;
	

	public static final String INSURANCE_CLAIM_LIST_NAME = "insuranceClaimList";
	public static final String INSURANCE_CLAIM_LIST = NAMESPACE + INSURANCE_CLAIM_LIST_NAME;

	public static final String INSURANCE_CLAIM_NAME = "insuranceClaim";
	public static final String INSURANCE_CLAIM = NAMESPACE + INSURANCE_CLAIM_NAME;

	public static final String INSURANCE_POLICY_NAME = "insurancePolicy";
	public static final String INSURANCE_POLICY = NAMESPACE + INSURANCE_POLICY_NAME;

	public static final String GROWER_CONTRACT_YEAR_NAME = "growerContractYear";
	public static final String GROWER_CONTRACT_YEAR = NAMESPACE + GROWER_CONTRACT_YEAR_NAME;
	
	public static final String INSURED_GROWER_NAME = "insuredGrower";
	public static final String INSURED_GROWER = NAMESPACE + INSURED_GROWER_NAME;

	public static final String CLAIM_CALCULATION_SUBMIT_NAME = "claimCalculationSubmit";
	public static final String CLAIM_CALCULATION_SUBMIT = NAMESPACE + CLAIM_CALCULATION_SUBMIT_NAME;

	public static final String COMMODITY_VARIETY_SYNC_NAME = "commodityVarietySync";
	public static final String COMMODITY_VARIETY_SYNC = NAMESPACE + COMMODITY_VARIETY_SYNC_NAME;

	public static final String CODE_SYNC_NAME = "codeSync";
	public static final String CODE_SYNC = NAMESPACE + CODE_SYNC_NAME;

	public static final String COVERAGE_PERIL_SYNC_NAME = "coveragePerilSync";
	public static final String COVERAGE_PERIL_SYNC = NAMESPACE + COVERAGE_PERIL_SYNC_NAME;

	public static final String CONTACTS_NAME = "contacts";
	public static final String CONTACTS = NAMESPACE + CONTACTS_NAME;

	public static final String INSURED_GROWER_CONTACTS_NAME = "insuredGrowerContacts";
	public static final String INSURED_GROWER_CONTACTS = NAMESPACE + INSURED_GROWER_CONTACTS_NAME;

	public static final String EMAILS_NAME = "emails";
	public static final String EMAILS = NAMESPACE + EMAILS_NAME;

	public static final String TELECOM_NAME = "telecom";
	public static final String TELECOM = NAMESPACE + TELECOM_NAME;

	public static final String PRODUCT_LIST_NAME = "productList";
	public static final String PRODUCT_LIST = NAMESPACE + PRODUCT_LIST_NAME;
	
	public static final String PRODUCT_NAME = "product";
	public static final String PRODUCT = NAMESPACE + PRODUCT_NAME;

	public static final String COMMODITY_TYPE_CODE_SYNC_NAME = "commodityTypeCodeSync";
	public static final String COMMODITY_TYPE_CODE_SYNC = NAMESPACE + COMMODITY_TYPE_CODE_SYNC_NAME;
	
	public static final String COMMODITY_TYPE_VARIETY_XREF_SYNC_NAME = "commodityTypeVarietyXrefSync";
	public static final String COMMODITY_TYPE_VARIETY_XREF_SYNC = NAMESPACE + COMMODITY_TYPE_VARIETY_XREF_SYNC_NAME;
}

