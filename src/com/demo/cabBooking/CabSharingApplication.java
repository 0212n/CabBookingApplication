package com.demo.cabBooking;

import java.util.List;

import com.demo.cabBooking.domain.entity.Cab;
import com.demo.cabBooking.domain.entity.Driver;
import com.demo.cabBooking.domain.entity.Location;
import com.demo.cabBooking.domain.entity.Ride;
import com.demo.cabBooking.domain.entity.Rider;
import com.demo.cabBooking.domain.repo.DriverRepository;
import com.demo.cabBooking.domain.repo.RiderRepository;
import com.demo.cabBooking.domain.util.CabNotRegisteredException;
import com.demo.cabBooking.domain.util.DriverAlreadyRegisteredException;
import com.demo.cabBooking.domain.util.RiderAlreadyRegisteredException;
import com.demo.cabBooking.service.BookingService;
import com.demo.cabBooking.util.DriverNotAvailableException;
import com.demo.cabBooking.util.DriverNotFoundException;
import com.demo.cabBooking.util.RiderNotFoundException;
import com.demo.cabBooking.util.StatusInvalidException;


public class CabSharingApplication {
	RiderRepository riders ;
	public DriverRepository drivers ;
	private static CabSharingApplication instance ;
	
	private CabSharingApplication() {
		riders = new RiderRepository();
		drivers = new DriverRepository();
	}
	
	public static CabSharingApplication getInstance() {
		if(instance == null) {
			instance = new CabSharingApplication();
		}
		return instance ;
	}
	
	public String registerRider(String name, String phoneNo, String emailId) {
		
		try {
			riders.addRider(name, emailId, phoneNo);
		} catch (RiderAlreadyRegisteredException e) {
			// TODO Auto-generated catch block
			return e.getMessage() ;
		}
		return "Rider added successfully";
	}
	
	public String registerDriver(String name, String phoneNo, String emailId) {
		try {
			drivers.addDriver(name, emailId, phoneNo);
		} catch (DriverAlreadyRegisteredException e) {
			// TODO Auto-generated catch block
			return e.getMessage() ;
		}
		return "Driver added successfully";
		
	}
	
	public String getAllDrivers() {
		List<Driver> availableDriver = drivers.getDrivers() ;
		StringBuffer output = new StringBuffer();
		for(Driver driver : availableDriver) {
			output.append(driver.getName()) ;
			output.append("\n") ;
		}
		return output.toString();
		
	}
	
	public String registerCab(String driverId, String modelName, String regNo) {
		try {
			Driver driver = drivers.getDriver(driverId);
			driver.addCabDetails(modelName, regNo) ;
		} catch (DriverNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage() ;
		}
		return "Cab registered successfully";
		
	}
	
	public String updateAvailabilty(String driverId, String status) {
		try {
			Driver driver = drivers.getDriver(driverId);
			try {
				driver.setStatus(status);
			} catch (StatusInvalidException e1) {
				// TODO Auto-generated catch block
				return e1.getMessage();
			} ;
		} catch (DriverNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage() ;
		}
		return "Driver status updated successfully";
		
		
	}
	
	public String updateCabLocation(String driverId, int x, int y) {
		try {
			Driver driver = drivers.getDriver(driverId);
			try {
				Cab cab = driver.getCab();
				cab.setCabLocation(new Location(x, y)) ;
			} catch (CabNotRegisteredException e1) {
				// TODO Auto-generated catch block
				return e1.getMessage();
			} ;
		} catch (DriverNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage() ;
		}
		return "Cab location updated successfully";
		
		
	}
	
	public String bookRide(String riderId, int x, int y) {
		try {
			Rider rider = riders.getRider(riderId);
			try {
				String rideDetails = BookingService.bookRide(rider, x, y) ;
				return rideDetails ;
			} catch (DriverNotAvailableException e1) {
				// TODO Auto-generated catch block
				return e1.getMessage();
			}
		} catch (RiderNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage() ;
		}
		
	}
	
	public String getAllRides(String riderId) {
		try {
			Rider rider = riders.getRider(riderId);
			List<Ride> rideHistory = rider.getRides();
			StringBuffer ridesDetails = new StringBuffer() ;
			
			for(Ride ride : rideHistory) {
				ridesDetails.append(ride.getRideDetails()) ;
				ridesDetails.append("\n") ;
			}
			return ridesDetails.toString() ;
		} catch (RiderNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage() ;
		}
		
	}
}
