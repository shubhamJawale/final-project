package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserRepo;
import com.project.dao.WorkRepo;
import com.project.pojos.User;
import com.project.pojos.Work;

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

}
