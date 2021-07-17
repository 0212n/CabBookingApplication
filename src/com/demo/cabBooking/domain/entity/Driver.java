package com.demo.cabBooking.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.demo.cabBooking.domain.util.CabNotRegisteredException;
import com.demo.cabBooking.util.StatusInvalidException;

public class Driver extends User {
	
	DriverStatus status ;
	
	Cab cab;
	List<Ride> ridesOffered ;
	
	public Driver(String name, String emailID, String phoneNo) {
		super(name, emailID, phoneNo);
		// TODO Auto-generated constructor stub
		ridesOffered = new ArrayList() ;
	}

	
	public DriverStatus getStatus() {
		return status;
	}

	public void setStatus(String status) throws StatusInvalidException {
		boolean validStatus = false ;
		for(DriverStatus tempStatus :DriverStatus.values()) {
			if(status.toLowerCase().equals(tempStatus.toString().toLowerCase())) {
				this.status = tempStatus;
				validStatus = true;
			}
		}
		if(!validStatus) {
			throw new StatusInvalidException() ;
		}
		
	}

	public List<Ride> getRidesOffered() {
		return ridesOffered;
	}

	public void setRidesOffered(List<Ride> ridesOffered) {
		this.ridesOffered = ridesOffered;
	}

	

	
	public void addCabDetails(String modelName, String regNo) {
		// TODO Auto-generated method stub
		this.cab = new Cab(modelName, regNo) ;
	}

	public Cab getCab() throws CabNotRegisteredException {
		// TODO Auto-generated method stub
		if(this.cab == null) 
			throw new CabNotRegisteredException() ;
		return this.cab;
	}

	public void addRide(Ride ride) {
		// TODO Auto-generated method stub
		ridesOffered.add(ride);
	}


}
