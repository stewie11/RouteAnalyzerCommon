package com.routecommon.util.transit;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.routecommon.common.Constants;
import com.routecommon.model.transit.CityRange;
import com.routecommon.model.transit.Location;
import com.routecommon.model.transit.LocationCorrectionParam;
import com.routecommon.model.transit.Route;
import com.routecommon.model.transit.Step;
import com.routecommon.model.transit.TransitResponseModel;
import com.routecommon.model.transit.TransitResult;
import com.routecommon.util.CommonUtil;

public class TransitUtil {
	
	public static String assembleTransitSchemeRequest(Location oriLocation, Location destLocation, String transitTactics) throws UnsupportedEncodingException{
		 // 计算sn跟参数对出现顺序有关，get请求请使用LinkedHashMap保存<key,value>，该方法根据key的插入顺序排序；post请使用TreeMap保存<key,value>，该方法会自动将key按照字母a-z顺序排序。所以get请求可自定义参数顺序（sn参数必须在最后）发送请求，但是post请求必须按照字母a-z顺序填充body（sn参数必须在最后）。以get请求为例：http://api.map.baidu.com/geocoder/v2/?address=百度大厦&output=json&ak=yourak，paramsMap中先放入address，再放output，然后放ak，放入顺序必须跟get请求中对应参数的出现顺序保持一致。
		Map paramsMap = new LinkedHashMap<String, String>();
		paramsMap.put("origin", oriLocation.getLatitude() + ", " + oriLocation.getLongitude());
		paramsMap.put("destination", destLocation.getLatitude() + ", " + destLocation.getLongitude());
		paramsMap.put("tactics_incity", transitTactics);
		paramsMap.put("page_size", CommonUtil.RESULTPAGESIZE);
	
		Random ra =new Random();
		int index = ra.nextInt(2);
		paramsMap.put("ak", CommonUtil.AK.get(index));

		// 调用下面的toQueryString方法，对LinkedHashMap内所有value作utf8编码，拼接返回结果address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourak
		String paramsStr = CommonUtil.toQueryString(paramsMap);

		// 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接yoursk得到/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourakyoursk
		String wholeStr = new String(CommonUtil.SERVICE + paramsStr );

		// 对上面wholeStr再作utf8编码
		String tempStr = URLEncoder.encode(wholeStr + CommonUtil.SK.get(index), "UTF-8");

		// 调用下面的MD5方法得到最后的sn签名7de5a22212ffaa9e326444c75a58f9a0
		String sn = CommonUtil.MD5(tempStr);

		String requestURI = CommonUtil.HOST + wholeStr +"&sn="+ sn;
		return requestURI;
	}
	
	public static Location getNearestLocation(List<Location> locationList, Location oriLocation) {
		double deviation = Double.MAX_VALUE;
		Location nearestLocation = new Location();
		for(Location targetLocation : locationList) {
			double distance = CommonUtil.caculateDistance(oriLocation, targetLocation);
			if(distance < deviation) {
				//oriI = i;
				//oriJ = j;
				nearestLocation.setLatitude(targetLocation.getLatitude());
				nearestLocation.setLongitude(targetLocation.getLongitude());
				deviation = distance;
			}
		}
		return nearestLocation;
	}
	
	public static CityRange getNearestCityRange(Location location) {
		double nearestDistance = Double.MAX_VALUE;
		CityRange nearestCityRange = Constants.cityRangeList.get(0);
		for(CityRange cityRange : Constants.cityRangeList){
			double distance = CommonUtil.caculateDistance(location, cityRange.getCityCenter());
			if(distance < nearestDistance) {
				nearestDistance = distance;
				nearestCityRange = cityRange;
			}
		}
		return nearestCityRange;
	}
	
	public static List<Location> getDestinationLocationList(CityRange cityRange, LocationCorrectionParam locationCorrectionParam) {
		int maxI,minI,maxJ,minJ;
		int i, j, oriI = Integer.MIN_VALUE, oriJ = Integer.MIN_VALUE;//左下
		i = 0;
		for(double lng = cityRange.getCityCenter().getLongitude(); lng > cityRange.getNorthWestCorner().getLongitude(); --i, lng-=locationCorrectionParam.getLongitudedegPerBlock());
		minI = i;
		i = 0;
		for(double lng = cityRange.getCityCenter().getLongitude(); lng < cityRange.getSouthEestCorner().getLongitude(); ++i, lng+=locationCorrectionParam.getLongitudedegPerBlock());
		maxI = i;
		
		j = 0;
		for(double lat = cityRange.getCityCenter().getLatitude(); lat < cityRange.getNorthWestCorner().getLatitude(); ++j, lat+=locationCorrectionParam.getLatitudeDegPerBlock());
		maxJ = j;
		j = 0;
		for(double lat = cityRange.getCityCenter().getLatitude(); lat > cityRange.getSouthEestCorner().getLatitude(); --j, lat-=locationCorrectionParam.getLatitudeDegPerBlock());
		minJ = j;
		
		List<Location> allLocationList = new LinkedList<>();
		for(i = minI; i <= maxI; ++i) {
			for(j = minJ; j <= maxJ; ++j) {
				Location tempLocation = new Location(cityRange.getCityCenter().getLatitude() + locationCorrectionParam.getLatitudeDegPerBlock() * j, cityRange.getCityCenter().getLongitude() + locationCorrectionParam.getLongitudedegPerBlock() * i);
				tempLocation.setLatitude(CommonUtil.roundHalf(tempLocation.getLatitude(), 6));
				tempLocation.setLongitude(CommonUtil.roundHalf(tempLocation.getLongitude(), 6));
				allLocationList.add(tempLocation);
			}
		}
		return allLocationList;
	}
	public static int getFastRouteDuration(TransitResponseModel transitResponse) {
		//System.out.println(transitResponse);
	    int fastestTime = Integer.MAX_VALUE;
	    Route fastestRoute = null;
	    if(transitResponse != null && transitResponse.getStatus() == 0) {
	    	TransitResult transitResult = transitResponse.getTransitResult();
	    	
	    	if(transitResult != null) {
	    		List<Route> routeList = transitResult.getRoutes();
	    		for(Route route : routeList) {
	    			if(route.getDuration() < fastestTime) {
	    				boolean routeLegal = true;
	    				for(List<Step> stepList : route.getSteps()) {
	    					boolean anyStepLegal = false;
	    					for(Step step:stepList) {
	    						if(step.getVehicleInfo().getType()==5||step.getVehicleInfo().getType() == 3) {
	    							anyStepLegal = true;
	    							break;
	    						}
	    					}
	    					if(!anyStepLegal) {
	    						routeLegal = false;
	    					}
	    				}
	    				if(routeLegal){
		    				fastestRoute = route;
		    				fastestTime = route.getDuration();
	    				}
	    			}
	    		}
	    	}
	    	if(fastestRoute !=null) {
	    		return fastestRoute.getDuration();
	    	}
	    	else if(transitResult.getTaxi() != null) {
	    		return (int)(transitResult.getTaxi().getDistance() / CommonUtil.BAIDUWALKINGSPEED);
	    	}
	    }
	    return fastestTime;
	}
}