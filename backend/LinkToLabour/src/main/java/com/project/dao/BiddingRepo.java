package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.pojos.Bidding;
import com.project.pojos.Work;

@Repository
public interface BiddingRepo extends JpaRepository<Bidding, Integer> {

	@Query("select b from Bidding b where b.work.WorkId = ?1")
	List<Bidding> getAllbyWorkId(int id);

	@Query("update Bidding b set b.status='ACCEPTED' where b.biddingId= ?1")
	void updateBiddingStatus(int biddingId);
	@Query("select b from Bidding b where b.contractor.contractorId= ?1")
	List<Bidding> getBiddingsbyContractorId(int contractorId);
	
}
