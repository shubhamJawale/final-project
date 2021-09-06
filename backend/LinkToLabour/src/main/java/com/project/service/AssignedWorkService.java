package com.project.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.project.pojos.AssignedWork;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Status;
import com.project.pojos.User;

public interface AssignedWorkService {
	
	 AssignedWork getAssignedWorkByAssignedWorkId(int AssignedWorkId);
	public void addAssignedWork(AssignedWork assignedWork);
	
	public List<AssignedWork> getAllAssignedWork();
	
	public List<AssignedWork> getAssignedWorkByLabourId(int labourId);
	
	public List<AssignedWork> getAssignedWorkByUserId(int userId);
	public AssignedWork getAssignedWorkByWorkId(int WorkId);
	public List<AssignedWork> getAssignedWorkByContractorsId(int contractorId);
	
	
	/*
	 * public List<AssignedWork> getAssignedWorkByUserId(User user);
	 * 
	 * 
	 * public List<AssignedWork> getAssignedWorkByContractorId(Contractor
	 * contractor);
	 * 
	 * public List<AssignedWork> getAssignedWorkByLabourId(Labour labour);
	 * 
	 * //THIS CAN BE CHANGED
	 * 
	 * public List<AssignedWork> getAssignedWorkByPendingStatusUser(Status status,
	 * User user);
	 * 
	 * 
	 * public List<AssignedWork> getAssignedWorkByPendingStatusLabourId(Status
	 * status, Labour labour);
	 * 
	 * 
	 * public List<AssignedWork> getAssignedWorkByPendingStatusContractorId(Status
	 * status, Contractor contractor);
	 */


}
