package com.project.dto;

import java.time.LocalDate;

import com.project.pojos.Status;
import com.project.pojos.WorkType;

public class AssignedWorkDto {
	private int uid;
	private String userName;
	private int WorkId;
	private String title;
	private String description;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String pinCode;
	private Double expectedAmount;
	private WorkType workType;
	private Status Wstatus;
	private int assignedWorkId;

	private int biddingId;
	private Status Astatus;

	private	String bdescription;
	private	double bamount;
	private	LocalDate bfromDate;
	private	LocalDate btoDate;
	private	int contractorId;
	private	int labourId;

	public AssignedWorkDto() {
		super();

	}

	public AssignedWorkDto(int workId, String title, String description, LocalDate fromDate, LocalDate toDate,
			String pinCode, Double expectedAmount, WorkType workType, Status wstatus, int assignedWorkId, int biddingId,
			Status astatus) {
		super();
		WorkId = workId;
		this.title = title;
		this.description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.pinCode = pinCode;
		this.expectedAmount = expectedAmount;
		this.workType = workType;
		Wstatus = wstatus;
		this.assignedWorkId = assignedWorkId;
		this.biddingId = biddingId;
		Astatus = astatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getWorkId() {
		return WorkId;
	}

	public void setWorkId(int workId) {
		WorkId = workId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Double getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(Double expectedAmount) {
		this.expectedAmount = expectedAmount;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public Status getWstatus() {
		return Wstatus;
	}

	public void setWstatus(Status wstatus) {
		Wstatus = wstatus;
	}

	public int getAssignedWorkId() {
		return assignedWorkId;
	}

	public void setAssignedWorkId(int assignedWorkId) {
		this.assignedWorkId = assignedWorkId;
	}

	public int getBiddingId() {
		return biddingId;
	}

	public void setBiddingId(int biddingId) {
		this.biddingId = biddingId;
	}

	public Status getAstatus() {
		return Astatus;
	}

	public void setAstatus(Status astatus) {
		Astatus = astatus;
	}

	public String getBdescription() {
		return bdescription;
	}

	public void setBdescription(String bdescription) {
		this.bdescription = bdescription;
	}

	public double getBamount() {
		return bamount;
	}

	public void setBamount(double bamount) {
		this.bamount = bamount;
	}

	public LocalDate getBfromDate() {
		return bfromDate;
	}

	public void setBfromDate(LocalDate bfromDate) {
		this.bfromDate = bfromDate;
	}

	public LocalDate getBtoDate() {
		return btoDate;
	}

	public void setBtoDate(LocalDate btoDate) {
		this.btoDate = btoDate;
	}

	public int getContractorId() {
		return contractorId;
	}

	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}

	public int getLabourId() {
		return labourId;
	}

	public void setLabourId(int labourId) {
		this.labourId = labourId;
	}

	@Override
	public String toString() {
		return "AssignedWorkDto [WorkId=" + WorkId + ", title=" + title + ", description=" + description + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", pinCode=" + pinCode + ", expectedAmount=" + expectedAmount
				+ ", workType=" + workType + ", Wstatus=" + Wstatus + ", assignedWorkId=" + assignedWorkId
				+ ", biddingId=" + biddingId + ", Astatus=" + Astatus + "]";
	}

}
