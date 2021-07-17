package com.demo.cabBooking.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Rider extends User {
	
	List<Ride> rides;
	
	RiderStatus status ;
	
	public Rider(String name, String emailID, String phoneNo) {
		super(name, emailID, phoneNo);
		// TODO Auto-generated constructor stub
		this.rides = new ArrayList<Ride>();
	}

	public List<Ride> getRides() {
		return rides;
	}

	public void addRide(Ride ride) {
		this.rides.add(ride);
	}

	public RiderStatus getStatus() {
		return status;
	}

	public void setStatus(RiderStatus status) {
		this.status = status;
	}

	

}
