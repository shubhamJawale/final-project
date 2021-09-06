package com.project.service;

import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.User;

public interface UserService {

		public void addUser(User user);
		public User getUserById(int userId);
	
		public void deleteUser(int  userId);
		public User getUserByEmailId(String EmailId);
	
}
