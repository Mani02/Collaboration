package com.niit.CollaborationBackEnd.testCase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.Dao.FriendDao;
import com.niit.CollaborationBackEnd.Dao.UserDao;
import com.niit.CollaborationBackEnd.model.Friend;

public class FriendTestCase {

	@Autowired
	public static AnnotationConfigApplicationContext context;

	@Autowired
	public static Friend friend;
	
	@Autowired
	public static FriendDao friendDao;
	
	@Autowired
	public static UserDao userDao;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		
		friend = (Friend) context.getBean("friend");
		
		friendDao = (FriendDao) context.getBean("friendDao");
		
		userDao = (UserDao) context.getBean("userDao");
	}
	
//	@Test
//	public void insertFriendTestCase(){
//		friend.setUser(userDao.getUserById(43));
//		friend.setFriend(userDao.getUserById(22));
//		friend.setStatus("new request");
//		friend.setInitiator(1);
//		boolean flag = friendDao.insertFriend(friend);
//		assertEquals("insertFriendTestCase",true,flag);
//	}
	
}
