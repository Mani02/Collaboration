package com.niit.CollaborationBackEnd.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.Dao.JobDao;
import com.niit.CollaborationBackEnd.model.Job;

@Transactional
@Repository("jobDao")
public class JobDaoImpl implements JobDao{
	private SessionFactory sessionFactory;

	public JobDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Job getJobById(int jobId) {
		Job job = (Job) sessionFactory.getCurrentSession().get(Job.class, jobId);
		return job;
	}

	public List<Job> getAllJob() {
		return sessionFactory.getCurrentSession().createQuery("from Job").list();
	}

	public boolean insertJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteJob(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}

