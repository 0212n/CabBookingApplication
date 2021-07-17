package com.demo.cabBooking.domain.entity;

public abstract class User {
	
	String name;
	String userId;
	String emailID;
	String phoneNo ;
	
	public User(String name, String emailID, String phoneNo) {
		this.name = name;
		this.emailID = emailID;
		this.phoneNo = phoneNo ;
		this.userId = generateUserID();
	}

	private String generateUserID() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
