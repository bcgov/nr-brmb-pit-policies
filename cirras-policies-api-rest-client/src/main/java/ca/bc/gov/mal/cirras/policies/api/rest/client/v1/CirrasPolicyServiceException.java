package ca.bc.gov.mal.cirras.policies.api.rest.client.v1;

public class CirrasPolicyServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CirrasPolicyServiceException(String message) {
		super(message);
	}

	public CirrasPolicyServiceException(Throwable cause) {
		super(cause);
	}

	public CirrasPolicyServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
