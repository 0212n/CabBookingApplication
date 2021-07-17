package com.demo.cabBooking;

import java.util.Comparator;

import com.demo.cabBooking.domain.entity.Driver;
import com.demo.cabBooking.domain.entity.Location;
import com.demo.cabBooking.domain.util.CabNotRegisteredException;

public class ClosestFromLocationSort implements Comparator<Driver> {
	Location sourceLocation ;

	public ClosestFromLocationSort(Location sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	@Override
	public int compare(Driver d1, Driver d2) {
		// TODO Auto-generated method stub
		try {
			Location l1 = d1.getCab().getCabLocation();
			Location l2 = d2.getCab().getCabLocation() ;
			
			return  Double.compare(l1.getDistance(sourceLocation),  l2.getDistance(sourceLocation)) ;
		} catch (CabNotRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
