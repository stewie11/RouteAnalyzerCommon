package com.routecommon.model.transit;
import java.io.Serializable;

public class TransitResponsePairModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public TransitResponseModel getFromTransitResponseModel() {
		return fromTransitResponseModel;
	}

	public void setFromTransitResponseModel(TransitResponseModel fromTransitResponseModel) {
		this.fromTransitResponseModel = fromTransitResponseModel;
	}

	public TransitResponseModel getToTransitResponseModel() {
		return toTransitResponseModel;
	}

	public void setToTransitResponseModel(TransitResponseModel toTransitResponseModel) {
		this.toTransitResponseModel = toTransitResponseModel;
	}

	public boolean isvalidated() {
		return fromTransitResponseModel != null && toTransitResponseModel != null;
	}
	
	public Boolean isFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
	
	private TransitResponseModel fromTransitResponseModel;
	
	private TransitResponseModel toTransitResponseModel;
	


	private Boolean finished = false;
}
