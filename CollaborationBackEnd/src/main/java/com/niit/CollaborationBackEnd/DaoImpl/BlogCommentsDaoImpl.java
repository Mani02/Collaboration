package com.niit.CollaborationBackEnd.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.Dao.BlogCommentsDao;
import com.niit.CollaborationBackEnd.model.BlogComments;

@Transactional
@Repository("blogCommentsDao")
public class BlogCommentsDaoImpl implements BlogCommentsDao{
	
	private SessionFactory sessionFactory;

	public BlogCommentsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean insertBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().save(blogComments);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateBlogComments(BlogComments blogComments) {
		try {
			sessionFactory.getCurrentSession().update(blogComments);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBlogComments(BlogComments blogComments) {
		try{
			sessionFactory.getCurrentSession().delete(blogComments);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}

	public List<BlogComments> getAllBlogComments() {
		return sessionFactory.getCurrentSession().createQuery("from BlogComments").list();
	}

	public BlogComments getBlogCommentsById(int blogComentId) {
		BlogComments blogComment = (BlogComments) sessionFactory.getCurrentSession().get(BlogComments.class,blogComentId);
		return blogComment;
	}

	public List<BlogComments> getBlogCommentsByBlogId(int blogId) {
		
		return (List<BlogComments>) sessionFactory.getCurrentSession().createQuery("from BlogComments where blogId='"+blogId+"'").list();
	}

}
