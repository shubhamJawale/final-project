package com.project.service;

import java.util.List;

import com.project.pojos.Review;

public interface ReviewService {
	
	public void addReview(Review review);
	
	public List<Review> getReviewsByUserId(int userId);
	public List<Review> getReviewsByLabourId(int labourId);
	public List<Review> getReviewsByContractorId(int contractorId);
}
