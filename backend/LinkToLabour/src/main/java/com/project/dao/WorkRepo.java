package com.project.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.pojos.Status;
import com.project.pojos.User;
import com.project.pojos.Work;
import com.project.pojos.WorkType;


@Repository
public interface WorkRepo extends JpaRepository<Work, Integer>
{
	/* :dynamic @Param("dynamic") dataype dynamic attribuytename; */
	
	@Query("select t from Work t where t.user = ?1")
	public	 List<Work> getWorkByUserId(User user);
	
	@Query("select t from Work t where t.toDate >?1 and t.pinCode =?2")
	public List<Work> getAllWorkByExceedingDate(LocalDate date, String pincode);

	@Query("select t from Work t where  t.toDate >?1 and t.pinCode =?2 and t.workType =?3 and t.status =?4 ")
	public List<Work> getAllWorkByWorkType(LocalDate date, String pincode, WorkType workType, Status status);


	@Query("select t from Work t where t.status >?1")
	public List<Work> getAllWorkByStatus(Status status);
	
	///
	@Query("select t from Work t where t.user.userId =?1")
	public List<Work> getWorkByUser(int userid);
	
	@Query("select t from Work t where t.pinCode=?1 ")
	public List<Work> getWorkByPincode(String pincode);


}
