package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pojos.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
