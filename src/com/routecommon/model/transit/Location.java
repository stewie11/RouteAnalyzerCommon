package com.routecommon.model.transit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location implements Serializable{

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("lat")
	private double latitude;

	@JsonProperty("lng")
	private double longitude;
	
	public Location(){

	}

	public Location(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public int hashCode() {
		String asString = String.valueOf(latitude)+String.valueOf(longitude);
		int hashcode = asString.hashCode();
		return hashcode;
	}
	 @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Location &&((Location)obj).getLatitude() == this.latitude && ((Location)obj).getLongitude() == this.longitude;
    }
}
