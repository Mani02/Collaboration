package com.niit.CollaborationBackEnd.testCase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.Dao.UserDao;
import com.niit.CollaborationBackEnd.Dao.UserProfileDao;
import com.niit.CollaborationBackEnd.model.User;
import com.niit.CollaborationBackEnd.model.UserProfile;

public class UserProfileTestCase {
	@Autowired
	public static AnnotationConfigApplicationContext context;

	@Autowired
	public static UserProfile userProfile;
	
	@Autowired
	public static UserProfileDao userProfileDao;
	
	@Autowired
	public static User user;
	
	@Autowired
	public static UserDao userDao;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userProfile = (UserProfile) context.getBean("userProfile");
		
		userProfileDao = (UserProfileDao) context.getBean("userProfileDao");
		
		user = (User) context.getBean("user");
		
		userDao = (UserDao) context.getBean("userDao");
	}
	
	/*@Test
	public void createUserProfileTestCase(){
		userProfile.setWorkExperience("Fresher");
		userProfile.setQualification("ICSE:75%    ISC:70%   B.TECH(CSE):7.37(CGPA)");
		userProfile.setHobby("Listening to Songs, Playing Computer Games");
		userProfile.setUser(userDao.getUserById(6));
		boolean flag = userProfileDao.addUserProfile(userProfile);
		assertEquals("createUserTestCase", true, flag);
	} */
}
