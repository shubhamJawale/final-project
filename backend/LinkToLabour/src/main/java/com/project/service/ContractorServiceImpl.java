package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ContractorRepo;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
@Service
public class ContractorServiceImpl implements ContractorService {
	@Autowired
	ContractorRepo contractorRepo;
	
	@Override
	public void addContractor(Contractor contractor) {
	this.contractorRepo.save(contractor);
	}
	
	@Override
	public void deleteContractor(Contractor contractor) {
	this.contractorRepo.delete(contractor);
	}

	@Override
	public List<Contractor> getAllContractor() {
		
		return this.contractorRepo.findAll();
	}

	@Override
	public List<Contractor> getAllcContractorByPincode(String pincode) {
		
		return this.contractorRepo.getContractorBypinCode(pincode);
	}

	@Override
	public Contractor getContractorByContractorId(int contractorId) {
		
		return this.contractorRepo.getById(contractorId);
	}

	@Override
	public Contractor getContractorByUserId(int userId) {
		
		return this.contractorRepo.getContractorByUserId(userId);
	}

	

	//@Override
	/*public Contractor getContractorBylabour(Labour labour) {
	return this.contractorRepo.getContractorBylabour(labour);
	}*/

	
	}


