package com.niit.CollaborationBackEnd.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name="C_USER_DETAIL")
public class User extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
	
	private String fullName;
	
	@Column(unique=true)
	private String userName;

	private String role;
	
	private String password;
	@Column(unique=true)
	private String emailId;
	
	private char status;
	
	private String gender;
	
	private char isOnline;
	
	private Date birthDay;

	private String address;

	private String mobile;
	
	@JsonManagedReference(value="userprofile_movement")
	@OneToOne(cascade=CascadeType.PERSIST)
	private UserProfile userProfile;
	
//	@JsonManagedReference
//	@OneToMany(fetch=FetchType.EAGER,mappedBy="user", cascade=CascadeType.PERSIST)
//	private Set<Blog> blogs=new HashSet<Blog>();
//	
//	public Set<Blog> getBlogs() {
//		return blogs;
//	}
//
//	public void setBlogs(Set<Blog> blogs) {
//		this.blogs = blogs;
//	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public char getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
