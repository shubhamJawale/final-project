package com.project.service;

import java.util.List;

import com.project.pojos.Requests;

public interface RequestService {

	
	public List<Requests> getAllRequests();
	public List<Requests> getAllRequestsByContractorId(int contractorId);
	public List<Requests> getAllRequestsByLabourId(int LabourId);
	
	public Requests getRequestByRequestId(int RequestId);
	
	public void addRequest(Requests requests);
	
	
	public void deleterequestfromtable(int id);
	
}
