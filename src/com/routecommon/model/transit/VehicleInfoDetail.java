package com.routecommon.model.transit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleInfoDetail implements Serializable{
	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public String getOnStation() {
		return onStation;
	}

	public void setOnStation(String onStation) {
		this.onStation = onStation;
	}

	public String getOffStation() {
		return offStation;
	}

	public void setOffStation(String offStation) {
		this.offStation = offStation;
	}

	public int getStopNum() {
		return stopNum;
	}

	public void setStopNum(int stopNum) {
		this.stopNum = stopNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@JsonProperty("first_time")
	private String firstTime;
	
	@JsonProperty("last_time")
	private String lastTime;

	@JsonProperty("on_station")
	private String onStation;
	
	@JsonProperty("off_station")
	private String offStation;
	
	@JsonProperty("stop_num")
	private int stopNum;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	private int type;
}
