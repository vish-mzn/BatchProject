package com.objectified.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.objectified.dto.Batch;

public class UserBatchModel {

	private int id;
	private UserModel user;
	private BatchModel batch;
	private String role;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel us) {
		this.user = us;
	}
	public BatchModel getBatch() {
		return batch;
	}
	public void setBatch(BatchModel batch) {
		this.batch = batch;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserBatchModel(int id, UserModel user, BatchModel batch, String role, String status) {
		super();
		this.id = id;
		this.user = user;
		this.batch = batch;
		this.role = role;
		this.status = status;
	}
	public UserBatchModel() {
		super();
		
	}
	
	
}
