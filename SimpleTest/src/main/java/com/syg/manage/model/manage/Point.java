package com.syg.manage.model.manage;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class Point {

	private Integer id;
	private String point;
	private List<FixPayInfo> fixPayInfo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public List<FixPayInfo> getFixPayInfo() {
		if (point!=null || !"".equals(point)) {
			return parseJsonArray(point);
		}
		return fixPayInfo;
	}
	public void setFixPayInfo(List<FixPayInfo> fixPayInfo) {
		this.fixPayInfo = fixPayInfo;
	}
	
	public static List<FixPayInfo> parseJsonArray(String text) {
		List<FixPayInfo> list = new ArrayList<>();
		JSONArray jo = JSON.parseArray(text);
		for (int i = 0; i < jo.size(); i++) {
			list.add(jo.getObject(i, FixPayInfo.class));//给对象赋值
		}
		return list;
	}
	
}
