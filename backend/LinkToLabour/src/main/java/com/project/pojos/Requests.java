package com.project.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
public class Requests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestid;
	private String Note;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Labour labour; // Requst<=manytoone<=labour
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Contractor contractor; // Request<=ManytoOne<=Contractor;

	public Requests() {
		super();
	}

	public Requests(int requestid, String note, Labour labour, Contractor contractor) {
		super();
		this.requestid = requestid;
		Note = note;
		this.labour = labour;
		contractor = contractor;
	}

	public Requests(String note, Labour labour, Contractor contractor) {
		super();
		Note = note;
		this.labour = labour;
		contractor = contractor;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
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
	public Contractor getContractor() {
		return contractor;
	}
	@JsonProperty
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	@Override
	public String toString() {
		return "Request [requestid=" + requestid + ", Note=" + Note + ", labour=" + labour + ", Contractor="
				+ contractor + "]";
	}

}
