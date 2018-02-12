package com.routecommon.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.routecommon.model.transit.Location;

public class TransitResultCacheDTO implements Serializable {

	public Integer getTimeToPos() {
		return timeToPos;
	}

	public void setTimeToPos(Integer timeToPos) {
		this.timeToPos = timeToPos;
	}

	public Integer getTimeFromPos() {
		return timeFromPos;
	}

	public void setTimeFromPos(Integer timeFromPos) {
		this.timeFromPos = timeFromPos;
	}

	public Location getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(Location fromLocation) {
		this.fromLocation = fromLocation;
	}

	public Location getToLocation() {
		return toLocation;
	}

	public void setToLocation(Location toLocation) {
		this.toLocation = toLocation;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	@JsonProperty("timeToPos")
	private Integer timeToPos;

	@JsonProperty("timeFromPos")
	private Integer timeFromPos;

	@JsonProperty("fromLocation")
	private Location fromLocation;
	
	@JsonProperty("toLocation")
	private Location toLocation;
	
	@JsonProperty("finish")
	private boolean finish;
}
