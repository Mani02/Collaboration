package com.niit.CollaborationBackEnd.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.Dao.UserProfileDao;
import com.niit.CollaborationBackEnd.model.UserProfile;

@Repository("userProfileDao")
@Transactional
public class UserProfileDaoImpl implements UserProfileDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserProfileDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public boolean updateUserProfile(UserProfile userProfile) {
		try {
			sessionFactory.getCurrentSession().update(userProfile);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUserProfile(UserProfile userProfile) {
		try {
			sessionFactory.getCurrentSession().delete(userProfile);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addUserProfile(UserProfile userProfile) {
		try {
			sessionFactory.getCurrentSession().save(userProfile);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<UserProfile> getallUProfile() {
		return sessionFactory.getCurrentSession().createQuery("from UserProfile").list();
	}

}
