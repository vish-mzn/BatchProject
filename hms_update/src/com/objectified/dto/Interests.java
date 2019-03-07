package com.objectified.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interests 
{
	@Id
	private int id;
	private User user;
	private Course course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
