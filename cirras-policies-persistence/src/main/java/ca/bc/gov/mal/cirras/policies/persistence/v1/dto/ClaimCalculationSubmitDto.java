package ca.bc.gov.mal.cirras.policies.persistence.v1.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.mal.pit.common.persistence.dto.BaseDto;
import ca.bc.gov.mal.pit.common.persistence.utils.DtoUtils;

public class ClaimCalculationSubmitDto extends BaseDto<ClaimCalculationSubmitDto> {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ClaimCalculationSubmitDto.class);
	
	private Integer colId;
	private String claimStatus;
	private String claimType;
	private Double damageEstimate;
	private String sysRecordGuid;
	private String updateUserid;
	private Integer iplId;
	private String iplSysRecordGuid;
	private Integer usrUsrIdRecommendedBy;
	private Integer usrUsrIdApprovedBy;
	private Date claimReceived;
	private Date approvedDate;
	private Date recommendedDate;
	private Integer monitoredBy;
	private Date monitoredDate;
	private String growerNotice;
	private String overwriteSavedNotice;
	private Double claimAmount;
	private Double holdbackAmount;
	private String userId;
	private Integer usrId;
	private Double totalCoverage;
	private Boolean hasChequeReqInd;

	public ClaimCalculationSubmitDto() {
	}

	
	public ClaimCalculationSubmitDto(ClaimCalculationSubmitDto dto) {
		this.colId = dto.colId;
		this.claimStatus = dto.claimStatus;
		this.claimType = dto.claimType;
		this.damageEstimate = dto.damageEstimate;
		this.sysRecordGuid = dto.sysRecordGuid;
		this.updateUserid = dto.updateUserid;
		this.iplId = dto.iplId;
		this.iplSysRecordGuid = dto.iplSysRecordGuid;
		this.usrUsrIdRecommendedBy = dto.usrUsrIdRecommendedBy;
		this.usrUsrIdApprovedBy = dto.usrUsrIdApprovedBy;
		this.claimReceived = dto.claimReceived;
		this.approvedDate = dto.approvedDate;
		this.recommendedDate = dto.recommendedDate;
		this.monitoredBy = dto.monitoredBy;
		this.monitoredDate = dto.monitoredDate;
		this.growerNotice = dto.growerNotice;
		this.overwriteSavedNotice = dto.overwriteSavedNotice;
		this.claimAmount = dto.claimAmount;
		this.holdbackAmount = dto.holdbackAmount;
		this.userId = dto.userId;
		this.usrId = dto.usrId;
		this.totalCoverage = dto.totalCoverage;
		this.hasChequeReqInd = dto.hasChequeReqInd;
	}	
	

	@Override
	public boolean equalsBK(ClaimCalculationSubmitDto other) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean equalsAll(ClaimCalculationSubmitDto other) {
		boolean result = false;
		
		if(other!=null) {
			result = true;
			DtoUtils dtoUtils = new DtoUtils(getLogger());
			result = result&&dtoUtils.equals("colId", colId, other.colId);
			result = result&&dtoUtils.equals("claimStatus", claimStatus, other.claimStatus);
			result = result&&dtoUtils.equals("claimType", claimType, other.claimType);
			result = result&&dtoUtils.equals("damageEstimate", damageEstimate, other.damageEstimate, 2);
			result = result&&dtoUtils.equals("sysRecordGuid", sysRecordGuid, other.sysRecordGuid);
			result = result&&dtoUtils.equals("updateUserid", updateUserid, other.updateUserid);
			result = result&&dtoUtils.equals("iplId", iplId, other.iplId);
			result = result&&dtoUtils.equals("iplSysRecordGuid", iplSysRecordGuid, other.iplSysRecordGuid);
			result = result&&dtoUtils.equals("usrUsrIdRecommendedBy", usrUsrIdRecommendedBy, other.usrUsrIdRecommendedBy);
			result = result&&dtoUtils.equals("usrUsrIdApprovedBy", usrUsrIdApprovedBy, other.usrUsrIdApprovedBy);
			result = result&&dtoUtils.equals("claimReceived", claimReceived, other.claimReceived);
			result = result&&dtoUtils.equals("approvedDate", approvedDate, other.approvedDate);
			result = result&&dtoUtils.equals("recommendedDate", recommendedDate, other.recommendedDate);
			result = result&&dtoUtils.equals("monitoredBy", monitoredBy, other.monitoredBy);
			result = result&&dtoUtils.equals("monitoredDate", monitoredDate, other.monitoredDate);
			result = result&&dtoUtils.equals("growerNotice", growerNotice, other.growerNotice);
			result = result&&dtoUtils.equals("overwriteSavedNotice", overwriteSavedNotice, other.overwriteSavedNotice);
			result = result&&dtoUtils.equals("claimAmount", claimAmount, other.claimAmount, 2);
			result = result&&dtoUtils.equals("holdbackAmount", holdbackAmount, other.holdbackAmount, 2);
			result = result&&dtoUtils.equals("userId", userId, other.userId);
			result = result&&dtoUtils.equals("usrId", usrId, other.usrId);
			result = result&&dtoUtils.equals("totalCoverage", totalCoverage, other.totalCoverage, 2);
		}
		
		return result;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public ClaimCalculationSubmitDto copy() {
		return new ClaimCalculationSubmitDto(this);
	}

	
 	public Integer getColId() {
		return colId;
	}

	public void setColId(Integer colId) {
		this.colId = colId;
	}
 
 	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
 
 	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
 
 	public Double getDamageEstimate() {
		return damageEstimate;
	}

	public void setDamageEstimate(Double damageEstimate) {
		this.damageEstimate = damageEstimate;
	}
 
 	public String getSysRecordGuid() {
		return sysRecordGuid;
	}

	public void setSysRecordGuid(String sysRecordGuid) {
		this.sysRecordGuid = sysRecordGuid;
	}
 
 	public String getUpdateUserid() {
		return updateUserid;
	}

	public void setUpdateUserid(String updateUserid) {
		this.updateUserid = updateUserid;
	}
 
 	public Integer getIplId() {
		return iplId;
	}

	public void setIplId(Integer iplId) {
		this.iplId = iplId;
	}
 
 	public String getIplSysRecordGuid() {
		return iplSysRecordGuid;
	}

	public void setIplSysRecordGuid(String iplSysRecordGuid) {
		this.iplSysRecordGuid = iplSysRecordGuid;
	}
 
 	public Integer getUsrUsrIdRecommendedBy() {
		return usrUsrIdRecommendedBy;
	}

	public void setUsrUsrIdRecommendedBy(Integer usrUsrIdRecommendedBy) {
		this.usrUsrIdRecommendedBy = usrUsrIdRecommendedBy;
	}
 
 	public Integer getUsrUsrIdApprovedBy() {
		return usrUsrIdApprovedBy;
	}

	public void setUsrUsrIdApprovedBy(Integer usrUsrIdApprovedBy) {
		this.usrUsrIdApprovedBy = usrUsrIdApprovedBy;
	}
 
 	public Date getClaimReceived() {
		return claimReceived;
	}

	public void setClaimReceived(Date claimReceived) {
		this.claimReceived = claimReceived;
	}
 
 	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
 
 	public Date getRecommendedDate() {
		return recommendedDate;
	}

	public void setRecommendedDate(Date recommendedDate) {
		this.recommendedDate = recommendedDate;
	}
 
 	public Integer getMonitoredBy() {
		return monitoredBy;
	}

	public void setMonitoredBy(Integer monitoredBy) {
		this.monitoredBy = monitoredBy;
	}
 
 	public Date getMonitoredDate() {
		return monitoredDate;
	}

	public void setMonitoredDate(Date monitoredDate) {
		this.monitoredDate = monitoredDate;
	}
 
 	public String getGrowerNotice() {
		return growerNotice;
	}

	public void setGrowerNotice(String growerNotice) {
		this.growerNotice = growerNotice;
	}
 
 	public String getOverwriteSavedNotice() {
		return overwriteSavedNotice;
	}

	public void setOverwriteSavedNotice(String overwriteSavedNotice) {
		this.overwriteSavedNotice = overwriteSavedNotice;
	}
 
 	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}
 
 	public Double getHoldbackAmount() {
		return holdbackAmount;
	}

	public void setHoldbackAmount(Double holdbackAmount) {
		this.holdbackAmount = holdbackAmount;
	}
 
 	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
 
 	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}
 
	public Double getTotalCoverage() {
		return totalCoverage;
	}
	
	public void setTotalCoverage(Double totalCoverage) {
		this.totalCoverage = totalCoverage;
	}

	public Boolean getHasChequeReqInd() {
		return hasChequeReqInd;
	}
	
	public void setHasChequeReqInd(Boolean hasChequeReqInd) {
		this.hasChequeReqInd = hasChequeReqInd;
	}
}
