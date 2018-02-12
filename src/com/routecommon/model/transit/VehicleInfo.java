package com.routecommon.model.transit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleInfo implements Serializable{
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public VehicleInfoDetail getDetail() {
		return detail;
	}

	public void setDetail(VehicleInfoDetail detail) {
		this.detail = detail;
	}

	@JsonProperty("type")
	private int type;//1 火车； 2 飞机； 3 公交； 4 驾车；5 步行；6 大巴
	
	@JsonProperty("detail")
	private VehicleInfoDetail detail;//火车、飞机、大巴、公交4 种交通方式的这个字段有各自的格式，参见下面的文档。步行和驾车为null
}
