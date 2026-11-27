package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class CropTypeOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cropTypeOutboxId;
	private Integer cropId;

	
	public Integer getCropTypeOutboxId() {
		return cropTypeOutboxId;
	}
		
	public void setCropTypeOutboxId(Integer cropTypeOutboxId) {
		this.cropTypeOutboxId = cropTypeOutboxId;
	}
	
	public Integer getCropId() {
		return cropId;
	}
		
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	@Override
	public String getSourceKey() {
		return cropId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return cropTypeOutboxId;
	}
	
}
