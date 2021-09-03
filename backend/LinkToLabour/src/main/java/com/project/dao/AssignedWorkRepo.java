package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.pojos.AssignedWork;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Status;
import com.project.pojos.User;
import com.project.pojos.Work;

public interface AssignedWorkRepo extends JpaRepository<AssignedWork, Integer> 
{
	
	
	@Query("select a from AssignedWork a where a.work.user.userId=?1")
	public List<AssignedWork> getAssignedWorkByUserId(int userId);
	
	
	@Query("select a from AssignedWork a where a.work.WorkId =?1")
	public AssignedWork getAssignedWorkByWorkId(int WorkId);
	
	@Query("select a from AssignedWork a where a.bidding.contractor.contractorId=?1")
	public List<AssignedWork> getAssignedWorkByContractorId(int contractorId);
	@Query("select a from AssignedWork a where a.bidding.labour.labourId=?1")
	public List<AssignedWork> getAssignedWorkByLabourId(int labourId);
	
	/*
	 * @Query("select a from AssignedWork a where a.user=?1") public
	 * List<AssignedWork> getAssignedWorkByUser(User user);
	 * 
	 * @Query("select a from AssignedWork a where a.contractor=?1") public
	 * List<AssignedWork> getAssignedWorkByContractor(Contractor contractor);
	 * 
	 * @Query("select a from AssignedWork a where a.labour=?1") public
	 * List<AssignedWork> getAssignedWorkByLabour(Labour labour);
	 * 
	 * //THIS CAN BE CHANGED
	 * 
	 * @Query("select a from AsssignedWork a where a.status = ?1 and a.user =?2")
	 * public List<AssignedWork> getAssignedWorkByPendingStatusUser(Status status,
	 * User user);
	 * 
	 * @Query("select a from AsssignedWork a where a.status = ?1 and a.labour =?2")
	 * public List<AssignedWork> getAssignedWorkByPendingStatusLabour(Status status,
	 * Labour labour);
	 * 
	 * @Query("select a from AsssignedWork a where a.status = ?1 and a.contractor =?2"
	 * ) public List<AssignedWork> getAssignedWorkByPendingStatusContractor(Status
	 * status, Contractor contractor);
	 */

	
	
	
	
	
	
	
	
	
}
