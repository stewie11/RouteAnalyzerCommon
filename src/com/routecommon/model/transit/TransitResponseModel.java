package com.routecommon.model.transit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.routecommon.model.ResponseModel;


public class TransitResponseModel extends ResponseModel implements Serializable {
	public TransitResult getTransitResult() {
		return transitResult;
	}

	public void setTransitResult(TransitResult transitResult) {
		this.transitResult = transitResult;
	}

	@JsonProperty("result")
	private TransitResult transitResult;
}
