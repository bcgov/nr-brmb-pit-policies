package ca.bc.gov.mal.cirras.policies.service.api.v1.model.factory;

import java.util.List;
import java.util.ArrayList;

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

public class OutboxFactoryImpl implements OutboxFactory {

	@Override
	public List<ClaimOutbox> getClaimOutboxList(List<ClaimOutboxDto> dtos) throws FactoryException {

		List<ClaimOutbox> modelClaimOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelClaimOutboxes = new ArrayList<ClaimOutbox>();
			
			for ( ClaimOutboxDto dto : dtos ) { 
				ClaimOutbox model = new ClaimOutbox();
				populateModel(model, dto);
				modelClaimOutboxes.add(model);
			}
			
		}
		
		return modelClaimOutboxes;
	}

	private void populateModel(ClaimOutbox model, ClaimOutboxDto dto) {
		model.setClaimOutboxId(dto.getClaimOutboxId());
		model.setClaimId(dto.getClaimId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());		
	}

	@Override
	public List<GrowerOutbox> getGrowerOutboxList(List<GrowerOutboxDto> dtos) throws FactoryException {

		List<GrowerOutbox> modelGrowerOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelGrowerOutboxes = new ArrayList<GrowerOutbox>();
			
			for ( GrowerOutboxDto dto : dtos ) { 
				GrowerOutbox model = new GrowerOutbox();
				populateModel(model, dto);
				modelGrowerOutboxes.add(model);
			}
			
		}
		
		return modelGrowerOutboxes;
	}

	private void populateModel(GrowerOutbox model, GrowerOutboxDto dto) {
		model.setGrowerOutboxId(dto.getGrowerOutboxId());
		model.setGrowerId(dto.getGrowerId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());		
	}

	@Override
	public List<PolicyOutbox> getPolicyOutboxList(List<PolicyOutboxDto> dtos) throws FactoryException {

		List<PolicyOutbox> modelPolicyOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelPolicyOutboxes = new ArrayList<PolicyOutbox>();
			
			for ( PolicyOutboxDto dto : dtos ) { 
				PolicyOutbox model = new PolicyOutbox();
				populateModel(model, dto);
				modelPolicyOutboxes.add(model);
			}
			
		}
		
		return modelPolicyOutboxes;
	}

	private void populateModel(PolicyOutbox model, PolicyOutboxDto dto) {
		model.setPolicyOutboxId(dto.getPolicyOutboxId());
		model.setInsurancePolicyId(dto.getInsurancePolicyId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}

	@Override
	public List<GrowerContractYearOutbox> getGrowerContractYearOutboxList(List<GrowerContractYearOutboxDto> dtos) throws FactoryException {

		List<GrowerContractYearOutbox> modelGrowerContractYearOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelGrowerContractYearOutboxes = new ArrayList<GrowerContractYearOutbox>();
			
			for ( GrowerContractYearOutboxDto dto : dtos ) { 
				GrowerContractYearOutbox model = new GrowerContractYearOutbox();
				populateModel(model, dto);
				modelGrowerContractYearOutboxes.add(model);
			}
			
		}
		
		return modelGrowerContractYearOutboxes;
	}

	private void populateModel(GrowerContractYearOutbox model, GrowerContractYearOutboxDto dto) {
		model.setGrowerContractYearId(dto.getGrowerContractYearId());
		model.setGrowerContractYearOutboxId(dto.getGrowerContractYearOutboxId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}
	
	@Override
	public List<CropTypeOutbox> getCropTypeOutboxList(List<CropTypeOutboxDto> dtos) throws FactoryException {

		List<CropTypeOutbox> modelCropTypeOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelCropTypeOutboxes = new ArrayList<CropTypeOutbox>();
			
			for ( CropTypeOutboxDto dto : dtos ) { 
				CropTypeOutbox model = new CropTypeOutbox();
				populateModel(model, dto);
				modelCropTypeOutboxes.add(model);
			}
			
		}
		
		return modelCropTypeOutboxes;
	}
	
	private void populateModel(CropTypeOutbox model, CropTypeOutboxDto dto) {
		model.setCropTypeOutboxId(dto.getCropTypeOutboxId());
		model.setCropId(dto.getCropId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}
	

	@Override
	public List<CoveragePerilOutbox> getCoveragePerilOutboxList(List<CoveragePerilOutboxDto> dtos)
			throws FactoryException {

		List<CoveragePerilOutbox> modelCoveragePerilOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelCoveragePerilOutboxes = new ArrayList<CoveragePerilOutbox>();
			
			for ( CoveragePerilOutboxDto dto : dtos ) { 
				CoveragePerilOutbox model = new CoveragePerilOutbox();
				populateModel(model, dto);
				modelCoveragePerilOutboxes.add(model);
			}
			
		}
		
		return modelCoveragePerilOutboxes;
	}

	
	private void populateModel(CoveragePerilOutbox model, CoveragePerilOutboxDto dto) {
		model.setCoveragePerilOutboxId(dto.getCoveragePerilOutboxId());
		model.setCoveragePerilId(dto.getCoveragePerilId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}

	@Override
	public List<ContactsOutbox> getContactsOutboxList(List<ContactsOutboxDto> dtos)
			throws FactoryException {

		List<ContactsOutbox> modelContactsOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelContactsOutboxes = new ArrayList<ContactsOutbox>();
			
			for ( ContactsOutboxDto dto : dtos ) { 
				ContactsOutbox model = new ContactsOutbox();
				populateModel(model, dto);
				modelContactsOutboxes.add(model);
			}
			
		}
		
		return modelContactsOutboxes;
	}
	
	private void populateModel(ContactsOutbox model, ContactsOutboxDto dto) {
		model.setContactsOutboxId(dto.getContactsOutboxId());
		model.setContactsId(dto.getContactsId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}

	@Override
	public List<InsuredGrowerContactsOutbox> getInsuredGrowerContactsOutboxList(List<InsuredGrowerContactsOutboxDto> dtos)
			throws FactoryException {

		List<InsuredGrowerContactsOutbox> modelInsuredGrowerContactsOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelInsuredGrowerContactsOutboxes = new ArrayList<InsuredGrowerContactsOutbox>();
			
			for ( InsuredGrowerContactsOutboxDto dto : dtos ) { 
				InsuredGrowerContactsOutbox model = new InsuredGrowerContactsOutbox();
				populateModel(model, dto);
				modelInsuredGrowerContactsOutboxes.add(model);
			}
			
		}
		
		return modelInsuredGrowerContactsOutboxes;
	}
	
	private void populateModel(InsuredGrowerContactsOutbox model, InsuredGrowerContactsOutboxDto dto) {
		model.setInsuredGrowerContactsOutboxId(dto.getInsuredGrowerContactsOutboxId());
		model.setInsuredGrowerContactsId(dto.getInsuredGrowerContactsId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}

	@Override
	public List<EmailsOutbox> getEmailsOutboxList(List<EmailsOutboxDto> dtos)
			throws FactoryException {

		List<EmailsOutbox> modelEmailsOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelEmailsOutboxes = new ArrayList<EmailsOutbox>();
			
			for ( EmailsOutboxDto dto : dtos ) { 
				EmailsOutbox model = new EmailsOutbox();
				populateModel(model, dto);
				modelEmailsOutboxes.add(model);
			}
			
		}
		
		return modelEmailsOutboxes;
	}
	
	private void populateModel(EmailsOutbox model, EmailsOutboxDto dto) {
		model.setEmailsOutboxId(dto.getEmailsOutboxId());
		model.setEmailsId(dto.getEmailsId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}

	@Override
	public List<TelecomOutbox> getTelecomOutboxList(List<TelecomOutboxDto> dtos)
			throws FactoryException {

		List<TelecomOutbox> modelTelecomOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelTelecomOutboxes = new ArrayList<TelecomOutbox>();
			
			for ( TelecomOutboxDto dto : dtos ) { 
				TelecomOutbox model = new TelecomOutbox();
				populateModel(model, dto);
				modelTelecomOutboxes.add(model);
			}
			
		}
		
		return modelTelecomOutboxes;
	}
	
	private void populateModel(TelecomOutbox model, TelecomOutboxDto dto) {
		model.setTelecomOutboxId(dto.getTelecomOutboxId());
		model.setTelecomId(dto.getTelecomId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}
	
	@Override
	public List<CodeOutbox> getCodeOutboxList(List<CodeOutboxDto> dtos) throws FactoryException {

		List<CodeOutbox> modelCodeOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelCodeOutboxes = new ArrayList<CodeOutbox>();
			
			for ( CodeOutboxDto dto : dtos ) { 
				CodeOutbox model = new CodeOutbox();
				populateModel(model, dto);
				modelCodeOutboxes.add(model);
			}
			
		}
		
		return modelCodeOutboxes;
	}
	
	private void populateModel(CodeOutbox model, CodeOutboxDto dto) {
		model.setCodeTableType(dto.getCodeTableType());
		model.setCodeOutboxId(dto.getCodeOutboxId());
		model.setUniqueKeyString(dto.getUniqueKeyString());
		model.setUniqueKeyInteger(dto.getUniqueKeyInteger());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}

	@Override
	public List<CommodityTypeCodeOutbox> getCommodityTypeCodeOutboxList(List<CommodityTypeCodeOutboxDto> dtos)
			throws FactoryException {

		List<CommodityTypeCodeOutbox> modelCommodityTypeCodeOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelCommodityTypeCodeOutboxes = new ArrayList<CommodityTypeCodeOutbox>();
			
			for ( CommodityTypeCodeOutboxDto dto : dtos ) { 
				CommodityTypeCodeOutbox model = new CommodityTypeCodeOutbox();
				populateModel(model, dto);
				modelCommodityTypeCodeOutboxes.add(model);
			}
			
		}
		
		return modelCommodityTypeCodeOutboxes;
	}	

	
	private void populateModel(CommodityTypeCodeOutbox model, CommodityTypeCodeOutboxDto dto) {
		model.setCommodityTypeCode(dto.getCommodityTypeCode());
		model.setCommodityTypeCodeOutboxId(dto.getCommodityTypeCodeOutboxId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}

	@Override
	public List<CommodityTypeVarietyXrefOutbox> getCommodityTypeVarietyXrefOutboxList(
			List<CommodityTypeVarietyXrefOutboxDto> dtos) throws FactoryException {

		List<CommodityTypeVarietyXrefOutbox> modelCommodityTypeVarietyXrefOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelCommodityTypeVarietyXrefOutboxes = new ArrayList<CommodityTypeVarietyXrefOutbox>();
			
			for ( CommodityTypeVarietyXrefOutboxDto dto : dtos ) { 
				CommodityTypeVarietyXrefOutbox model = new CommodityTypeVarietyXrefOutbox();
				populateModel(model, dto);
				modelCommodityTypeVarietyXrefOutboxes.add(model);
			}
			
		}
		
		return modelCommodityTypeVarietyXrefOutboxes;
	}	
	
	private void populateModel(CommodityTypeVarietyXrefOutbox model, CommodityTypeVarietyXrefOutboxDto dto) {
		model.setCommodityTypeCode(dto.getCommodityTypeCode());
		model.setCommodityTypeVarietyXrefOutboxId(dto.getCommodityTypeVarietyXrefOutboxId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
		model.setVarietyId(dto.getVarietyId());
	}
	

	@Override
	public List<ProductOutbox> getProductOutboxList(List<ProductOutboxDto> dtos) throws FactoryException {

		List<ProductOutbox> modelProductOutboxes = null;
		
		if ( dtos != null && !dtos.isEmpty() ) {

			modelProductOutboxes = new ArrayList<ProductOutbox>();
			
			for ( ProductOutboxDto dto : dtos ) { 
				ProductOutbox model = new ProductOutbox();
				populateModel(model, dto);
				modelProductOutboxes.add(model);
			}
			
		}
		
		return modelProductOutboxes;
	}
	
	private void populateModel(ProductOutbox model, ProductOutboxDto dto) {
		model.setProductOutboxId(dto.getProductOutboxId());
		model.setProductId(dto.getProductId());
		model.setEntryTimestamp(dto.getEntryTimestamp());
		model.setTransactionType(dto.getTransactionType());
	}	

}
