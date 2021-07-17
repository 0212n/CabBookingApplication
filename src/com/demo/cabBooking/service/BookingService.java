package com.demo.cabBooking.service;

import java.util.List;

import com.demo.cabBooking.CabSharingApplication;
import com.demo.cabBooking.ClosestFromLocationSort;
import com.demo.cabBooking.domain.entity.Driver;
import com.demo.cabBooking.domain.entity.Location;
import com.demo.cabBooking.domain.entity.Ride;
import com.demo.cabBooking.domain.entity.Rider;
import com.demo.cabBooking.util.DriverNotAvailableException;
import com.demo.cabBooking.util.StatusInvalidException;

public class BookingService {
	public static Location bookingLocation ;

	public static String bookRide(Rider rider, int x, int y) throws DriverNotAvailableException {
		// TODO Auto-generated method stub
		bookingLocation = new Location(x, y) ;
		
		List<Driver> drivers = BookingService.getAllNearestDrivers(bookingLocation) ;
		if(drivers.size() != 0) {
			Driver nearestDriver = drivers.get(0) ;
			Ride ride = new Ride(nearestDriver, rider) ;
			nearestDriver.addRide(ride);
			try {
				nearestDriver.setStatus("booked");
			} catch (StatusInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rider.addRide(ride);
			return ride.getRideDetails();
		}
		return "No ride booked" ;
	}

	public static List<Driver> getAllNearestDrivers(Location bookingLocation) throws DriverNotAvailableException {
		// TODO Auto-generated method stub
		CabSharingApplication app = CabSharingApplication.getInstance() ;
		List<Driver> drivers = app.drivers.getAllAvailableDrivers();
		if(drivers.size() == 0) {
			throw new DriverNotAvailableException() ;
		}
		drivers.sort(new ClosestFromLocationSort(bookingLocation));
		return drivers;
	}

}
