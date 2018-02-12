package com.routecommon.model.transit;

import java.io.Serializable;

import com.routecommon.util.CommonUtil;


public class LocationCorrectionParam implements Serializable{
	public double getBlockSizeFactor() {
		return blockSizeFactor;
	}

	public double getLatitudeDegPerBlock() {
		return latitudeDegPerBlock;
	}

	public double getLongitudedegPerBlock() {
		return longitudedegPerBlock;
	}
	
	public double getBlockSize() {
		return blockSize;
	}

	private double blockSizeFactor;
	private double latitudeDegPerBlock;
	private double longitudedegPerBlock;
	private double blockSize;
	
	public LocationCorrectionParam(double blockSizeFactor) {
		this.blockSizeFactor = blockSizeFactor;
		this.latitudeDegPerBlock = CommonUtil.LATITUDEDEGPER100 * blockSizeFactor;
		this.longitudedegPerBlock = CommonUtil.LONGITUDEDEGPER100 * blockSizeFactor;
		this.blockSize = CommonUtil.BASICBLOCKSIZE * blockSizeFactor;
	}
}
