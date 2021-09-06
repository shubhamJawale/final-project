package com.project.dao;

public class LabourDto {

	
	private int labourId;
	private int contractorId;
	private int userId;
	public LabourDto() {
		super();
		
	}
	public LabourDto(int labourId, int contractorId, int userId) {
		super();
		this.labourId = labourId;
		this.contractorId = contractorId;
		this.userId = userId;
	}
	public int getLabourId() {
		return labourId;
	}
	public void setLabourId(int labourId) {
		this.labourId = labourId;
	}
	public int getContractorId() {
		return contractorId;
	}
	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "LabourDto [labourId=" + labourId + ", contractorId=" + contractorId + ", userId=" + userId + "]";
	}
	
}
