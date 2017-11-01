package com.niit.CollaborationBackEnd.Dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Friend;

public interface FriendDao {
	
	public boolean insertFriend(Friend friend);
	
	public boolean updateFriend(Friend friend);
	
	public Friend getFriend(int friendId, int userId);
	
	public boolean deleteFriend(Friend friend);
	
	public List<Friend> getFriendsByUser_userId(int userId);
	
	public List<Friend> getRequestByUser_friendRequest(int userId);
	
	public List<Friend> getSentRequestByUser_userId(int userId);
}
