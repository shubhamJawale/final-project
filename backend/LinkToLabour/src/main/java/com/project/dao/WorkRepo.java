package com.project.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.pojos.User;
import com.project.pojos.Work;
@Repository
public interface WorkRepo extends JpaRepository<Work, Integer>
{
	/* :dynamic @Param("dynamic") dataype dynamic attribuytename; */
	
	@Query("select t from Work t where t.user = ?1")
	public	 List<Work> getWorkByUserId(User user);
}
