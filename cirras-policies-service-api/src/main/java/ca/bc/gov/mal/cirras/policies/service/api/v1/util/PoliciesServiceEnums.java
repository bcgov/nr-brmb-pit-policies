package ca.bc.gov.mal.cirras.policies.service.api.v1.util;

public class PoliciesServiceEnums {

	public enum ClaimStatusCodes{
		Open("OPEN"),
		InProgress("IN PROGRESS"),
		Pending("PENDING"),
		Approved("APPROVED");
		
		private String code;
		 
		ClaimStatusCodes(String claimStatusCode) {
	        this.code = claimStatusCode;
	    }
	 
	    public String getCode() {
	        return code;
	    }
		
	}
	
	public enum ClaimType{
		New("NEW"),
		NoDamage("NO DAMAGE"),
		ZeroClaim("ZERO CLAIM"),
		Claim("CLAIM");
		
		private String claimType;
		 
		ClaimType(String claimType) {
	        this.claimType = claimType;
	    }
	 
	    public String getClaimType() {
	        return claimType;
	    }
		
	}


}
