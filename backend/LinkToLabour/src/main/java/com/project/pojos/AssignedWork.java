package com.project.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AssignedWork {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aWorkId;

	@OneToOne( fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name="WorkID")
	private Work work;
	
	
	//private User user;
	
	@OneToOne( fetch = FetchType.LAZY, cascade =  { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name="BiddingId")
	private Bidding bidding;
	private String status;

}
