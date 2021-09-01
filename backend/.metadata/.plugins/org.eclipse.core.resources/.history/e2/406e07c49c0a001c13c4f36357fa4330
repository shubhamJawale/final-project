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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	public User(String userName, String emailId, long mobileNo, String address, int pincode, String password,
			Role role) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		Address = address;
		this.pincode = pincode;
		this.password = password;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String emailId;
	private long mobileNo;
	private String Address;
	private int pincode;
	private String password;
	private Role role;
	
	
	@OneToOne(mappedBy = "user" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	private Labour labour;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	private List<Work> workslist;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	private Contractor contractor;
	
	
//	private Labour labour;
//	//contractor id
//	//labour id

}
