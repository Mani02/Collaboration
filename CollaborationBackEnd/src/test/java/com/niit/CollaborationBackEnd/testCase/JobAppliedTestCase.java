package com.niit.CollaborationBackEnd.testCase;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.Dao.JobAppliedDao;
import com.niit.CollaborationBackEnd.Dao.JobDao;
import com.niit.CollaborationBackEnd.Dao.UserDao;
import com.niit.CollaborationBackEnd.model.JobApplied;

public class JobAppliedTestCase {

	@Autowired
	public static AnnotationConfigApplicationContext context;
	
	@Autowired
	public static UserDao userDao;
	
	@Autowired
	public static JobDao jobDao;
	
	@Autowired
	public static JobAppliedDao jobAppliedDao;
	
	@Autowired
	public static JobApplied jobApplied;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		jobApplied = (JobApplied) context.getBean("jobApplied");
		
		jobDao = (JobDao) context.getBean("jobDao");
		
		userDao = (UserDao) context.getBean("userDao");
		
		jobAppliedDao = (JobAppliedDao) context.getBean("jobAppliedDao");
		
	}
	
//	@Test
//	public void createJobAppliedTestCase(){
//		jobApplied.setStatus("New");
//		jobApplied.setRemarks(" ");
//		jobApplied.setAppliedDate(new java.sql.Date(System.currentTimeMillis()));
//		jobApplied.setUser(userDao.getUserById(22));
//		jobApplied.setJob(jobDao.getJobById(169));
//		
//		boolean flag = jobAppliedDao.insertJobApplied(jobApplied);
//		assertEquals("createJobAppliedTestCase",true,flag);
//	}
	
	@Test
	public void getAllJobAppliedTestCase(){
		List<JobApplied> jobApplied = jobAppliedDao.getAllJobApplied();
		assertEquals("getAllJobAppliedTestCase",1,jobApplied.size());
	}
}
