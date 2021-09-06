package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.pojos.Requests;

public interface RequestRepo extends JpaRepository<Requests, Integer> {

	@Query("select r from Requests r where r.contractor.contractorId=?1")
	public List<Requests> getAllRequestsByContractorId(int contractorId);
	@Query("select r from Requests r where r.labour.labourId=?1")
	public List<Requests> getAllRequestsByLabourId(int labourId);
	@Modifying
	@Transactional
	@Query("delete from Requests r where r.requestid=?1") 
	public void deleterequestwithrequestid(int id);
}
