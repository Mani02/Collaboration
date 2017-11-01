package com.niit.CollaborationBackEnd.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.Dao.JobAppliedDao;
import com.niit.CollaborationBackEnd.model.JobApplied;
@Repository("jobAppliedDao")
@Transactional
public class JobAppliedDaoImpl implements JobAppliedDao{
	private SessionFactory sessionFactory;

	public JobAppliedDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public JobApplied getJobAppliedById(int jobAppliedId) {
		JobApplied jobApplied = (JobApplied) sessionFactory.getCurrentSession().get(JobApplied.class, jobAppliedId);
		return jobApplied;
	}

	public List<JobApplied> getAllJobApplied() {
		return sessionFactory.getCurrentSession().createQuery("from JobApplied").list();
	}

	public boolean insertJobApplied(JobApplied jobApplied) {
		try {
			sessionFactory.getCurrentSession().save(jobApplied);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateJobApplied(JobApplied jobApplied) {
		try {
			sessionFactory.getCurrentSession().update(jobApplied);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteJobApplied(JobApplied jobApplied) {
		try {
			sessionFactory.getCurrentSession().delete(jobApplied);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
