package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserRepo;
import com.project.pojos.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userRepo;
	
	@Override
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

}
