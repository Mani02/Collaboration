package com.niit.CollaborationBackEnd.testCase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.Dao.JobDao;
import com.niit.CollaborationBackEnd.Dao.UserDao;
import com.niit.CollaborationBackEnd.model.Job;

public class JobTestCase {
	
	@Autowired
	public static AnnotationConfigApplicationContext context;
	
	@Autowired
	public static UserDao userDao;
	
	@Autowired
	public static JobDao jobDao;
	
	@Autowired
	public static Job job;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		job = (Job) context.getBean("job");
		
		jobDao = (JobDao) context.getBean("jobDao");
		
		userDao = (UserDao) context.getBean("userDao");
		
	}
	
//	@Test
//	public void createJobTestCase(){
//		job.setStatus('O');
//		job.setPostedDate(new java.sql.Date(System.currentTimeMillis()));
//		job.setTitle("HTML Developer");
//		job.setJobDescription("Should be an expert in CSS. Create CSS for various browser versions. Interact with back-end developers and create prototype. Work on CSS 2.0 designs, XHTML, div-style website. Knowledgeable in Dreamweaver, Photoshop, PSD to XHTML conversions.");
//		job.setRequirement("Qualification: 10+2+4, B.tech(CSE).\nExperience: 0 - 5 Years");
//
//		boolean flag = jobDao.insertJob(job);
//		assertEquals("createJobTestCase", true, flag);
//	}
	
	 @Test
	 public void getAllJobsTestCase() {
	 List<Job> jobs = jobDao.getAllJob();
	 assertEquals("getAllJobsTestCase", 4, jobs.size());
	 }
	 
//	@Test
//	public void deleteJobTestCase(){
//		job.setJobId(142);
//		
//		boolean flag = jobDao.deleteJob(job);
//		assertEquals("deleteBlogTestCase", flag, true);
//	}
	 
}
