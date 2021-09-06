package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pojos.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.emailId=?1")
	public User getUserBYEmailId(String emailId);

}
