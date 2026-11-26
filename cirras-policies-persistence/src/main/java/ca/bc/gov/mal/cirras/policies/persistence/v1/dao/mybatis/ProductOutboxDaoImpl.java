package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ProductOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.ProductOutboxMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductOutboxDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BaseDao;


@Repository
public class ProductOutboxDaoImpl extends BaseDao implements ProductOutboxDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ProductOutboxDaoImpl.class);

	@Autowired
	private ProductOutboxMapper mapper;

	
	@Override
	public List<ProductOutboxDto> select(Integer maxRecords) throws DaoException {
		logger.debug("<select");
		
		List<ProductOutboxDto> dtos = null;

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("maxRecords", maxRecords);
			
			mapper.select(parameters);
			
			dtos = (List<ProductOutboxDto>) parameters.get("dataCursor");

		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">select " + dtos);
		return dtos;
	}

    public void delete(Integer productOutboxId) throws DaoException {
		logger.debug("<delete");

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("productOutboxId", productOutboxId);
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
