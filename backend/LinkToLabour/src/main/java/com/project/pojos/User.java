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

import lombok.Data;

@Entity
@Data
public class User {
	
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
