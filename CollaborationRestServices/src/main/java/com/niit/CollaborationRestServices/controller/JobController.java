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

import com.niit.CollaborationBackEnd.Dao.JobDao;
import com.niit.CollaborationBackEnd.model.Job;

@RestController
public class JobController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	Job job;
	
	@Autowired
	JobDao jobDao;
	
	@PostMapping("/createJob")
	public ResponseEntity<Job> addJob(@RequestBody Job job) {
		logger.debug("->->->->calling method create Job");
		if (jobDao.getJobById(job.getJobId()) == null) {
			logger.debug("->->->->Job is going to create with id:" + job.getJobId());
				
			  job.setPostedDate(new java.sql.Date(System.currentTimeMillis()));
			  if (jobDao.insertJob(job) ==true)
			  {
				  job.setErrorCode("200");
					job.setErrorMessage("Thank you  for creating Job. You have successfully created Job as " + job.getJobId());
			  }
			  else
			  {
				  job.setErrorCode("404");
				  job.setErrorMessage("Could not complete the operatin please contact Admin");
		
				  
			  }
			
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
		logger.debug("->->->->Job already exist with id " + job.getJobId());
		job.setErrorCode("404");
		job.setErrorMessage("Job already exist with id : " + job.getJobId());
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}
	
	@GetMapping("/getAllJob")
	public ResponseEntity<List<Job>> getAllJob(){

		logger.debug("->->->->calling method listAllJob");
		
		List<Job> jobs = jobDao.getAllJob();
		
		if (jobs.isEmpty()) {
			job.setErrorCode("404");
			job.setErrorMessage("No jobs are available");
			jobs.add(job);
		}
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
}
