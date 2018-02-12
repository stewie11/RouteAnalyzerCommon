package com.routecommon.model.transit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Origin implements Serializable{
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@JsonProperty("location")
	private Location location;
}
