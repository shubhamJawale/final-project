package com.project.service;

import java.util.List;

import com.project.pojos.Work;

public interface WorkService {
	
	public void addwork(Work work);
	public List<Work> getAllWork();
	

	
	public List<Work> getworkByUserID(int userid);
	
	public void deleteWork(Work work);
	
	

}
