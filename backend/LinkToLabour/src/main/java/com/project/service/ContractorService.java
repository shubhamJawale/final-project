package com.project.service;

import com.project.pojos.Contractor;
import com.project.pojos.Labour;

public interface ContractorService {

	public void addContractor(Contractor contractor);
	
	/* public Contractor getContractorBylabour(Labour labour); */
	
	public void deleteContractor(Contractor contractor);
}
