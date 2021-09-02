package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pojos.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
	 
	
	@Query("select r from Review r where  r.contractor.contractorId= ?1 ")
	public List<Review> getReviewBycontractorId(int contractorId);
	
	@Query("select r from Review r where  r.labour.labourId= ?1 ")
	public List<Review> getReviewBylabourId(int labourId);

	@Query("select r from Review r where r.user.userId= ?1 ")
	public List<Review> getReviewByuserId(int userId);
	
	
	
}
