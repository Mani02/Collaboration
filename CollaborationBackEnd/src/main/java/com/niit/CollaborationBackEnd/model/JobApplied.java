package com.niit.CollaborationBackEnd.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="C_JOB_APPLIED")
public class JobApplied extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int jobAppliedId;
	
	private String status;
	
	private String remarks;
	
	private Date appliedDate;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User user;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Job job;
	
	public int getJobAppliedId() {
		return jobAppliedId;
	}

	public void setJobAppliedId(int jobAppliedId) {
		this.jobAppliedId = jobAppliedId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
}
