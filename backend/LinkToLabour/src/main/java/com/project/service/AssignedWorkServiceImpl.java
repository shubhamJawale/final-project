package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.AssignedWorkRepo;
import com.project.pojos.AssignedWork;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Status;
import com.project.pojos.User;
@Service
public class AssignedWorkServiceImpl implements AssignedWorkService {

	@Autowired
	AssignedWorkRepo assignedWorkRepo;
	@Override
	public void addAssignedWork(AssignedWork assignedWork) {
		
		this.assignedWorkRepo.save(assignedWork);
		
	}

	/*
	 * @Override public List<AssignedWork> getAssignedWorkByUserId(User user) {
	 * 
	 * return this.assignedWorkRepo.getAssignedWorkByUser(user); }
	 * 
	 * @Override public List<AssignedWork> getAssignedWorkByContractorId(Contractor
	 * contractor) {
	 * 
	 * return this.assignedWorkRepo.getAssignedWorkByContractor(contractor); }
	 * 
	 * @Override public List<AssignedWork> getAssignedWorkByLabourId(Labour labour)
	 * {
	 * 
	 * return this.assignedWorkRepo.getAssignedWorkByLabour(labour); }
	 * 
	 * @Override public List<AssignedWork> getAssignedWorkByPendingStatusUser(Status
	 * status, User user) {
	 * 
	 * return this.assignedWorkRepo.getAssignedWorkByPendingStatusUser(status,
	 * user); }
	 * 
	 * @Override public List<AssignedWork>
	 * getAssignedWorkByPendingStatusLabourId(Status status, Labour labour) {
	 * 
	 * return this.assignedWorkRepo.getAssignedWorkByPendingStatusLabour(status,
	 * labour); }
	 * 
	 * @Override public List<AssignedWork>
	 * getAssignedWorkByPendingStatusContractorId(Status status, Contractor
	 * contractor) {
	 * 
	 * return this.getAssignedWorkByPendingStatusContractorId(status, contractor); }
	 */
}
