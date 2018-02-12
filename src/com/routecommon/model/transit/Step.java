package com.routecommon.model.transit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Step implements Serializable{
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Location getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	public Location getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	@JsonProperty("distance")
	private int distance;
	
	@JsonProperty("duration")
	private int duration;
	
	@JsonProperty("instructions")
	private String instructions;
	
	@JsonProperty("path")
	private String path;
	
	@JsonProperty("start_location")
	private Location startLocation;
	
	@JsonProperty("end_location")
	private Location endLocation;
	
	@JsonProperty("vehicle_info")
	private VehicleInfo vehicleInfo;
/*	public List<StepDetail> getStepDetails() {
		return stepDetails;
	}

	public void setStepDetails(List<StepDetail> stepDetails) {
		this.stepDetails = stepDetails;
	}

	private List<StepDetail> stepDetails;*/
}
