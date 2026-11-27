package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import java.util.List;

import ca.bc.gov.mal.cirras.policies.model.v1.Product;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductList;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductDto;
import ca.bc.gov.nrs.wfone.common.persistence.dao.DaoException;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryContext;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;
import ca.bc.gov.nrs.wfone.common.webade.authentication.WebAdeAuthentication;


public interface ProductFactory {

	ProductList<? extends Product> getProductList(
			List<ProductDto> dtos,
			Integer insurancePolicyId,
			Boolean includeProductDetails, 
			Integer productId, 
			String commodityCoverageCode,
			FactoryContext context, 
			WebAdeAuthentication authentication
	) throws FactoryException, DaoException;

	Product getProduct(ProductDto dto) throws FactoryException;

}
