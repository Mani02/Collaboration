package com.niit.CollaborationBackEnd.Dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.JobApplied;

public interface JobAppliedDao {
	
	public JobApplied  getJobAppliedById(int jobAppliedId);
	
	public List<JobApplied>  getAllJobApplied();

	public boolean insertJobApplied(JobApplied jobApplied);
	
	public boolean updateJobApplied(JobApplied jobApplied);
	
	public boolean deleteJobApplied(JobApplied jobApplied);
}
