package com.kkazmierczyk.goeurotest.model;

/**
 * The position object. We are not checking if latitude and longitude is valid
 * for now. This might be future enhancement if such function is necessary
 */
public class Position {

	final double latitude;
	final double longitude;

	public Position(double latitude, double longintude) {
		this.latitude = latitude;
		this.longitude = longintude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

}
