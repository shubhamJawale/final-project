package com.project.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int WorkId;
	private String title;
	private String description;
	private Date startingDate;
	private int expectedDuration;
	private double expectedAmount;
	private String status;
	// foreign key
	
	// user 
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name="UserId")
	private User user;
	
	@OneToOne(mappedBy = "work", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	
	private AssignedWork assignedWork;
	
	
	@OneToMany(mappedBy = "work", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bidding> biddingList;

}
