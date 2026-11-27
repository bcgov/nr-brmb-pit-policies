package ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ContactsDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper.ContactsMapper;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BaseDao;


@Repository
public class ContactsDaoImpl extends BaseDao implements ContactsDao {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ContactsDaoImpl.class);

	@Autowired
	private ContactsMapper mapper;


	@SuppressWarnings("unchecked")
	@Override
	public ContactsDto selectByContactsId(Integer contactsId) throws DaoException {
		ContactsDto dto = null;

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("contactsId", contactsId);
			mapper.select(parameters);

			List<ContactsDto> dtos = (List<ContactsDto>) parameters.get("dataCursor");
			if ( dtos != null && !dtos.isEmpty() ) {
				dto = dtos.get(0);
			}
			
		} catch (RuntimeException e) {
			handleException(e);
		}

		logger.debug(">select " + dto);
		return dto;
	}
}
