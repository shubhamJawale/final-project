package com.project.service;

import java.util.List;

import com.project.pojos.Review;

public interface ReviewService {
	
	public void addReview(Review review);
	
	public List<Review> getReviewById(int userId,int contractorId,int labourId); 

}
