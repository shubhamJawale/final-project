package com.project.service;

import java.time.LocalDate;
import java.util.List;

import com.project.pojos.Work;
import com.project.pojos.WorkType;

import ch.qos.logback.core.status.Status;

public interface WorkService {
	
	public void addwork(Work work);
	public List<Work> getAllWork();
	

	
	public List<Work> getworkByUserID(int userid);
	
	public void deleteWork(Work work);
	
	
	public List<Work> getAllWorkByWorkType(LocalDate date, String pincode, WorkType workType);
	public List<Work> getAllWorkByStatus(Status status);
	public List<Work> getAllWorkByExceeding(LocalDate date, String pincode);
	

}
