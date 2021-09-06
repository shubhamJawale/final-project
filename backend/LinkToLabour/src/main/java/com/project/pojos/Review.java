package com.project.pojos;

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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	@NotNull
	private String title;
	private String description;
	@NotNull
	private int rating;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH})
	
	@JoinColumn(name="ContractorId")
	private Contractor contractor;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name="LabourId")
	private Labour labour;
	
	
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="UserId" )
	private User user;




	public Review() {
		super();
	
	}




	public Review(int reviewId, @NotNull String title, String description, @NotNull int rating) {
		super();
		this.reviewId = reviewId;
		this.title = title;
		this.description = description;
		this.rating = rating;
	}




	public Review(@NotNull String title, String description, @NotNull int rating, Contractor contractor, Labour labour,
			User user) {
		super();
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.contractor = contractor;
		this.labour = labour;
		this.user = user;
	}




	public Review(@NotNull String title, String description, @NotNull int rating) {
		super();
		this.title = title;
		this.description = description;
		this.rating = rating;
	}




	public int getReviewId() {
		return reviewId;
	}




	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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




	public int getRating() {
		return rating;
	}




	public void setRating(int rating) {
		this.rating = rating;
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
	public Labour getLabour() {
		return labour;
	}



	@JsonProperty
	public void setLabour(Labour labour) {
		this.labour = labour;
	}



	@JsonIgnore
	public User getUser() {
		return user;
	}



	@JsonProperty
	public void setUser(User user) {
		this.user = user;
	}




	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", title=" + title + ", description=" + description + ", rating="
				+ rating + ", contractor=" + contractor + ", labour=" + labour + ", user=" + user + "]";
	}


	
	
	
	
	
	

}
