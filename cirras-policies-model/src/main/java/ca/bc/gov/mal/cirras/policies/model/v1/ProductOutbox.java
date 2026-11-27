package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class ProductOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer productOutboxId;
	private Integer productId;

	public Integer getProductOutboxId() {
		return productOutboxId;
	}
		
	public void setProductOutboxId(Integer productOutboxId) {
		this.productOutboxId = productOutboxId;
	}
	
	public Integer getProductId() {
		return productId;
	}
		
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String getSourceKey() {
		return productId.toString();
	}
	
	@Override
	public Integer getOutboxKey() {
		return productOutboxId;
	}
	
}
