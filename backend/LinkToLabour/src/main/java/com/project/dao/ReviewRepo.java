package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pojos.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
	
	@Query("select r from Review r where r.user.userId= ?1 and r.contractor.contractorId= ?2 and r.labour.labourId= ?3  ")
	public List<Review> getReviewById(int userId,int contractorId ,int labourId);

}
