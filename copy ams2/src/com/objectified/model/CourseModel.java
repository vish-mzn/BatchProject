package com.objectified.model;

import java.util.ArrayList;
import java.util.List;

import com.objectified.dto.Batch;

public class CourseModel {

	private int id;
	private String course_name;
	private String status;
	private List<BatchModel> listBatch = new ArrayList<BatchModel>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<BatchModel> getListBatch() {
		return listBatch;
	}

	public void setListBatch(List<BatchModel> listBatch) {
		this.listBatch = listBatch;
	}
	
	

}
