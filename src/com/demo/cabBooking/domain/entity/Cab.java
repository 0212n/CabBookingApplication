package com.demo.cabBooking.domain.entity;

public class Cab implements Vehicle {
	
	Location cabLocation ;
	
	String modelName;
	String regNo ;
	
	public Cab(String modelName, String regNo) {
		// TODO Auto-generated constructor stub
		this.modelName = modelName ;
		this.regNo = regNo ;
		
	}
	
	public Location getCabLocation() {
		return cabLocation;
	}

	public void setCabLocation(Location cabLocation) {
		this.cabLocation = cabLocation;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	

	

}
