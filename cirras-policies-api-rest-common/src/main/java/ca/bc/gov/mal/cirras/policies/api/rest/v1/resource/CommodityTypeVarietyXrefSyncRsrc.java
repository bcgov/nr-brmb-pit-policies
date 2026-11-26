package ca.bc.gov.mal.cirras.policies.api.rest.v1.resource;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import ca.bc.gov.mal.cirras.policies.api.rest.v1.resource.types.ResourceTypes;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeVarietyXrefSync;
import ca.bc.gov.mal.pit.common.rest.resource.BaseResource;

@XmlRootElement(namespace = ResourceTypes.NAMESPACE, name = ResourceTypes.COMMODITY_TYPE_VARIETY_XREF_SYNC_NAME)
@XmlSeeAlso({ CommodityTypeVarietyXrefSyncRsrc.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public class CommodityTypeVarietyXrefSyncRsrc extends BaseResource implements CommodityTypeVarietyXrefSync {

	private static final long serialVersionUID = 1L;

	private String commodityTypeCode;
	private Integer varietyId;

	public String getCommodityTypeCode() {
		return commodityTypeCode;
	}
	public void setCommodityTypeCode(String commodityTypeCode) {
		this.commodityTypeCode = commodityTypeCode;
	}

	public Integer getVarietyId() {
		return varietyId;
	}
	public void setVarietyId(Integer varietyId) {
		this.varietyId = varietyId;
	}

}
