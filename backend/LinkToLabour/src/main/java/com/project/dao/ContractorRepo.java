package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.User;
import com.project.pojos.Work;

@Repository
public interface ContractorRepo extends JpaRepository<Contractor, Integer> {

	@Query("select t from Contractor t where t.user.pincode = ?1")
	 List<Contractor> getContractorBypinCode(String pincode);

	
	  @Query("select t from Contractor t where t.user.userId = ?1") 
	  Contractor getContractorByUserId (int userId);
	 

}
