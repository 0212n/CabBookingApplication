package com.demo.cabBooking.domain.repo;

import java.util.HashMap;
import java.util.Map;

import com.demo.cabBooking.domain.entity.Rider;
import com.demo.cabBooking.domain.util.RiderAlreadyRegisteredException;
import com.demo.cabBooking.util.RiderNotFoundException;

public class RiderRepository {
	
	Map<String, Rider> riderIDMap ;
	public RiderRepository() {
		riderIDMap = new HashMap();
	}
	
	public void addRider(String name, String emailID, String phoneNo) throws RiderAlreadyRegisteredException {
		Rider rider = new Rider(name, emailID, phoneNo) ;
		String riderID = rider.getUserId() ;
		if(riderIDMap.containsKey(riderID)) {
			throw new RiderAlreadyRegisteredException();
		}
		riderIDMap.put(riderID, rider) ;
	}
	
	public Rider getRider(String riderID) throws RiderNotFoundException {
		if(riderIDMap.containsKey(riderID)) {
			return riderIDMap.get(riderID) ;
		} else {
			throw new RiderNotFoundException();
		}
	}

}
