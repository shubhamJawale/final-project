package com.project.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity

public class Bidding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int biddingId;
	private String description;
	@NotNull
	private double amount;
	@NotNull
	private LocalDate fromDate;
	@NotNull
	private LocalDate toDate;

	@NotNull
	private Status status;

	// foriegn key

	@OneToOne(mappedBy = "bidding", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)

	private AssignedWork assignedWork;

	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "workId")
	private Work work;

	// foreign key
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	//@JoinTable(name = "Contractor_Bidding_List", joinColumns = @JoinColumn(name = "biddingId"), inverseJoinColumns = @JoinColumn(name = "contractorId"))
	private Contractor contractor;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	//@JoinTable(name = "Labour_Bidding_List", joinColumns = @JoinColumn(name = "biddingId"), inverseJoinColumns = @JoinColumn(name = "labourId"))
	private Labour labour;

	public Bidding() {
		super();
	}

	public Bidding(int biddingId, String description, @NotNull double amount, @NotNull LocalDate fromDate,
			@NotNull LocalDate toDate, Status status, AssignedWork assignedWork, Work work,
			Contractor contractorList, Labour labourList) {
		super();
		this.biddingId = biddingId;
		this.description = description;
		this.amount = amount;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.assignedWork = assignedWork;
		this.work = work;
		this.contractor = contractorList;
		this.labour = labourList;
		this.status = status;
	}

	public Bidding(int biddingId, String description, @NotNull double amount, @NotNull LocalDate fromDate,
			@NotNull LocalDate toDate, Status status) {
		super();
		this.biddingId = biddingId;
		this.description = description;
		this.amount = amount;
		this.fromDate = fromDate;
		this.status = status;
		this.toDate = toDate;
	}

	public Bidding(String description, @NotNull double amount, @NotNull LocalDate fromDate, @NotNull LocalDate toDate,
			Status status) {
		super();
		this.description = description;
		this.amount = amount;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
	}

	public int getBiddingId() {
		return biddingId;
	}

	public void setBiddingId(int biddingId) {
		this.biddingId = biddingId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	@JsonIgnore
	public Contractor getContractorList() {
		return contractor;
	}

	@JsonProperty
	public void setContractorList(Contractor contractorList) {
		this.contractor = contractorList;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
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
	public Work getWork() {
		return work;
	}
	@JsonProperty
	public void setWork(Work work) {
		this.work = work;
	}

	@JsonIgnore
	public Labour getLabour() {
		return labour;
	}

	@JsonProperty
	public void setLabour(Labour labourList) {
		this.labour = labourList;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		return "Bidding [biddingId=" + biddingId + ", description=" + description + ", amount=" + amount + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", status=" + status + ", assignedWork=" + assignedWork + ", work="
				+ work + ", contractorList=" + contractor + ", labourList=" + labour + "]";
	}

}
