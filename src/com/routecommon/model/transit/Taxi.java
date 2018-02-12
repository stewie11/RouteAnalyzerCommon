package com.routecommon.model.transit;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Taxi implements Serializable{

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<TaxiDetail> getTaxiDetail() {
		return taxiDetail;
	}

	public void setTaxiDetail(List<TaxiDetail> taxiDetail) {
		this.taxiDetail = taxiDetail;
	}

	@JsonProperty("distance")
	private int distance;
	
	@JsonProperty("duration")
	private int duration;
	
	@JsonProperty("remark")
	private String remark;
	
	@JsonProperty("detail")
	private List<TaxiDetail> taxiDetail;
}
