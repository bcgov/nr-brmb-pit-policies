package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import java.util.List;

import ca.bc.gov.mal.cirras.policies.model.v1.GrowerContractYearOutbox;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerContractYearOutboxDto;
import ca.bc.gov.mal.cirras.policies.model.v1.ClaimOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CodeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeCodeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CommodityTypeVarietyXrefOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.ContactsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CoveragePerilOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.CropTypeOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.EmailsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.GrowerOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.InsuredGrowerContactsOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.PolicyOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.ProductOutbox;
import ca.bc.gov.mal.cirras.policies.model.v1.TelecomOutbox;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CodeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeCodeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CommodityTypeVarietyXrefOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ContactsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CoveragePerilOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.CropTypeOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.EmailsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.GrowerOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.InsuredGrowerContactsOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.PolicyOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ProductOutboxDto;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.TelecomOutboxDto;
import ca.bc.gov.nrs.wfone.common.service.api.model.factory.FactoryException;

public interface OutboxFactory {
	
	List<ClaimOutbox> getClaimOutboxList(List<ClaimOutboxDto> dtos) throws FactoryException;

	List<GrowerOutbox> getGrowerOutboxList(List<GrowerOutboxDto> dtos) throws FactoryException;

	List<PolicyOutbox> getPolicyOutboxList(List<PolicyOutboxDto> dtos) throws FactoryException;

	List<GrowerContractYearOutbox> getGrowerContractYearOutboxList(List<GrowerContractYearOutboxDto> dtos) throws FactoryException;
	
	List<CropTypeOutbox> getCropTypeOutboxList(List<CropTypeOutboxDto> dtos) throws FactoryException;

	List<CoveragePerilOutbox> getCoveragePerilOutboxList(List<CoveragePerilOutboxDto> dtos) throws FactoryException;

	List<ContactsOutbox> getContactsOutboxList(List<ContactsOutboxDto> dtos) throws FactoryException;

	List<InsuredGrowerContactsOutbox> getInsuredGrowerContactsOutboxList(List<InsuredGrowerContactsOutboxDto> dtos) throws FactoryException;

	List<EmailsOutbox> getEmailsOutboxList(List<EmailsOutboxDto> dtos) throws FactoryException;

	List<TelecomOutbox> getTelecomOutboxList(List<TelecomOutboxDto> dtos) throws FactoryException;

	List<CodeOutbox> getCodeOutboxList(List<CodeOutboxDto> dtos) throws FactoryException;

	List<CommodityTypeCodeOutbox> getCommodityTypeCodeOutboxList(List<CommodityTypeCodeOutboxDto> dtos) throws FactoryException;

	List<CommodityTypeVarietyXrefOutbox> getCommodityTypeVarietyXrefOutboxList(List<CommodityTypeVarietyXrefOutboxDto> dtos) throws FactoryException;

	List<ProductOutbox> getProductOutboxList(List<ProductOutboxDto> dtos) throws FactoryException;

}
