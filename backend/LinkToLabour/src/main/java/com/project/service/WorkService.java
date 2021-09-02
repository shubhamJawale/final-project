package com.project.service;

import java.time.LocalDate;
import java.util.List;

import com.project.pojos.Status;
import com.project.pojos.Work;
import com.project.pojos.WorkType;



public interface WorkService {
	
	public void addwork(Work work);
	public List<Work> getAllWork();
	
	public Work getWorkByWorkId(int workId);
	
	public List<Work> getworkByUserID(int userid);
	
	public void deleteWork(Work work);
	public List<Work> getWorkByPincode(String pincode);
	
	public List<Work> getAllWorkByWorkType(LocalDate date, String pincode, WorkType workType, Status status);
	public List<Work> getAllWorkByStatus(Status status);
	public List<Work> getAllWorkByExceeding(LocalDate date, String pincode);
	

}
