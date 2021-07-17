package com.demo.cabBooking.domain.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.demo.cabBooking.domain.entity.Driver;
import com.demo.cabBooking.domain.entity.DriverStatus;
import com.demo.cabBooking.domain.util.DriverAlreadyRegisteredException;
import com.demo.cabBooking.util.DriverNotFoundException;

public class DriverRepository {
	
	public Map<String, Driver> driverIDMap ;
	public DriverRepository() {
		driverIDMap = new HashMap();
	}
	
	public void addDriver(String name, String emailID, String phoneNo) throws DriverAlreadyRegisteredException {
		Driver driver = new Driver(name, emailID, phoneNo) ;
		String driverID = driver.getUserId() ;
		if(driverIDMap.containsKey(driverID)) {
			throw new DriverAlreadyRegisteredException();
		}
		driverIDMap.put(driverID, driver) ;
	}
	
	public Driver getDriver(String driverID) throws DriverNotFoundException {
		if(driverIDMap.containsKey(driverID)) {
			return driverIDMap.get(driverID) ;
		} else {
			throw new DriverNotFoundException();
		}
	}

	public List<Driver> getAllAvailableDrivers() {
		// TODO Auto-generated method stub
		List<Driver> availableDrivers  = new ArrayList<>(); 
		for(Entry<String, Driver> driverMap : driverIDMap.entrySet()) {
			Driver driver = driverMap.getValue();
			if(driver.getStatus() == DriverStatus.AVAILABLE) {
				availableDrivers.add(driver) ;
			}
		}
		return availableDrivers;
	}

	public List<Driver> getDrivers() {
		// TODO Auto-generated method stub
		List<Driver> availableDrivers  = new ArrayList<>(); 
		for(Entry<String, Driver> driverMap : driverIDMap.entrySet()) {
			Driver driver = driverMap.getValue();
			availableDrivers.add(driver) ;
		}
		return availableDrivers;
	}

}
