package com.project.service;

import java.util.List;

import com.project.pojos.Bidding;

public interface BiddingService {
	
	public void AddBidding(Bidding bidding);
	
	List<Bidding> getAllbyWorkId(int workId);
	
	public Bidding updateBidding(Bidding bidding);
	
	public void deleteBidding(int biddingId);
	
	public void updateBidStatus(int biddingId);
	
	public Bidding getBiddingById(int biddingId);
	
	List<Bidding> getBiddingByContractorId(int contractorId);
}
