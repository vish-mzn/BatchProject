package com.objectified.model;
import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
public class BatchModel {

	private String id;
	
	private Date date;
	private int weeks;
	public String status;
    private CourseModel course;
    private int size;
	public BatchModel() 
	{
		super();
	}
  /*  public BatchModel(String id, Course course, Date date, int weeks,String status) 
	{
		super();
		this.id = id;
		this.course = courseId;
		this.date = date;
		this.weeks = weeks;
		this.status=status;
	}*/
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



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	public CourseModel getCourse() {
		return course;
	}

	public void setCourse(CourseModel course) {
		this.course = course;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "BatchModel [id=" + id + ", date=" + date + ", weeks=" + weeks + ", status=" + status + ", course="
				+ course + ", size=" + size + "]";
	}
	
	
}
