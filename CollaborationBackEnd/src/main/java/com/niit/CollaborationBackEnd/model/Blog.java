package com.niit.CollaborationBackEnd.model;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name="C_BLOG")
public class Blog extends BaseDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int blogId;
	
	private String title;
	
	private String description;

	private String content;

	private String status;

	private String reason;
	
	private int views;
	
	private int likes;
	
	private Date createdOn;
	
	//@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	private User user; 
	
	@JsonManagedReference(value="blogcomment_movement")
	@OneToMany(fetch=FetchType.EAGER,mappedBy="blog",cascade=CascadeType.ALL)
	private Set<BlogComments> blogComments = new HashSet<BlogComments>();

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}	

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<BlogComments> getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(Set<BlogComments> blogComments) {
		this.blogComments = blogComments;
	}

	
}
