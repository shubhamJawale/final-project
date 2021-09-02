package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ReviewRepo;
import com.project.pojos.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	public ReviewRepo reviewRepo;
	
	@Override
	public void addReview(Review review) {
		this.reviewRepo.save(review);

	}

	@Override
	public List<Review> getReviewById(int userId,int contractorId,int labourId ) {
		
		return this.reviewRepo.getReviewById(userId, contractorId, labourId);
	}

}
