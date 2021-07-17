package com.demo.cabBooking;

public class TestApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CabSharingApplication app = CabSharingApplication.getInstance() ;
		// Register a rider 
		
		System.out.println(app.registerRider("Prashant", "5656565", "prashant"));
		
		// Register a driver 
		System.out.println(app.registerDriver("Some", "phn", "a"));
		
		// Register cab 
		System.out.println(app.registerCab("Some", "suzuki", "KA"));
		
		// Update Availability
		System.out.println(app.updateAvailabilty("Some", "available"));
		
		
		// Update location
		System.out.println(app.updateCabLocation("Some", 4, 6));
		
		// Register a driver 
		System.out.println(app.registerDriver("Rishabh", "phn", "a"));
		
		// Register a driver 
		System.out.println(app.updateAvailabilty("Rishabh", "available"));
		
		// Get all drivers
		System.out.println(app.drivers.driverIDMap.size());
		
		// Book ride
		
		System.out.println(app.bookRide("Prashant",  2, 9));
		
		// 
		System.out.println(app.bookRide("Prashant",  2, 9));
		
		
		// Rides details
		System.out.println(app.getAllRides("Prashant"));
		
		///
		
		

	}

}
