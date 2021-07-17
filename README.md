# CabBookingApplication
Low level design for Cab booking platform like Ola/Uber.

## CAB BOOKING PROBLEM
 
### Problem Statement
We want to build a cab booking platform to allow a rider to book a cab.
Details:

	1. The location is represented as a (x, y) coordinate.
	2. Distance between two points (x1, y1) and(x2, y2) is sqrt((x1-x2)^2 + (y1-y2)^2)
	3. Platform has decided upon the maximum distance a driver has to travel to pick up a rider.
	4. A cab has only 1 driver.
	5. Sharing of cab is not allowed between riders
	6. There is a single type of cab
 
Please build an application that exposes following features to riders and drivers.
	
	1. Register a rider.
	2. Register a driver/cab
	3. Update a cab's location
	4. A driver can switch on/off his availability
	5. A rider can book a cab
	6. Fetch history of all rides taken by a rider.
	7. End the Trip
 
Expectation from this round

	1. Demonstrable code is first expectation. To do this, you can choose any interface you are comfortable with - CLI, WebApp, MobileApp, APIs or even simply run the code via Tests or a main method.
	2. Code should be extensible.
	3. Clean professional level code.
	4. Functional Completeness including good modelling.
	5. User Identification but not authentication.
	6. Backend Database is optional. However modelling should be complete.
 
 
### Solution Approach : 
	
	1. Rider and driver are users of the application
	2. Position of a cab can be updated.
	3. Rider can book a cab if the driver is available.
	4. Status of Driver to be saved.
	5. Rides booked by a user to be saved with the rider.
	6. RideManager to take care of booking ride.

Use case Actors ::
	
	1. Rider
	2. Driver


Classes ::

	1. Abstract class -> User 
		name : 
		emailId
		phoneNo
		userID
		
	2. Driver & Rider extends user
	
	3. Driver : 
			Cab Object
			DriverStatus 
			Rides offered
	4. Rider :
			RiderStatus
			Ridestaken

	5. CabBookingApplication : Singleton 
	6. RiderRepository & DriverRepository
	7. Position class.
			int x 
			int y
	8. Vehicle interface 
	9. Cab implements Vehicle.
	10. Ride class : 
		Ride details : 
			StartTime
			endTime
			StartPosition
			EndPosition
			rideAmount 
			Driver 
			Rider
	11. Driver Status enum : AVAILABLE, LOGGEDOUT, LOGGEDIN, DRIVING 
	12. RiderStatus Enum : BOOKING, BOOKED, UNCLEAREDDUES
