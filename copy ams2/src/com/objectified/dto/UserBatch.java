package com.objectified.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinTable;

@Entity
@Table(name="User_Batch")
public class UserBatch implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@ManyToOne
		@JoinColumn(name ="userID")
		private User user;
		
		@ManyToOne
		private Batch batch;
		
		private String role;
		private String status;
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
		public Batch getBatch() {
			return batch;
		}
		public void setBatch(Batch batch) {
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
		public UserBatch(int id, User user, Batch batch, String role, String status) {
			super();
			this.id = id;
			this.user = user;
			this.batch = batch;
			this.role = role;
			this.status = status;
		}
		public UserBatch() {
			super();
			
		}
		@Override
		public String toString() {
			return "UserBatch [id=" + id + ", user=" + user + ", batch=" + batch + ", role=" + role + ", status="
					+ status + "]";
		}
		
		
}
