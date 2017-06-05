package com.niit.CollaborationBackEnd.DaoImpl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.Dao.UserDao;
import com.niit.CollaborationBackEnd.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUserByEmail(String emailId) {
		User user;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from User where emailId=:emailId ");
			query.setParameter("emailId", emailId);
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}
		return user;
	}

	public List<User> getAllUser() {
		List<User> users=sessionFactory.getCurrentSession().createQuery("from User").list();
		return users;
	}

	/*	
	*/
	public boolean insertUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public User validate(String emailId, String password) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where emailId=? and password=?").setParameter(0, emailId).setParameter(1, password).uniqueResult();
	}

	public User getUserById(int userId) {
		
		return (User)sessionFactory.getCurrentSession().get(User.class, userId);
	}

}