package com.project.dto;

import java.time.LocalDate;

public class requestContractorLabourDto {

	private int requestid;
	private String Note;
	private int userId;
	private String userName;
	private String emailId;
	private String mobileNo;
	private String Address;
	private String pincode;
	
	
	private int contractorId;
	private String LiceneNo;
	private LocalDate ExpiryDate;
	private int labourId;
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getContractorId() {
		return contractorId;
	}
	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}
	public String getLiceneNo() {
		return LiceneNo;
	}
	public void setLiceneNo(String liceneNo) {
		LiceneNo = liceneNo;
	}
	public LocalDate getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		ExpiryDate = expiryDate;
	}
	public int getLabourId() {
		return labourId;
	}
	public void setLabourId(int labourId) {
		this.labourId = labourId;
	}
	public requestContractorLabourDto() {
		super();
		
	}
	public requestContractorLabourDto(int requestid, String note, int userId, String userName, String emailId,
			String mobileNo, String address, String pincode, int contractorId, String liceneNo, LocalDate expiryDate,
			int labourId) {
		super();
		this.requestid = requestid;
		Note = note;
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		Address = address;
		this.pincode = pincode;
		this.contractorId = contractorId;
		LiceneNo = liceneNo;
		ExpiryDate = expiryDate;
		this.labourId = labourId;
	}


}
