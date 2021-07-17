package com.demo.cabBooking.util;

public class RiderNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getExceptionMessage() {
		return "Rider Not found" ;
	}

}
