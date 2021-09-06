package com.project.service;

import java.util.List;

import com.project.pojos.Contractor;
import com.project.pojos.Labour;

public interface ContractorService {

	public void addContractor(Contractor contractor);
	
	public List<Contractor> getAllContractor();
	
	public List<Contractor> getAllcContractorByPincode(String pincode);
	
	public void deleteContractor(Contractor contractor);
	
	public Contractor getContractorByContractorId(int contractorId);
	
	public Contractor getContractorByUserId(int userId);

	/* public Contractor getContractorBylabour(Labour labour); */
}
