package com.routecommon.model.transit;

import java.io.Serializable;

public class CityRange implements Serializable{
	
	public Location getNorthWestCorner() {
		return northWestCorner;
	}
	public void setNorthWestCorner(Location northWestCorner) {
		this.northWestCorner = northWestCorner;
		cityCenter = new Location((northWestCorner.getLatitude()+southEestCorner.getLatitude())/2.0, (southEestCorner.getLongitude()+northWestCorner.getLongitude())/2.0);
	}
	public Location getSouthEestCorner() {
		return southEestCorner;
	}
	public void setSouthEestCorner(Location southEestCorner) {
		this.southEestCorner = southEestCorner;
		cityCenter = new Location((northWestCorner.getLatitude()+southEestCorner.getLatitude())/2.0, (southEestCorner.getLongitude()+northWestCorner.getLongitude())/2.0);
	}
	public Location getCityCenter() {
		return cityCenter;
	}
	public String getCityName() {
		return cityName;
	}
	
	private Location northWestCorner;
	private Location southEestCorner;
	private Location cityCenter;
	private String cityName = "Hangzhou";
	
	public CityRange (Location northWestCorner, Location southEestCorner) {
		this.northWestCorner = northWestCorner;
		this.southEestCorner = southEestCorner;
		cityCenter = new Location((northWestCorner.getLatitude()+southEestCorner.getLatitude())/2.0, (southEestCorner.getLongitude()+northWestCorner.getLongitude())/2.0);
	}
	public CityRange (Location northWestCorner ,Location southEestCorner, String cityName) {
		this.northWestCorner = northWestCorner;
		this.southEestCorner = southEestCorner;
		cityCenter = new Location((northWestCorner.getLatitude()+southEestCorner.getLatitude())/2.0, (southEestCorner.getLongitude()+northWestCorner.getLongitude())/2.0);
		this.cityName = cityName;
	}
}
