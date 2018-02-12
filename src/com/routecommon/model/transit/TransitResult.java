package com.routecommon.model.transit;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransitResult implements Serializable{
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi (Taxi taxi) {
		this.taxi = taxi;
	}

	@JsonProperty("total")
	private int total;
	
	@JsonProperty("routes")
	private List<Route> routes;

	@JsonProperty("taxi")
	private Taxi taxi;
	
	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	@JsonProperty("origin")
	private Origin origin;
	
	@JsonProperty("destination")
	private Destination destination;
}
