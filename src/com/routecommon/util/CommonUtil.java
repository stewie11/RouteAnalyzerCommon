package com.routecommon.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peertopark.java.geocalc.Coordinate;
import com.peertopark.java.geocalc.DegreeCoordinate;
import com.peertopark.java.geocalc.EarthCalc;
import com.peertopark.java.geocalc.Point;
import com.routecommon.model.transit.Location;


public class CommonUtil {
	public static final String RESULTPAGESIZE = "10";
	public static final String HOST = "http://api.map.baidu.com";
	public static final List<String> AK = new ArrayList<String>(){{add("CpDYQzGctVkqks2dY69XyeIftNwoZIk3");add("GM2dTDaG3MLXZbUcl21Qo3pTYP37NFI8");}};
	public static final List<String> SK = new ArrayList<String>(){{add("IgjAxPKNhwYZIBfampQtp79Y2goGeWWt");add("gvzsrh7SGMd9vpSQiTtxGILrm6hEWjQd");}};

	public static final String SERVICE= "/direction/v2/transit?";//"/geocoder/v2/?"
	public static final double BASICBLOCKSIZE = 100.0;
	public static final double BAIDUWALKINGSPEED = 1.251;
	public static final double LONGITUDEDEGPER100 = 0.0010340;//  0.0010406
	public static final double LATITUDEDEGPER100 = 0.0009009;
	// 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	// 对Map内所有value作utf8编码，拼接返回结果
	public static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
		StringBuffer queryString = new StringBuffer();
		for (Entry<?, ?> pair : data.entrySet()) {
			queryString.append(pair.getKey() + "=");
			queryString.append(URLEncoder.encode((String) pair.getValue(),
					"UTF-8") + "&");
		}
		if (queryString.length() > 0) {
			queryString.deleteCharAt(queryString.length() - 1);
		}
		return queryString.toString();
	}
	
	public static <T> T jsonStringToObject(String jsonString, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    return mapper.readValue(jsonString, clazz);
	}
	
	public static double caculateDistance(Location location1, Location location2) {
		Coordinate lat = new DegreeCoordinate(location1.getLatitude());
		Coordinate lng = new DegreeCoordinate(location1.getLongitude());
		Point point1 = new Point(lat, lng);
		lat = new DegreeCoordinate(location2.getLatitude());
		lng = new DegreeCoordinate(location2.getLongitude());
		Point point2 = new Point(lat, lng);
		return EarthCalc.getDistance(point1, point2);
	}
	
	public static double roundHalf(double f, int newScale) {
		BigDecimal b = new BigDecimal(f);
		return b.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
