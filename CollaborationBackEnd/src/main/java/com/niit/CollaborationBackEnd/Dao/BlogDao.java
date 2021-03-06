package com.niit.CollaborationBackEnd.Dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Blog;

public interface BlogDao {
	public Blog getBlogById(int blogId);

	public List<Blog> getBlogByUserId(int userId);
	
	public List<Blog> getAllBlog();

	public boolean insertBlog(Blog blog);

	public boolean updateBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

}
