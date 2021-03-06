package com.niit.CollaborationBackEnd.testCase;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.Dao.BlogDao;
import com.niit.CollaborationBackEnd.Dao.UserDao;
import com.niit.CollaborationBackEnd.model.Blog;

public class BlogTestCase {

	@Autowired
	public static AnnotationConfigApplicationContext context;

	@Autowired
	public static Blog blog;

	@Autowired
	public static BlogDao blogDao;

	@Autowired
	public static UserDao userDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		blog = (Blog) context.getBean("blog");

		blogDao = (BlogDao) context.getBean("blogDao");
		
		userDao = (UserDao) context.getBean("userDao");

	}

//	@Test
//	public void createBlogTestCase() {
//		blog.setTitle("This is my third blog");
//		blog.setDescription("3rd Blog");
//		blog.setContent("3rd Blog");
//		blog.setCreatedOn(new java.sql.Date(System.currentTimeMillis()));
//		blog.setUser(userDao.getUserById(63));
//		boolean flag = blogDao.insertBlog(blog);
//		assertEquals("createBlogTestCase ", true, flag);
//	}

//	 @Test public void updateBlogTestCase() {
//	 Blog blog = blogDao.getBlogById(47);
//	 //blog.setUser(userDao.getUserById(43));
//	 boolean flag = blogDao.updateBlog(blog);
//	 
//	
//	 assertEquals("updateBlogTestCase", true, flag); }
	
//	@Test
//	public void deleteBlogTestCase(){
//		blog.setBlogId(50);
//		blog.setTitle("Welcome Students");
//		blog.setDescription("Welcoming message to new students of the academing year 2017-2018");
//		blog.setContent("Sharada University gives a warm welcome to the students of the new academing year of 2017-2018.You all are welcome to our college campus.Enjoy your new college life.Fell free to ask us anything important.Have a great campus life ahead.");
//		blog.setStatus('N');
//		
//		boolean flag = blogDao.deleteBlog(blog);
//		assertEquals("deleteBlogTestCase", flag, true);
//	}

	 @Test
	 public void getAllBlogsTestCase() {
	 List<Blog> blogs = blogDao.getAllBlog();
	 assertEquals("getAllBlogsTestCase", 13, blogs.size());
	 }
}
