package com.demo.cabBooking.domain.entity;

public class Location implements Comparable<Location>{
	int x;
	int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public double getDistance(Location l) {
		return Math.sqrt(Math.pow(this.x - l.x, 2) + Math.pow(y - l.y,2)) ;
	}

	@Override
	public int compareTo(Location o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
