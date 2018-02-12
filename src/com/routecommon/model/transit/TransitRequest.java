package com.routecommon.model.transit;

import java.io.Serializable;

public class TransitRequest implements Serializable{
	public Location getOriLocation() {
		return oriLocation;
	}

	public void setOriLocation(Location oriLocation) {
		this.oriLocation = oriLocation;
	}

	public Location getDestLocation() {
		return destLocation;
	}

	public void setDestLocation(Location destLocation) {
		this.destLocation = destLocation;
	}

	public String getCoordType() {
		return coordType;
	}

	public void setCoordType(String coordType) {
		this.coordType = coordType;
	}

	public int getTactics_incity() {
		return tactics_incity;
	}

	public void setTactics_incity(int tactics_incity) {
		this.tactics_incity = tactics_incity;
	}

	public int getTactics_intercity() {
		return tactics_intercity;
	}

	public void setTactics_intercity(int tactics_intercity) {
		this.tactics_intercity = tactics_intercity;
	}

	public int getTransTypeIntercity() {
		return transTypeIntercity;
	}

	public void setTransTypeIntercity(int transTypeIntercity) {
		this.transTypeIntercity = transTypeIntercity;
	}

	public String getRetCoordtype() {
		return retCoordtype;
	}

	public void setRetCoordtype(String retCoordtype) {
		this.retCoordtype = retCoordtype;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	private Location oriLocation;
	private Location destLocation;
	private String coordType;//默认为bd09ll。允许的值为bd09ll（百度经纬度坐标）；gcj02（国测局加密坐标）；wgs84（gps 设备获取的坐标）
	
	private int tactics_incity;	//市内公交换乘策略0 推荐；1 少换乘；2 少步行；3 不坐地铁；4 时间短；5 地铁优先
	
	private int tactics_intercity;	//跨城公交换乘策略 0:时间短；1 出发早；2 价格低；
	private int transTypeIntercity;	//跨城交通方式策略 0:火车优先；1:飞机优先；2:大巴优先；
	private String retCoordtype;
	
	private String output;
	private int pageSize;
	private int pageIndex;
	
	private String callback;
}
