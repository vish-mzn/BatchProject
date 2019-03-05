package com.objectified.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class UserModel {
		private String userID;
		private String username;
		private String password;
		private String status;
		private List<UserBatchModel> listBatch = new ArrayList<UserBatchModel>();

		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<UserBatchModel> getListBatch() {
			return listBatch;
		}

		public void setListBatch(List<UserBatchModel> listBatch) {
			this.listBatch = listBatch;
		}

		public UserModel() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", status=" + status
					+ ", listBatch=" + listBatch + "]";
		}	

}
