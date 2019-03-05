package com.objectified.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
public class Batch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private Date date;
	private int weeks;
	private String status;
	@ManyToOne
	private Course course;
	
	
	
	public Batch() 
	{
		
	}
	/*public Batch(String id, Course course, Date date, int weeks,String status) 
	{
		super();
		this.id = id;
		this.course = course;
		this.date = date;
		this.weeks = weeks;
		this.status=status;
	}*/
	/* public Batch (ResultSet resultSet) throws SQLException
	    {
	        this.id = resultSet.getString("id");
	        this.courseId = resultSet.getString("course_id");
	        this.date = resultSet.getDate("begin_date");
	        this.weeks =resultSet.getInt("weeks");
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



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Batch [id=" + id + ", date=" + date + ", weeks=" + weeks + ", status=" + status + ", course=" + course
				+ "]";
	}



	
	

}
