package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.pit.common.rest.resource.PagedResource;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuranceClaimList;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.INSURANCE_CLAIM_LIST_NAME)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({ @Type(value = InsuranceClaimListRsrc.class, name = ResourceTypes.INSURANCE_CLAIM_LIST) })
public class InsuranceClaimListRsrc extends PagedResource implements InsuranceClaimList<InsuranceClaimRsrc> {
	private static final long serialVersionUID = 1L;

	private List<InsuranceClaimRsrc> collection = new ArrayList<InsuranceClaimRsrc>(0);

	public InsuranceClaimListRsrc() {
		collection = new ArrayList<InsuranceClaimRsrc>();
	}

	@Override
	public List<InsuranceClaimRsrc> getCollection() {
		return collection;
	}

	@Override
	public void setCollection(List<InsuranceClaimRsrc> collection) {
		this.collection = collection;
	}
}