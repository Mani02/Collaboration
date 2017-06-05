package com.niit.CollaborationBackEnd.Dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.BlogComments;

public interface BlogCommentsDao {
	
	public boolean insertBlogComments(BlogComments blogComments);

	public boolean updateBlogComments(BlogComments blogComments);

	public boolean deleteBlogComments(BlogComments blogComments);
	
	public BlogComments getBlogCommentsById(int blogComentId);
	
	public List<BlogComments>  getAllBlogComments();
	
	public List<BlogComments> getBlogCommentsByBlogId(int blogId);
}
