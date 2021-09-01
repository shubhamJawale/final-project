package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pojos.Labour;
@Repository
public interface LabourRepo extends JpaRepository<Labour, Integer> {

	
	
}
