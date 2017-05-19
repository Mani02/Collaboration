package com.niit.CollaborationBackEnd.Dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.User;

public interface UserDao {
	public User  getUserByEmail(String emailId);
	
	public User  getUserById(int userId);
	
	public List<User>  getAllUser();
	
	public boolean insertUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public User validate(String emailId,String password);
}
