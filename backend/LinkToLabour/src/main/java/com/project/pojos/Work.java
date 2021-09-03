package com.project.pojos;

import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int WorkId;
	private String title;
	@NotNull
	private String description;
	@NotNull
	private LocalDate fromDate;
	@NotNull
	private LocalDate toDate;
	@NotNull
	private String pinCode;
	@NotNull
	private double expectedAmount;
	@NotNull
	private WorkType workType;
	@NotNull
	private Status status;
	// foreign key
	
	// user 
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name="UserId")
	private User user;
	
	@OneToOne(mappedBy = "work", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	
	private AssignedWork assignedWork;
	
	
	@OneToMany(mappedBy ="work", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bidding> biddingList;


	public Work() {
		super();
		
	}


	public Work(int workId, String title, String description, LocalDate fromDate, LocalDate toDate,
			String pinCode	,double expectedAmount, WorkType workType,Status status) {
		super();
		WorkId = workId;
		this.title = title;
		this.description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.pinCode=pinCode;
		this.expectedAmount = expectedAmount;
		this.workType = workType;
		this.status = status;
	}


	public Work(String title, String description, LocalDate fromDate, LocalDate toDate,String pinCode, double expectedAmount,
			WorkType workType, Status status) {
		super();
		this.title = title;
		this.description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.pinCode=pinCode;
		this.expectedAmount = expectedAmount;
		this.workType = workType;
		this.status = status;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	public int getWorkId() {
		return WorkId;
	}


	public void setWorkId(int workId) {
		WorkId = workId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getFromDate() {
		return fromDate;
	}


	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}


	public LocalDate getToDate() {
		return toDate;
	}


	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}


	public double getExpectedAmount() {
		return expectedAmount;
	}


	public void setExpectedAmount(double expectedAmount) {
		this.expectedAmount = expectedAmount;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}
	

	public WorkType getWorkType() {
		return workType;
	}


	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}


	@JsonProperty
	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	public AssignedWork getAssignedWork() {
		return assignedWork;
	}

	@JsonProperty
	public void setAssignedWork(AssignedWork assignedWork) {
		this.assignedWork = assignedWork;
	}

	@JsonIgnore
	public List<Bidding> getBiddingList() {
		return biddingList;
	}

	@JsonProperty
	public void setBiddingList(List<Bidding> biddingList) {
		this.biddingList = biddingList;
	}


	@Override
	public String toString() {
		return "Work [WorkId=" + WorkId + ", title=" + title + ", description=" + description + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", pinCode=" + pinCode + ", expectedAmount=" + expectedAmount + ", workType="
				+ workType + ", status=" + status + ", user=" + user + ", assignedWork=" + assignedWork
				+ ", biddingList=" + biddingList + "]";
	}






	
	
}
