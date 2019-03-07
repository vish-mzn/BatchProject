package com.objectified.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Batch 
{
	@Id
	private String id;
	private int course_Id;
	private Date date;
	private String status;
	private int weeks;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public int getWeeks() {
		return weeks;
	}
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}
	
	public int getCourse_Id() {
		return course_Id;
	}
	public void setCourse_Id(int course_Id) {
		this.course_Id = course_Id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
