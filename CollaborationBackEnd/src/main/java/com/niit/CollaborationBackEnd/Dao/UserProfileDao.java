package com.niit.CollaborationBackEnd.Dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.UserProfile;

public interface UserProfileDao {
	
	public boolean addUserProfile(UserProfile userProfile);
	public List<UserProfile> getallUProfile();
	public boolean updateUserProfile(UserProfile userProfile);
}
