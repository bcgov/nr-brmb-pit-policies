package ca.bc.gov.mal.cirras.policies.model.v1;

import java.io.Serializable;

//
// This is not going to be a resource.
//
public class CodeOutbox extends BaseOutbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codeTableType;
	private Integer codeOutboxId;
	private String uniqueKeyString;
	private Integer uniqueKeyInteger;

 	public String getCodeTableType() {
		return codeTableType;
	}

	public void setCodeTableType(String codeTableType) {
		this.codeTableType = codeTableType;
	}
	
	public Integer getCodeOutboxId() {
		return codeOutboxId;
	}
		
	public void setCodeOutboxId(Integer codeOutboxId) {
		this.codeOutboxId = codeOutboxId;
	}

 	public String getUniqueKeyString() {
		return uniqueKeyString;
	}

	public void setUniqueKeyString(String uniqueKeyString) {
		this.uniqueKeyString = uniqueKeyString;
	}
 
 	public Integer getUniqueKeyInteger() {
		return uniqueKeyInteger;
	}

	public void setUniqueKeyInteger(Integer uniqueKeyInteger) {
		this.uniqueKeyInteger = uniqueKeyInteger;
	}
	
	@Override
	public String getSourceKey() {
		if (uniqueKeyString != null)
		{
			return codeTableType + "_" + uniqueKeyString;
		}
		else if ( uniqueKeyInteger != null)
		{
			return codeTableType + "_" + uniqueKeyInteger.toString();
		}
		else
		{
			throw new RuntimeException("Neither uniqueKeyString nor uniqueKeyInteger are set");
		}
	}
	
	@Override
	public Integer getOutboxKey() {
		return codeOutboxId;
	}
	
}
