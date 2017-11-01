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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.Dao.UserDao;
import com.niit.CollaborationBackEnd.model.User;


@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDao userDao;

	@Autowired
	User user;
	
	//@Autowired
	//HttpSession session;
	

	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		logger.debug("->->->->calling method createUser");
		if (userDao.getUserByEmail(user.getEmailId()) == null) {
			logger.debug("->->->->User is going to create with id:" + user.getEmailId());
			
				
			  if (userDao.insertUser(user) ==true)
			  {
				  user.setErrorCode("200");
				  user.setErrorMessage("Thank you  for registration. You have successfully registered as " + user.getRole());
			  }
			  else
			  {
				  user.setErrorCode("404");
				  user.setErrorMessage("Could not complete the operatin please contact Admin");			  
			  }
			
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		logger.debug("->->->->User already exist with id " + user.getEmailId());
		user.setErrorCode("404");
		user.setErrorMessage("User already exist with id : " + user.getEmailId());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){

		logger.debug("->->->->calling method listAllUsers");
		
		List<User> users = userDao.getAllUser();
		
		if (users.isEmpty()) {
			user.setErrorCode("404");
			user.setErrorMessage("No users are available");
			users.add(user);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<User> validate(@RequestBody User newuser){
		System.out.println("->->->->method to validate userId and password");
		user = userDao.getUserByEmail(newuser.getEmailId());
		if(user!=null && (newuser.getPassword().equals(user.getPassword()))){
			user.setErrorCode("200");
			user.setErrorMessage("You have logged in successfully!!" /*+ user.getUserName()*/);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}else{
			newuser.setErrorCode("404");
			newuser.setErrorMessage("Invalid Credentials...Please try again!");
			return new ResponseEntity<User>(newuser,HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		logger.debug("->->->->calling method updateUser");
		if (userDao.getUserById(user.getUserId()) == null) {
			logger.debug("->->->->User does not exist with id " + user.getUserId());
			user = new User(); // ?
			user.setErrorCode("404");
			user.setErrorMessage("User does not exist with id " + user.getUserId());
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		userDao.updateUser(user);
		logger.debug("->->->->User updated successfully");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}


	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		logger.debug("->->calling method getUser");
		logger.debug("->->id->->" + id);
		User user = userDao.getUserById(id);
		if (user == null) {
			logger.debug("->->->-> User does not exist wiht id" + id);
			user = new User(); //To avoid NLP - NullPointerException
			user.setErrorCode("404");
			user.setErrorMessage("User does not exist");
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		logger.debug("->->->-> User exist wiht id" + id);
		//logger.debug(/*user.getUserName()*/);
		user.setErrorCode("200");
		user.setErrorMessage("User exists with id " + id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String f1()
	{
		System.out.println("f1");
		return "index";
	}
}
