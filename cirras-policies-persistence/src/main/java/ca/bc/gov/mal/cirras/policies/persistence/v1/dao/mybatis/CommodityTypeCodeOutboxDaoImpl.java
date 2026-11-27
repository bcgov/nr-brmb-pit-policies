package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityTypeCodeOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.CommodityTypeCodeOutboxMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeOutboxDto;
import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.pit.common.persistence.dao.mybatis.BaseDao;


@Repository
public class CommodityTypeCodeOutboxDaoImpl extends BaseDao implements CommodityTypeCodeOutboxDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CommodityTypeCodeOutboxDaoImpl.class);

	@Autowired
	private CommodityTypeCodeOutboxMapper mapper;

	
	@Override
	public List<CommodityTypeCodeOutboxDto> select(Integer maxRecords) throws DaoException {
		logger.debug("<select");
		
		List<CommodityTypeCodeOutboxDto> dtos = null;

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("maxRecords", maxRecords);
			
			mapper.select(parameters);
			
			dtos = (List<CommodityTypeCodeOutboxDto>) parameters.get("dataCursor");

		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">select " + dtos);
		return dtos;
	}

	@Override
    public void delete(Integer commodityTypeCodeOutboxId) throws DaoException {
		logger.debug("<delete");

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("commodityTypeCodeOutboxId", commodityTypeCodeOutboxId);
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
