package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.pojos.Contractor;
import com.project.pojos.Labour;
@Repository
public interface LabourRepo extends JpaRepository<Labour, Integer> {

	@Query("select t from Labour t where t.user.pincode = ?1")
	public	 List<Labour> getLabourBypinCode(String pincode);
	
	@Query("select t from Labour t where t.contractor.contractorId=?1")
	public List<Labour>getLabourBycontractorsId(int contractorId);
	
	@Query("select t from Labour t where t.user.userId = ?1")
	Labour getLabourByUserId(int userId);
	 
	 
	
}
