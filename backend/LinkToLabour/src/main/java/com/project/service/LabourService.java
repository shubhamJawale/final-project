package com.project.service;

import java.util.List;

import com.project.pojos.Contractor;
import com.project.pojos.Labour;

public interface LabourService {
	
		public void addLabour(Labour labour);
		
		/* public List<Labour> getLabourBycontractorId(Contractor contractor); */
		
		public List<Labour> getAllLaboursByPincode(String pincode);
		
		public void deleteLabour(Labour labour);
		
		public Labour getLabourById(int labourId);
		public List<Labour> getLabourByContractorId(int contractorId);
		public Labour getLbaourByUserId(int userId);
}
