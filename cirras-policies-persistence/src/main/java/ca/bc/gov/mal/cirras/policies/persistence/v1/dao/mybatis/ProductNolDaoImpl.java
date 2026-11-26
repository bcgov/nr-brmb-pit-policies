package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ProductNolDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.ProductNolMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductNolDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BaseDao;


@Repository
public class ProductNolDaoImpl extends BaseDao implements ProductNolDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ProductNolDaoImpl.class);

	@Autowired
	private ProductNolMapper mapper;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductNolDto> select(Integer id) throws DaoException {
		List<ProductNolDto> dtos = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("id", id); // policy id
			mapper.select(parameters);
			
			dtos = (List<ProductNolDto>) parameters.get("dataCursor");
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">select " + dtos);
		return dtos;
	}
}
