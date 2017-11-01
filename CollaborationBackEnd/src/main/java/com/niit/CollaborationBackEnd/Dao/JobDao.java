package com.niit.CollaborationBackEnd.Dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Job;

public interface JobDao {
public Job  getJobById(int jobId);
	
	public List<Job>  getAllJob();

	public boolean insertJob(Job job);
	
	public boolean updateJob(Job job);
	
	public boolean deleteJob(Job job);
}
