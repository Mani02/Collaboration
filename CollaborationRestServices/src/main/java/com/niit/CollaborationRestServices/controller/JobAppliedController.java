package com.niit.CollaborationRestServices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.Dao.JobAppliedDao;
import com.niit.CollaborationBackEnd.model.Job;
import com.niit.CollaborationBackEnd.model.JobApplied;

@RestController
public class JobAppliedController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	JobApplied jobApplied;
	
	@Autowired
	JobAppliedDao jobAppliedDao;
	
	
	@PostMapping("/newJobApplied")
	public ResponseEntity<JobApplied> newJobApplied(@RequestBody JobApplied jobApplied) {
		logger.debug("->->->->calling method create Job");
		if (jobAppliedDao.getJobAppliedById(jobApplied.getJobAppliedId())==null) {
			logger.debug("->->->->Job is going to create with id:" + jobApplied.getJobAppliedId());
				
			  jobApplied.setAppliedDate(new java.sql.Date(System.currentTimeMillis()));
			  if (jobAppliedDao.insertJobApplied(jobApplied)==true)
			  {
				  jobApplied.setErrorCode("200");
					jobApplied.setErrorMessage("Thank you  for Applying for  the Job "+ jobApplied.getUser() + " as " + jobApplied.getJobAppliedId());
			  }
			  else
			  {
				  jobApplied.setErrorCode("404");
				  jobApplied.setErrorMessage("Could not complete the operatin please contact Admin");
		
				  
			  }
			
			return new ResponseEntity<JobApplied>(jobApplied, HttpStatus.OK);
		}
		logger.debug("->->->->Job already exist with id " + jobApplied.getJobAppliedId());
		jobApplied.setErrorCode("404");
		jobApplied.setErrorMessage("Job already exist with id : " + jobApplied.getJobAppliedId());
		return new ResponseEntity<JobApplied>(jobApplied, HttpStatus.OK);
	}
	
	@GetMapping("/getAllJobsApllied")
	public ResponseEntity<List<JobApplied>> getAllJobsApplied(){

		logger.debug("->->->->calling method listAllJobApplied");
		
		List<JobApplied> jobsApplied = jobAppliedDao.getAllJobApplied();
		
		if (jobsApplied.isEmpty()) {
			jobApplied.setErrorCode("404");
			jobApplied.setErrorMessage("No one has applid for jobs yet.");
			jobsApplied.add(jobApplied);
		}
		return new ResponseEntity<List<JobApplied>>(jobsApplied, HttpStatus.OK);
	}
	
}
