package ca.bc.gov.mal.cirras.policies.api.rest.v1.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import ca.bc.gov.nrs.wfhr.payroll.persistence.v1.dao.SyncOwnershipDao;
//import ca.bc.gov.nrs.wfhr.payroll.persistence.v1.dto.SyncOwnershipDto;
//import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.service.api.NotFoundException;
import ca.bc.gov.nrs.wfone.common.service.api.ServiceException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;

public class FailOverServiceImpl implements FailOverService {

	private static final Logger logger = LoggerFactory.getLogger(FailOverServiceImpl.class);

//	private SyncOwnershipDao syncOwnershipDao;

	@Override
	public boolean asyncCheckForMaster(String nodeId, Integer nodeExpiryMinutes, WebAdeAuthentication webAdeAuthentication)
			throws ServiceException, NotFoundException {
		logger.debug("<asyncCheckForMaster");
		boolean result = true;

// TODO: For now, assuming that REST service will run on a single web app, thus no need for external synchronization.
/*
		boolean result = false;

		try {
			
			SyncOwnershipDto dto = this.syncOwnershipDao.selectForUpdate();
			
			if (dto == null) {
				
				dto = new SyncOwnershipDto();
				dto.setNodeId(nodeId);
				this.syncOwnershipDao.insert(dto, nodeExpiryMinutes, webAdeAuthentication.getUserId());
				result = true;
			}
			else if(Boolean.TRUE.equals(dto.getExpiredInd())){
				dto.setNodeId(nodeId);
				this.syncOwnershipDao.update(dto.getSyncOwnershipGuid(), dto, nodeExpiryMinutes, webAdeAuthentication.getUserId());
				result = true;
			}
			else {
				
				result = dto.getNodeId().equals(nodeId);
			}
			
		} catch (DaoException e) {
			throw new ServiceException("DAO threw an exception", e);
		}
*/		
		logger.debug(">asyncCheckForMaster " + result);
		return result;
	}

//	public void setSyncOwnershipDao(SyncOwnershipDao syncOwnershipDao) {
//		this.syncOwnershipDao = syncOwnershipDao;
//	}
}
