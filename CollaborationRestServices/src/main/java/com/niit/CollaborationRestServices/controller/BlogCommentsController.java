package com.niit.CollaborationRestServices.controller;

import java.util.List;

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

import com.niit.CollaborationBackEnd.Dao.BlogCommentsDao;
import com.niit.CollaborationBackEnd.model.BlogComments;

@RestController
public class BlogCommentsController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	BlogComments blogComments;

	@Autowired
	BlogCommentsDao blogCommentsDao;

	@PostMapping("/addComment")
	public ResponseEntity<BlogComments> addComment(@RequestBody BlogComments blogComments) {
		logger.debug("->->->->calling method addComment");
		if (blogCommentsDao.getBlogCommentsById(blogComments.getBlogCommentId()) == null) {
			if (blogCommentsDao.insertBlogComments(blogComments) == true) {
				blogComments.setErrorCode("200");
				blogComments.setErrorMessage("Thank you  for writing Comment. You have successfully written comment as "
						+ blogComments.getBlogCommentId());
			} else {
				blogComments.setErrorCode("404");
				blogComments.setErrorMessage("Could not complete the operatin please contact Admin");
			}
			return new ResponseEntity<BlogComments>(blogComments, HttpStatus.OK);
		}
		logger.debug("->->->->BlogComment already exist with id " + blogComments.getBlogCommentId());
		blogComments.setErrorCode("404");
		blogComments.setErrorMessage("BlogComment already exist with id : " + blogComments.getBlogCommentId());
		return new ResponseEntity<BlogComments>(blogComments, HttpStatus.OK);
	}
	
	@GetMapping("/getBlogCommentsByBlogCommentId/{id}")
	public ResponseEntity<BlogComments> getBlogCommentsByBlogCommentId(@PathVariable("id") int id){
		logger.debug("->->calling method getBlogCommentsByBlogCommentId");
		logger.debug("->->id->->" + id);
		BlogComments blogComment = blogCommentsDao.getBlogCommentsById(id);
		if (blogComment == null) {
			logger.debug("->->->-> BlogComment does not exist with id" + id);
			blogComment = new BlogComments(); //To avoid NLP - NullPointerException
			blogComments.setErrorCode("404");
			blogComments.setErrorMessage("BlogComment does not exist");
			return new ResponseEntity<BlogComments>(blogComment, HttpStatus.OK);
		}
		logger.debug("->->->-> BlogComment exist with id" + id);
		blogComments.setErrorCode("200");
		blogComments.setErrorMessage("Blog exists with id " + id);
		return new ResponseEntity<BlogComments>(blogComment, HttpStatus.OK);
	}
	
	@GetMapping("/getBlogCommentsByBlogId/{id}")
	public ResponseEntity<List<BlogComments>> getBlogCommentsByBlogId(@PathVariable("id") int id) {
		logger.debug("->->calling method getBlogCommentsByBlogId");
		logger.debug("->->id->->" + id);
		List<BlogComments> blogComments = blogCommentsDao.getBlogCommentsByBlogId(id);
		if (blogComments == null) {
			logger.debug("->->->-> BlogComment does not exist with blogid" + id);
			blogComments = (List<BlogComments>) new BlogComments(); //To avoid NLP - NullPointerException
			return new ResponseEntity<List<BlogComments>>(blogComments, HttpStatus.OK);
		}
		logger.debug("->->->-> Blog exist wiht id" + id);
		return new ResponseEntity<List<BlogComments>>(blogComments, HttpStatus.OK);
	}

}
