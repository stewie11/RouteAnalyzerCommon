package com.routecommon.common;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.routecommon.model.transit.CityRange;
import com.routecommon.model.transit.Location;

public class Constants {

	public static final List<CityRange> cityRangeList = new ArrayList<>();
	static{
		cityRangeList.add(new CityRange(new Location(30.387, 120.04879),  new Location(30.097, 120.39999), "Hangzhou"));
		cityRangeList.add(new CityRange(new Location(31.34887, 121.15192),  new Location(31.017195, 121.96082), "Shanghai"));
		//cityRangeList.add(new CityRange(new Location(31.34887, 121.15192),  new Location(30.892824, 121.96082), "Shanghai"));
		cityRangeList.add(new CityRange(new Location(40.02707, 116.21914),  new Location(39.788863, 116.557196), "BeiJing"));
		cityRangeList.add(new CityRange(new Location(31.433703, 120.484444),  new Location(31.226422, 120.789149), "Suzhou"));
		cityRangeList.add(new CityRange(new Location(32.170027, 118.574431),  new Location(31.922241, 118.932029), "Nanjing"));
		cityRangeList.add(new CityRange(new Location(24.561498, 118.024309),  new Location(24.429705, 118.260599), "Xiameng"));
	}
}