package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class CoveragePerilOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer coveragePerilOutboxId;
	private Integer coveragePerilId;

	
	public Integer getCoveragePerilOutboxId() {
		return coveragePerilOutboxId;
	}
		
	public void setCoveragePerilOutboxId(Integer coveragePerilOutboxId) {
		this.coveragePerilOutboxId = coveragePerilOutboxId;
	}
	
	public Integer getCoveragePerilId() {
		return coveragePerilId;
	}
		
	public void setCoveragePerilId(Integer coveragePerilId) {
		this.coveragePerilId = coveragePerilId;
	}

	@Override
	public String getSourceKey() {
		return coveragePerilId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return coveragePerilOutboxId;
	}
	
}
