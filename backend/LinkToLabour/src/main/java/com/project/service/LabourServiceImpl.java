package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.LabourRepo;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
@Service
public class LabourServiceImpl implements LabourService {
@Autowired
LabourRepo labourRepo;
	
	
	@Override
	public void addLabour(Labour labour) {
		this.labourRepo.save(labour);
	}


	@Override
	public List<Labour> getLabourBycontractorId(Contractor contractor) {
		//Contractor contractor=this.contractorRepo.getById(contractor);
		return this.labourRepo.getLabourBycontractorId(contractor);
	}


	@Override
	public void deleteLabour(Labour labour) {
		this.labourRepo.delete(labour);
		
	}

}
