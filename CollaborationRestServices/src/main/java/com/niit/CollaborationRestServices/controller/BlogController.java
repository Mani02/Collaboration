package com.niit.CollaborationRestServices.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.Dao.BlogDao;
import com.niit.CollaborationBackEnd.model.BaseDomain;
import com.niit.CollaborationBackEnd.model.Blog;
import com.niit.CollaborationBackEnd.model.User;

@RestController
public class BlogController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	BlogDao blogDao;

	@Autowired
	Blog blog;
	
	//@Autowired
	//HttpSession session;
	

	@PostMapping("/createBlog")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		logger.debug("->->->->calling method createBlog");
		if (blogDao.getBlogById(blog.getBlogId()) == null) {
			logger.debug("->->->->Blog is going to create with id:" + blog.getBlogId());
				
			  blog.setCreatedOn(new java.sql.Date(System.currentTimeMillis()));
			  if (blogDao.insertBlog(blog) ==true)
			  {
				  blog.setErrorCode("200");
					blog.setErrorMessage("Thank you  for creating Blog. You have successfully created Blog as " + blog.getBlogId());
			  }
			  else
			  {
				  blog.setErrorCode("404");
				  blog.setErrorMessage("Could not complete the operatin please contact Admin");
		
				  
			  }
			
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
		logger.debug("->->->->Blog already exist with id " + blog.getBlogId());
		blog.setErrorCode("404");
		blog.setErrorMessage("Blog already exist with id : " + blog.getBlogId());
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	@GetMapping("/getAllBlog")
	public ResponseEntity<List<Blog>> getAllBlog(){

		logger.debug("->->->->calling method listAllBlog");
		
		List<Blog> blogs = blogDao.getAllBlog();
		
		if (blogs.isEmpty()) {
			blog.setErrorCode("404");
			blog.setErrorMessage("No blogs are available");
			blogs.add(blog);
		}
		return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	}
	
	@GetMapping("/getBlogByBlogId/{id}")
	public ResponseEntity<Blog> getBlogByBlogId(@PathVariable("id") int id) {
		logger.debug("->->calling method getBlogByBlogId");
		logger.debug("->->id->->" + id);
		Blog blog = blogDao.getBlogById(id);
		if (blog == null) {
			logger.debug("->->->-> Blog does not exist with id" + id);
			blog = new Blog(); //To avoid NLP - NullPointerException
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog does not exist");
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
		logger.debug("->->->-> Blog exist with id" + id);
		logger.debug(blog.getTitle());
		blog.setErrorCode("200");
		blog.setErrorMessage("Blog exists with id " + id);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	@GetMapping("/getBlogByUserid/{id}")
	public ResponseEntity<List<Blog>> getBlogByUserid(@PathVariable("id") int id) {
		logger.debug("->->calling method getBlogByUserid");
		logger.debug("->->id->->" + id);
		List<Blog> blog = blogDao.getBlogByUserId(id);
		if (blog == null) {
			logger.debug("->->->-> Blog does not exist with userid" + id);
			blog = (List<Blog>) new Blog(); //To avoid NLP - NullPointerException
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
		}
		logger.debug("->->->-> Blog exist with id" + id);
		return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
	}

}
