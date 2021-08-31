package com.project.pojos;

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
public class Bidding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int biddingId;
	private String description;
	private double amount;
	private int duration;

	// foriegn key
	@OneToOne(mappedBy = "Bidding", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)

	private AssignedWork assignedWork;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "WorkId")
	private Work work;


	// foreign key
	@ManyToOne( fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "ContractorId")
	private Contractor contractor;

	@ManyToOne( fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "LabourId")
	private Labour labour;

}
