package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;
import java.util.List;

public interface InsuranceClaimList<E extends InsuranceClaim> extends Serializable {
	public List<E> getCollection();
	public void setCollection(List<E> collection);
}