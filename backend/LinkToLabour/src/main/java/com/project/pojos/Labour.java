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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Labour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int labourId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="UserId")
	private User user;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name="ContractorId")
	private Contractor contractor;

	@OneToMany(mappedBy = "labour", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(nullable = true)
	private List<Review> reviewList;

	
	@OneToMany(mappedBy = "labour", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bidding> biddingList;
	
	@OneToMany(mappedBy = "labour", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Requests> requestList;

	public Labour() {
		super();
		
	}


	public Labour(int labourId, User user, Contractor contractor) {
		super();
		this.labourId = labourId;
		this.user = user;
		this.contractor = contractor;
	}


	public Labour(int labourId, User user, Contractor contractor, List<Review> reviewList, List<Bidding> biddingList,
			List<Requests> requestList) {
		super();
		this.labourId = labourId;
		this.user = user;
		this.contractor = contractor;
		this.reviewList = reviewList;
		this.biddingList = biddingList;
		this.requestList = requestList;
	}


	public Labour(int labourId, Contractor contractor) {
		super();
		this.labourId = labourId;
		this.contractor = contractor;
	}


	public int getLabourId() {
		return labourId;
	}


	public void setLabourId(int labourId) {
		this.labourId = labourId;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	@JsonProperty
	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	public Contractor getContractor() {
		return contractor;
	}

	@JsonProperty
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	@JsonIgnore
	public List<Review> getReviewList() {
		return reviewList;
	}

	@JsonProperty
	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	@JsonIgnore
	public List<Bidding> getBiddingList() {
		return biddingList;
	}

	@JsonProperty
	public void setBiddingList(List<Bidding> biddingList) {
		this.biddingList = biddingList;
	}

	@JsonIgnore
	public List<Requests> getRequestList() {
		return requestList;
	}

	@JsonProperty
	public void setRequestList(List<Requests> requestList) {
		this.requestList = requestList;
	}


	@Override
	public String toString() {
		return "Labour [labourId=" + labourId + ", user=" + user + ", contractor=" + contractor + ", reviewList="
				+ reviewList + ", biddingList=" + biddingList + ", requestList=" + requestList + "]";
	}







	
	
	
	
	
	
	
}
