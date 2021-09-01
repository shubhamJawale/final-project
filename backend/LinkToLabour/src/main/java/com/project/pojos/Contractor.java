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

	@ManyToMany(mappedBy = "contractorList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bidding> biddingList;

	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Labour> labourList;

	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	private List<Review> reviewList;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Bidding> getBiddingList() {
		return biddingList;
	}

	public void setBiddingList(List<Bidding> biddingList) {
		this.biddingList = biddingList;
	}

	public List<Labour> getLabourList() {
		return labourList;
	}

	public void setLabourList(List<Labour> labourList) {
		this.labourList = labourList;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	@Override
	public String toString() {
		return "Contractor [contractorId=" + contractorId + ", LicenceNo=" + LicenceNo + ", ExpiryDate=" + ExpiryDate
				+ ", user=" + user + ", biddingList=" + biddingList + ", labourList=" + labourList + ", reviewList="
				+ reviewList + "]";
	}
	
	
	

}
