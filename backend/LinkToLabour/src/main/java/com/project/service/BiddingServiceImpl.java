package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BiddingRepo;
import com.project.dao.WorkRepo;
import com.project.pojos.Bidding;
import com.project.pojos.Work;

@Service
public class BiddingServiceImpl implements BiddingService {
	
	@Autowired
	public BiddingRepo biddingRepo;
	
	public WorkRepo workRepo;

	@Override
	public void AddBidding(Bidding bidding) {
		
		this.biddingRepo.save(bidding);
		
	}

	@Override
	public List<Bidding> getAllbyWorkId(int workId) {
		
		return this.biddingRepo.getAllbyWorkId(workId);
	}

	@Override
	public Bidding updateBidding(Bidding bidding) {
		
		return this.biddingRepo.save(bidding);
	}

	@Override
	public void deleteBidding(int biddingId) {
		this.biddingRepo.deleteById(biddingId);
		
	}

	@Override
	public void updateBidStatus(int biddingId) {
		
		 this.biddingRepo.updateBiddingStatus(biddingId);
	}

	@Override
	public Bidding getBiddingById(int biddingId) {
		
		return this.biddingRepo.getById(biddingId);
	}

	@Override
	public List<Bidding> getBiddingByContractorId(int contractorId) {
		
		return this.biddingRepo.getBiddingsbyContractorId(contractorId);
	}
	
	

}
