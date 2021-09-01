package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.pojos.Labour;

public interface LabourRepo extends JpaRepository<Labour, Integer> {

	
	
}
