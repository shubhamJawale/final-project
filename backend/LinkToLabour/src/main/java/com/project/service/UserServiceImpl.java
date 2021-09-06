package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserRepo;
import com.project.pojos.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	//@Transactional(propagation = Propagation.MANDATORY)
	public void addUser(User user) {

		this.userRepo.save(user);
	}

	@Override
	public void deleteUser(int userId) {
		User user = this.userRepo.getById(userId);
		System.out.print(user);
		this.userRepo.delete(user);

	}

	@Override
	public User getUserById(int userId) {

		return this.userRepo.getById(userId);
	}

	@Override
	public User getUserByEmailId(String EmailId) {

		return this.userRepo.getUserBYEmailId(EmailId);
	}

}
