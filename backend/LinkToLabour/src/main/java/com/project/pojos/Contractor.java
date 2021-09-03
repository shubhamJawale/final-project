package com.project.pojos;

import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
public class Contractor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contractorId;
	@NotNull
	private String LicenceNo;
	@NotNull
	private LocalDate ExpiryDate;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId")
	private User user;

	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bidding> biddingList;

	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Labour> labourList;

	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	private List<Review> reviewList;

	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<Requests> requestList;

	public Contractor() {
		super();

	}

	public Contractor(int contractorId, @NotNull String licenceNo, @NotNull LocalDate expiryDate, User user) {
		super();
		this.contractorId = contractorId;
		LicenceNo = licenceNo;
		ExpiryDate = expiryDate;
		this.user = user;
	}

	public Contractor(@NotNull String licenceNo, @NotNull LocalDate expiryDate, User user) {
		super();
		LicenceNo = licenceNo;
		ExpiryDate = expiryDate;
		this.user = user;
	}
	

	public Contractor(int contractorId, @NotNull String licenceNo, @NotNull LocalDate expiryDate, User user,
			List<Bidding> biddingList, List<Labour> labourList, List<Review> reviewList, List<Requests> requestList) {
		super();
		this.contractorId = contractorId;
		LicenceNo = licenceNo;
		ExpiryDate = expiryDate;
		this.user = user;
		this.biddingList = biddingList;
		this.labourList = labourList;
		this.reviewList = reviewList;
		this.requestList = requestList;
	}

	public Contractor(int contractorId, @NotNull String licenceNo, @NotNull LocalDate expiryDate, User user,
			List<Bidding> biddingList, List<Labour> labourList, List<Review> reviewList) {
		super();
		this.contractorId = contractorId;
		LicenceNo = licenceNo;
		ExpiryDate = expiryDate;
		this.user = user;
		this.biddingList = biddingList;
		this.labourList = labourList;
		this.reviewList = reviewList;
	}

	public int getContractorId() {
		return contractorId;
	}

	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}

	public String getLicenceNo() {
		return LicenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		LicenceNo = licenceNo;
	}

	public LocalDate getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		ExpiryDate = expiryDate;
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
	public List<Bidding> getBiddingList() {
		return biddingList;
	}

	@JsonProperty
	public void setBiddingList(List<Bidding> biddingList) {
		this.biddingList = biddingList;
	}

	@JsonIgnore
	public List<Labour> getLabourList() {
		return labourList;
	}

	@JsonProperty
	public void setLabourList(List<Labour> labourList) {
		this.labourList = labourList;
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
	public List<Requests> getRequestList() {
		return requestList;
	}
	@JsonProperty
	public void setRequestList(List<Requests> requestList) {
		this.requestList = requestList;
	}

	@Override
	public String toString() {
		return "Contractor [contractorId=" + contractorId + ", LicenceNo=" + LicenceNo + ", ExpiryDate=" + ExpiryDate
				+ ", user=" + user + ", biddingList=" + biddingList + ", labourList=" + labourList + ", reviewList="
				+ reviewList + ", requestList=" + requestList + "]";
	}

	

}
