package com.niit.CollaborationBackEnd.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.Dao.BlogDao;
import com.niit.CollaborationBackEnd.model.Blog;


@Transactional
@Repository("blogDao")
public class BlogDaoImpl implements BlogDao{
	private SessionFactory sessionFactory;

	public BlogDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Blog getBlogById(int blogId) {
		Blog blog = (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogId);
		return blog;
	}

	public List<Blog> getAllBlog() {
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}

	public boolean insertBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBlog(Blog blog) {
		try{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}

	public List<Blog> getBlogByUserId(int userId) {
		return (List<Blog>) sessionFactory.getCurrentSession().createQuery("from Blog where User_userId='"+userId+"'").list();
	}

}

