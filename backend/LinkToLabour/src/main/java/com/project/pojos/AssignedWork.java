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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class AssignedWork {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assignedWorkId;

	@OneToOne( fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name="WorkID")
	private Work work;
	
	
	//private User user;
	
	@OneToOne(fetch = FetchType.LAZY, cascade =  { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })

	private Bidding bidding;
	
	
	private Status status;


	public AssignedWork() {
		super();
		
	}


	public AssignedWork(int assignedWorkId, Work work, Bidding bidding, Status status) {
		super();
		this.assignedWorkId = assignedWorkId;
		this.work = work;
		this.bidding = bidding;
		this.status = status;
	}


	public AssignedWork(Work work, Bidding bidding, Status status) {
		super();
		this.work = work;
		this.bidding = bidding;
		this.status = status;
	}


	public int getAssignedWorkId() {
		return assignedWorkId;
	}

	
	public void setAssignedWorkId(int assignedWorkId) {
		this.assignedWorkId = assignedWorkId;
	}

	@JsonIgnore
	public Work getWork() {
		return work;
	}

	@JsonProperty
	public void setWork(Work work) {
		this.work = work;
	}

	@JsonIgnore
	public Bidding getBidding() {
		return bidding;
	}

	@JsonProperty
	public void setBidding(Bidding bidding) {
		this.bidding = bidding;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "AssignedWork [assignedWorkId=" + assignedWorkId + ", work=" + work + ", bidding=" + bidding
				+ ", status=" + status + "]";
	}


	
	
	
	

}
