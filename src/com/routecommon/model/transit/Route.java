package com.routecommon.model.transit;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route implements Serializable{	
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


/*	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}*/

	@JsonProperty("distance")
	private int distance;
	
	@JsonProperty("duration")
	private int duration;

	public List<RoutePriceDetail> getPriceDetailList() {
		return priceDetailList;
	}

	public void setPriceDetailList(List<RoutePriceDetail> priceDetailList) {
		this.priceDetailList = priceDetailList;
	}

	@JsonProperty("price_detail")
	private List<RoutePriceDetail> priceDetailList;

	public List<List<Step>> getSteps() {
		return steps;
	}

	public void setSteps(List<List<Step>> steps) {
		this.steps = steps;
	}


	@JsonProperty("steps")
	private List<List<Step>> steps;
}
