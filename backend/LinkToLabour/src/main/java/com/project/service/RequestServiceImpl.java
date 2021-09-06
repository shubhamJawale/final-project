package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.RequestRepo;
import com.project.pojos.Requests;
@Service
public class RequestServiceImpl implements RequestService {
@Autowired 
RequestRepo requestRepo;
	@Override
	public List<Requests> getAllRequests() {
		
		return this.requestRepo.findAll() ;
	}

	@Override
	public List<Requests> getAllRequestsByContractorId(int contractorId) {
		
		return this.requestRepo.getAllRequestsByContractorId(contractorId);
	}

	@Override
	public List<Requests> getAllRequestsByLabourId(int LabourId) {
		
		return this.requestRepo.getAllRequestsByLabourId(LabourId);
	}

	@Override
	public Requests getRequestByRequestId(int RequestId) {
	
		return this.requestRepo.getById(RequestId);
	}

	@Override
	public void addRequest(Requests requests) {
		this.requestRepo.save(requests);

	}

	@Override
	public void deleterequestfromtable(int id) {
		this.requestRepo.deleterequestwithrequestid(id);
		
	}

	



}
