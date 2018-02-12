package com.routecommon.model.transit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxiDetail implements Serializable{

 	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getKmPrice() {
		return kmPrice;
	}

	public void setKmPrice(int kmPrice) {
		this.kmPrice = kmPrice;
	}

	public int getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@JsonProperty("desc")
 	private String desc;
 	
 	@JsonProperty("km_price")
 	private int kmPrice;
 	
 	@JsonProperty("start_price")
 	private int startPrice;
 	
 	@JsonProperty("total_price")
 	private int totalPrice;
}
