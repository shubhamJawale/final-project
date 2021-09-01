package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ContractorRepo;
import com.project.pojos.Contractor;
@Service
public class ContractorServiceImpl implements ContractorService {
	@Autowired
	ContractorRepo contractorRepo;
	
	@Override
	public void addContractor(Contractor contractor) {
	this.contractorRepo.save(contractor);
	}

}
