package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;


import java.io.Serializable;
import java.util.List;

import ca.bc.gov.mal.pit.common.persistence.dao.DaoException;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductNolDto;


public interface ProductNolDao extends Serializable {
    List<ProductNolDto> select(Integer iplId) throws DaoException;
}
