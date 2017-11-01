package com.niit.CollaborationBackEnd.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Entity
@Table(name="C_USER_PROFILE")
public class UserProfile extends BaseDomain{
@Lob
private String qualification;

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int UserProfileId;

private String workExperience;

private String hobby;

@JsonBackReference(value="userprofile_movement")
@OneToOne(cascade=CascadeType.PERSIST)
private User user;

public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getWorkExperience() {
	return workExperience;
}
public void setWorkExperience(String workExperience) {
	this.workExperience = workExperience;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
