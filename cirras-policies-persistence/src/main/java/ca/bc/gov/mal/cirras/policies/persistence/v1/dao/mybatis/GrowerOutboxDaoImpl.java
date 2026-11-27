package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.GrowerOutboxMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerOutboxDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class GrowerOutboxDaoImpl extends BaseDao implements GrowerOutboxDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(GrowerOutboxDaoImpl.class);

	@Autowired
	private GrowerOutboxMapper mapper;

	
	@Override
	public List<GrowerOutboxDto> select(Integer maxRecords) throws DaoException {
		logger.debug("<select");
		
		List<GrowerOutboxDto> dtos = null;

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("maxRecords", maxRecords);
			
			mapper.select(parameters);
			
			dtos = (List<GrowerOutboxDto>) parameters.get("dataCursor");

		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">select " + dtos);
		return dtos;
	}

    public void delete(Integer growerOutboxId) throws DaoException {
		logger.debug("<delete");

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("growerOutboxId", growerOutboxId);
			int count = this.mapper.delete(parameters);

			if(count==0) {
				throw new DaoException("Record not deleted: "+count);
			}
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">delete");
    }
		
}
