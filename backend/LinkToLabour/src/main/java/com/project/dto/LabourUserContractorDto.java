package com.project.dto;

import java.time.LocalDate;

public class LabourUserContractorDto {
	private int userId;
	private String userName;
	private String emailId;
	private String mobileNo;
	private String Address;
	private String pincode;
	private String password;

	private int labourId;

	private int contractorId;
	private String LiceneNo;
	private LocalDate ExpiryDate;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "LabourUserContractorDto [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + ", Address=" + Address + ", pincode=" + pincode + ", password=" + password
				+ ", labourId=" + labourId + ", contractorId=" + contractorId + ", LiceneNo=" + LiceneNo
				+ ", ExpiryDate=" + ExpiryDate + "]";
	}
	public LabourUserContractorDto() {
		super();
		
	}
	public LabourUserContractorDto(int userId, String userName, String emailId, String mobileNo, String address,
			String pincode, String password, int labourId, int contractorId, String liceneNo, LocalDate expiryDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		Address = address;
		this.pincode = pincode;
		this.password = password;
		this.labourId = labourId;
		this.contractorId = contractorId;
		LiceneNo = liceneNo;
		ExpiryDate = expiryDate;
	}
	

}
