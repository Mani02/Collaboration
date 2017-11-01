package com.niit.CollaborationBackEnd.testCase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.Dao.BlogDao;
import com.niit.CollaborationBackEnd.Dao.UserDao;
import com.niit.CollaborationBackEnd.model.User;

import junit.framework.Assert;

public class UserTestCase {

	@Autowired
	public static AnnotationConfigApplicationContext context;

	@Autowired
	public static User user;

	@Autowired
	public static UserDao userDao;

	@Autowired
	public static BlogDao blogDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");

		userDao = (UserDao) context.getBean("userDao");
		
		blogDao = (BlogDao) context.getBean("blogDao");

	}

	
	 @Test public void createUserTestCase() {
	  
	 user.setFullName("Debojyoti");
	 user.setUserName("Dj1");
	 user.setPassword("Roychoudhuri");
	 user.setRole("Student");
	 user.setStatus(' ');
	 user.setGender("Male");
	 user.setIsOnline('O'); 
	 user.setAddress("Kolkata");
	 user.setEmailId("debojyoti@gmail.com"); 
	 user.setMobile("9094698600");
	 boolean flag = userDao.insertUser(user);
	  
	 assertEquals("createUserTestCase ", true, flag); }
	  
	/*@Test
	public void updateUserTestCase() {
		User user = userDao.getUserById(63);
		user.setFullName("Ramit Kundu");
		user.setPassword("ramit@12");
		user.setRole("Student");
		user.setGender("Male");
		user.setAddress("Kakurgachi, Kolkata-700054");
		user.setEmailId("ramit.kundu@gmail.com");
		user.setMobile("9834001002");
		user.setIsOnline(' ');
		user.setStatus(' ');

		boolean flag = userDao.updateUser(user);

		assertEquals("updateUserTestCase", true, flag);
	}*/

//	@Test
//	public void getUserByIdTestCase() {
//		int flag = 0;
//		user = userDao.getUserById(23);
//		if (user != null) {
//			flag++;
//			assertEquals("getUserByIdTestCase", 1, flag);
//		} else {
//			assertEquals("getUserByIdTestCase", 0, flag);
//		}
//	}
	//
	// @Test
	// public void getUserByEmailTestCase() {
	// int flag = 0;
	// user = userDao.getUserByEmail("mani@gmail.com");
	// if (user != null) {
	// flag++;
	// assertEquals("getUserByEmailTestCase", 1, flag);
	// } else {
	// assertEquals("getUserByEmailTestCase", 0, flag);
	// }
	//
	// }

//	 @Test
//	 public void getAllUsersTestCase() {
//	 List<User> users = userDao.getAllUser();
//	 assertEquals("getAllUsersTestCase", 5, users.size());
//	 }

	// @Test
	// public void deleteUserTestCase() {
	// user.setUserId(44);
	// user.setName("Shreya");
	// user.setPassword("Sky1");
	// user.setRole("Student");
	// user.setStatus('A');
	// user.setGender('F');
	// user.setIsOnline('O');
	// user.setAddress("North Kolkata");
	// user.setEmailId("shreya@gmail.com");
	// user.setMobile("9004050123");
	//
	// boolean flag = userDao.deleteUser(user);
	// assertEquals("deleteUserTestCase", flag, true);
	//
	// }

}
