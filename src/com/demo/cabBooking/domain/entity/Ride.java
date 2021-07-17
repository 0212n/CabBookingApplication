package com.demo.cabBooking.domain.entity;

import java.util.Date;

public class Ride {
	
	String rideID;
	Date startTime;
	Date endTime ;
	Location startLocation ;
	
	RideStatus status ;
	
	double rideAmount ;
	
	Driver driver ;
	Rider rider ;
	
	public Ride(Driver driver, Rider rider) {
		this.driver = driver ;
		this.rider = rider;
		this.status = RideStatus.BOOKED ;
		//this.rideId
	}
	
	
	public String getRideID() {
		return rideID;
	}
	public void setRideID(String rideID) {
		this.rideID = rideID;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Location getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}
	public RideStatus getStatus() {
		return status;
	}
	public void setStatus(RideStatus status) {
		this.status = status;
	}
	public double getRideAmount() {
		return rideAmount;
	}
	public void setRideAmount(double rideAmount) {
		this.rideAmount = rideAmount;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	Location endLocation ;
	
	public Location getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}
	
	
	public String getRideDetails() {
		StringBuffer output = new StringBuffer() ;
		output.append("Ride Status" + status.toString()) ;
		output.append("  Driver Name : " + driver.getName()) ;
		output.append("  Rider Name : " + rider.getName()) ;
		return output.toString();
	}
	

}
