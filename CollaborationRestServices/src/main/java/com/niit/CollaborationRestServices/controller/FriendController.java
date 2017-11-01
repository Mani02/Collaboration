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

import com.niit.CollaborationBackEnd.Dao.FriendDao;
import com.niit.CollaborationBackEnd.model.Friend;

@RestController
public class FriendController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	Friend friend;

	@Autowired
	Friend frnd;

	@Autowired
	FriendDao friendDao;

	@PostMapping("/friend/send/request")
	public ResponseEntity<Void> sendFriendRequest(@RequestBody Friend friend) {
		logger.debug("Calling method send friend request");
		if (friendDao.insertFriend(friend) == true) {
			friend.setErrorCode("200");
			friend.setErrorMessage("You have successfully send request ");

			Friend frnd = new Friend();
			frnd.setUser(friend.getFriend());
			frnd.setFriend(friend.getUser());
			frnd.setStatus("new");
			frnd.setInitiator(0);
			friendDao.insertFriend(frnd);

			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			friend.setErrorCode("404");
			friend.setErrorMessage("Could not complete the operatin please contact Admin");

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/friend/confirm")
	public ResponseEntity<Void> friendRequestacceptOrReject(@RequestBody Friend friend) {
		logger.debug("calling method confirm friend");
		if (friendDao.updateFriend(friend) == true) {
			friend.setErrorCode("200");
			friend.setErrorMessage("You have accepted the request ");

			int friendId = friend.getFriend().getUserId();
			int userId = friend.getUser().getUserId();
			frnd = friendDao.getFriend(friendId, userId);
			frnd.setStatus(friend.getStatus());
			if(friendDao.updateFriend(frnd)){
			return new ResponseEntity<Void>(HttpStatus.OK);
			}
			else{
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		} else {
			friend.setErrorCode("404");
			friend.setErrorMessage("Friend request not accepted");

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllFriend/{id}")
	public ResponseEntity<List<Friend>> getAllFriendByUser_userId(@PathVariable("id") int id) {

		logger.debug("->->->->calling method getAllFriendByUserId");

		List<Friend> friends = friendDao.getFriendsByUser_userId(id);

		if (friends.isEmpty()) {
			friend.setErrorCode("400");
			friend.setErrorMessage("You have no friends.");
			//friends.add(friend);
			logger.debug("->->->-> Friends does not exist for id" + id);
			return new ResponseEntity<List<Friend>>(friends, HttpStatus.NOT_FOUND);
		}
		logger.debug("->->->-> Friends exist for id" + id);
		friend.setErrorCode("200");
		friend.setErrorMessage("Friends exists with id " + id);
		return new ResponseEntity<List<Friend>>(friends, HttpStatus.OK);
	}

	@GetMapping("/viewFriendRequest/{id}")
	public ResponseEntity<List<Friend>> getRequestByUser_friendRequest(@PathVariable("id") int id) {
		logger.debug("->->calling method viewFriendRequest");
		logger.debug("->->id->->" + id);
		List<Friend> friendReq = friendDao.getRequestByUser_friendRequest(id);
		if (friendReq == null) {
			logger.debug("->->->-> You do not have any Friend Request for userid" + id);
			friend.setErrorCode("400");
			friend.setErrorMessage("You have no friend requests.");
			friendReq = (List<Friend>) new Friend(); // To avoid NLP -
														// NullPointerException
			return new ResponseEntity<List<Friend>>(friendReq, HttpStatus.NOT_FOUND);
		}
		logger.debug("->->->-> You have any Friend Request for userid" + id);
		friend.setErrorCode("200");
		friend.setErrorMessage("You have friend requests.");
		return new ResponseEntity<List<Friend>>(friendReq, HttpStatus.OK);
	}

	@GetMapping("/mySendRequests/{id}")
	public ResponseEntity<List<Friend>> getSentRequestByUser_userId(@PathVariable("id") int id) {
		logger.debug("->->calling method viewFriendRequestSend");
		logger.debug("->->id->->" + id);
		List<Friend> sendfriendReq = friendDao.getSentRequestByUser_userId(id);
		if (sendfriendReq == null) {
			logger.debug("->->->-> You did not Send any Friend Request");
			logger.debug("->->id->->" + id);
			friend.setErrorCode("400");
			friend.setErrorMessage("You did not Send any Friend Request.");
			sendfriendReq = (List<Friend>) new Friend(); // To avoid NLP -
															// NullPointerException
			return new ResponseEntity<List<Friend>>(sendfriendReq, HttpStatus.NOT_FOUND);
		}
		logger.debug("->->->-> You have Send Friend Request");
		logger.debug("->->id->->" + id);
		friend.setErrorCode("200");
		friend.setErrorMessage("You have Send friend requests.");
		return new ResponseEntity<List<Friend>>(sendfriendReq, HttpStatus.OK);
	}
}
