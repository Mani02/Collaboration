package com.niit.CollaborationRestServices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackEnd.Dao.UserProfileDao;
import com.niit.CollaborationBackEnd.model.UserProfile;

@RestController
public class UserProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserProfileDao userProfileDao;
	
	@Autowired
	UserProfile userProfile;
	
	
	@PostMapping("/createuserProfile")
	public ResponseEntity<UserProfile> createuserProfile(@RequestBody UserProfile userProfile){
		
		logger.debug("->->->->calling method createuserProfile");
		logger.debug("->->->->User is going to create with id:" + userProfile.getUser());
		if(userProfileDao.addUserProfile(userProfile) == true)
		{
			userProfile.setErrorCode("200");
			userProfile.setErrorMessage("Thank you  upadating user Qualification and Experience you have sucessfully ");
		}
		else
		{
			userProfile.setErrorCode("404");
			userProfile.setErrorMessage("Could not complete the operatin please contact Admin");  
		}
		return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
	}
	
	@PutMapping("/updateuserProfile")
	public  ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile){
		logger.debug("->->->-> calling method updateUser");
		if(userProfileDao.updateUserProfile(userProfile)==true)
		{
			userProfile.setErrorCode("200");
			userProfile.setErrorMessage("Successfully updated userProfile");
		}
		else
		{
			userProfile.setErrorCode("400");
			userProfile.setErrorCode("Could not update UserProfile");
		}
		return new ResponseEntity<UserProfile>(userProfile , HttpStatus.OK);
	}
}
