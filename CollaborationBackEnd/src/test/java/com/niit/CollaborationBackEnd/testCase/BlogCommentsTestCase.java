//package com.niit.CollaborationBackEnd.testCase;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.CollaborationBackEnd.Dao.BlogCommentsDao;
//import com.niit.CollaborationBackEnd.Dao.BlogDao;
//import com.niit.CollaborationBackEnd.Dao.UserDao;
//import com.niit.CollaborationBackEnd.model.Blog;
//import com.niit.CollaborationBackEnd.model.BlogComments;
//import com.niit.CollaborationBackEnd.model.User;
//
//public class BlogCommentsTestCase {
//	@Autowired
//	public static AnnotationConfigApplicationContext context;
//
//	@Autowired
//	public static BlogComments blogComments;
//	
//	@Autowired
//	public static BlogCommentsDao blogCommentsDao;
//	
//	@Autowired
//	public static Blog blog;
//	
//	@Autowired
//	public static User user;
//	
//	@Autowired
//	public static BlogDao blogDao;
//	
//	@Autowired
//	public static UserDao userDao;
//	
//	@BeforeClass
//	public static void init(){
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("com.niit");
//		context.refresh();
//
//		blog =(Blog) context.getBean("blog");
//		
//		user =(User) context.getBean("user");
//		
//		blogComments = (BlogComments) context.getBean("blogComments");
//		
//		blogCommentsDao = (BlogCommentsDao) context.getBean("blogCommentsDao");
//		
//		blogDao = (BlogDao) context.getBean("blogDao");
//		
//		userDao = (UserDao) context.getBean("userDao");	
//		
//	}
//	
////	@Test
////	public void createBlogCommentsTestCase(){
////		blogComments.setBlogComment("Thanks it's a really helpful site.");
////		blogComments.setUser(userDao.getUserById(43));
////		blogComments.setBlog(blogDao.getBlogById(95));
////		blogComments.setCommentDate(new java.sql.Date(System.currentTimeMillis()));
////		
////		boolean flag = blogCommentsDao.insertBlogComments(blogComments);
////		assertEquals("createBlogCommentsTestCase" , true , flag);
////	}
//	
//	@Test
//	public void getAllBlogCommentsTestCase(){
//		List<BlogComments> blogComments = blogCommentsDao.getAllBlogComments();
//		assertEquals("getAllBlogCommentsTestCase", 6, blogComments.size());
//	}
//}
