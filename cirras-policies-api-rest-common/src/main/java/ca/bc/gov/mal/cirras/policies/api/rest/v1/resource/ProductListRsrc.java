package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.pit.common.rest.resource.PagedResource;
import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductList;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.PRODUCT_LIST_NAME)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({ @Type(value = ProductListRsrc.class, name = ResourceTypes.PRODUCT_LIST) })
public class ProductListRsrc extends PagedResource implements ProductList<ProductRsrc> {
	private static final long serialVersionUID = 1L;

	private List<ProductRsrc> collection = new ArrayList<ProductRsrc>(0);

	public ProductListRsrc() {
		collection = new ArrayList<ProductRsrc>();
	}

	@Override
	public List<ProductRsrc> getCollection() {
		return collection;
	}

	@Override
	public void setCollection(List<ProductRsrc> collection) {
		this.collection = collection;
	}
}