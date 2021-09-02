package com.project.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@NotNull
	@Column(unique = true, nullable =false)
	private String emailId;
	@Column(unique = true, nullable = false)
	@NotNull
	private String mobileNo;
	private String Address;
	@NotNull
	private String pincode;
	@NotNull
	private String password;
	@NotNull
	private Role role;
	
	
	@OneToOne(mappedBy = "user" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	private Labour labour;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	private List<Work> workslist;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	private Contractor contractor;

	
	
	public User() {
		super();
		}



	public User(int userId, String userName, String emailId, String mobileNo, String address, String pincode,
			String password, Role role, Labour labour, List<Work> workslist, Contractor contractor) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.Address = address;
		this.pincode = pincode;
		this.password = password;
		this.role = role;
		this.labour = labour;
		this.workslist = workslist;
		this.contractor = contractor;
	}



	public User(int userId, String userName, String emailId, String mobileNo, String address, String pincode,
			String password, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.Address = address;
		this.pincode = pincode;
		this.password = password;
		this.role = role;
	}



	public User(String userName, String emailId, String mobileNo, String address, String pincode, String password,
			Role role) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.Address = address;
		this.pincode = pincode;
		this.password = password;
		this.role = role;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}


	@JsonIgnore
	public Labour getLabour() {
		return labour;
	}


	@JsonProperty
	public void setLabour(Labour labour) {
		this.labour = labour;
	}


	@JsonIgnore
	public List<Work> getWorkslist() {
		return workslist;
	}


	@JsonProperty
	public void setWorkslist(List<Work> workslist) {
		this.workslist = workslist;
	}


	@JsonIgnore
	public Contractor getContractor() {
		return contractor;
	}


	@JsonProperty
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", Address=" + Address + ", pincode=" + pincode + ", password=" + password + ", role=" + role
				+ ", labour=" + labour + ", workslist=" + workslist + ", contractor=" + contractor + "]";
	}

		
	


}
