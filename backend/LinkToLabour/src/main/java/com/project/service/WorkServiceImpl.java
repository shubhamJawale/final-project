package com.project.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserRepo;
import com.project.dao.WorkRepo;
import com.project.pojos.Status;
import com.project.pojos.User;
import com.project.pojos.Work;
import com.project.pojos.WorkType;



@Service
public class WorkServiceImpl implements WorkService {
	@Autowired
	WorkRepo workRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public void addwork(Work work) {
		this.workRepo.save(work);

	}

	@Override
	public List<Work> getAllWork() {

		return this.workRepo.findAll();
	}

	@Override
	public List<Work> getworkByUserID(int userid) {
	User user =	this.userRepo.getById(userid);
		return this.workRepo.getWorkByUserId(user);
	}

	@Override
	public void deleteWork(Work work) {
		this.workRepo.delete(work);

	}

	@Override
	public List<Work> getAllWorkByWorkType(LocalDate date, String pincode, WorkType workType, Status status) {
		
		return this.workRepo.getAllWorkByWorkType(date, pincode, workType,status);
	}

	@Override
	public List<Work> getAllWorkByStatus(Status status) {
		
		return this.workRepo.getAllWorkByStatus(status);
	}

	@Override
	public List<Work> getAllWorkByExceeding(LocalDate date, String pincode) {
		
		return this.workRepo.getAllWorkByExceedingDate(date, pincode);
	}

	@Override
	public Work getWorkByWorkId(int workId) {
		
		return this.workRepo.getById(workId);
	}

	@Override
	public List<Work> getWorkByPincode(String pincode) {
		
		return this.workRepo.getWorkByPincode(pincode);
	}

}
