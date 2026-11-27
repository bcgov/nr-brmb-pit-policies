package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import org.springframework.transaction.annotation.Transactional;

import ca.bc.gov.mal.pit.common.service.api.NotFoundException;
import ca.bc.gov.mal.pit.common.service.api.ServiceException;
import ca.bc.gov.mal.pit.common.webade.authentication.WebAdeAuthentication;

public interface FailOverService {
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public boolean asyncCheckForMaster(String nodeId, Integer nodeExpiryMinutes, WebAdeAuthentication webAdeAuthentication)
			throws ServiceException, NotFoundException;

}
