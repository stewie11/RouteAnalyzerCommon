package com.routecommon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.routecommon.model.transit.Location;

public class TransitRequestDTO {

	public Integer getETAToPos() {
		return ETAToPos;
	}

	public void setETAToPos(Integer eTAToPos) {
		ETAToPos = eTAToPos;
	}

	public Integer getETAfromPos() {
		return ETAfromPos;
	}

	public void setETAfromPos(Integer eTAfromPos) {
		ETAfromPos = eTAfromPos;
	}

	public Location getPosition() {
		return position;
	}

	public void setPosition(Location position) {
		this.position = position;
	}
	
	public Double getBlockSizeFactor() {
		return blockSizeFactor;
	}

	public void setBlockSizeFactor(Double blockSizeFactor) {
		this.blockSizeFactor = blockSizeFactor;
	}
	
	@JsonProperty("blockSizeFactor")
	private Double blockSizeFactor;
	
	@JsonProperty("ETAto")
	private Integer ETAToPos;

	@JsonProperty("ETAfrom")
	private Integer ETAfromPos;

	@JsonProperty("position")
	private Location position;
}
