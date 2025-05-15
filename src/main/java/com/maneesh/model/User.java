package com.maneesh.model;

import java.util.Date;

public class User {
	 public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	private int userId;
	 private String userName;
	 private String password;
	 private String email;
	 private String phone;
	 private String address;
	 private String role;
	 private Date createdDate;
	 private Date lastLoginDate;
	 
	 public User() {
		
	}

	public User(int userId, String userName, String password, String email, String phone, String address, String role,
			Date createdDate, Date lastLoginDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", role=" + role + "]";
	}

	public User(String userName, String password, String email, String phone, String address, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}

	public User(int userId, String userName, String password, String email, String phone, String address, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}

	public User(int int1, String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
