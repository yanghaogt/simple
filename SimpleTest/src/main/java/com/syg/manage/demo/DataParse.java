package com.syg.manage.demo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.syg.manage.model.entity.FixPayInfo;

public class DataParse {
	
	/** 解析数组 */
	public static void parseArray(String text) {
		List<FixPayInfo> cdList = new ArrayList<>();
		String[] array= text.split(",");
		for (int i = 0; i < array.length; i++){
			String str = array[i].replace("[", "");
			String str2	= str.replace("]", "");
			System.out.print(str2+"\t");
		}
	}
	
	/** 解析Json数组 */
	public static List<FixPayInfo> parseJsonArray(String text) {
		List<FixPayInfo> list = new ArrayList<>();
		JSONArray jo = JSON.parseArray(text);
		for (int i = 0; i < jo.size(); i++) {
			list.add(jo.getObject(i, FixPayInfo.class));//给对象赋值
		}
		System.out.println("\n"+list);
		return list;
	}
	
	/** 解析Json对象 */
	public static void parseJsonObject(String text){
		JSONObject json = JSONObject.parseObject(text);
		System.out.println(json);
	}
	
	/** 解析json对象数组*/
	public static void parseJsonObjectArray(String text){
		JSONObject json = JSONObject.parseObject(text);
		JSONArray jsonArray = json.getJSONArray("employees");
		List<FixPayInfo> list = new ArrayList<>();
		for (int i = 0; i < jsonArray.size(); i++) {
			list.add(jsonArray.getObject(i, FixPayInfo.class));
		}
	}
	
	/** Json转对象 */
	public static List<FixPayInfo> parseList(String text) {
		List<FixPayInfo> fixPayList = new ArrayList<>();
		JSONArray jo = JSON.parseArray(text);
		for (int i = 0; i < jo.size(); i++) {
			fixPayList.add(jo.getObject(i, FixPayInfo.class));
		}
		return fixPayList;
	}
	
	/*
	@Override递归算法(组织架构)
	public List<Organization> getOrganization() {
		List<Organization> subDept = organizationMapper.selectByParentId(new Long("1"));
		getSubDeptmentTreeNode(subDept);
		return subDept;
	}
	public List<Organization> getSubDeptmentTreeNode(List<Organization> subDept){
		for (Organization organization : subDept) {
			List<Organization> subList = organizationMapper.selectByParentId(organization.getId());
			if (!subList.isEmpty()) {
				organization.setSubList(subList);
				getSubDeptmentTreeNode(subList);
			}
		}
		return subDept;
	}
	*/
	
	public static void main(String[] args) {
		parseArray("[[1111,111,111],[121,121,121]]");
		parseJsonArray("[{\"diyId\":\"4\",\"price\":3,\"productCode\":\"3\"}]");
		parseJsonObject("{\"3\":\"c\",\"2\":\"b\",\"1\":\"a\"}");
		parseJsonObjectArray("{\"employees\":[{\"diyId\":\"4\",\"price\":3,\"productCode\":\"3\"},{\"diyId\":\"5\",\"price\":4,\"productCode\":\"5\"}]}");
		
		//json
		String fixPayInfoList = "[{\"price\":\"1\",\"diyId\":\"11\",\"productCode\":\"1\"},{\"price\":\"2\",\"diyId\":\"2\",\"productCode\":\"2\"},{\"price\":\"3\",\"diyId\":\"3\",\"productCode\":\"3\"}]";
		List<FixPayInfo> fixPayInfos = parseList(fixPayInfoList);
		for (FixPayInfo fixPayInfo : fixPayInfos) {
			System.out.println(fixPayInfo.getPrice()+":"+fixPayInfo.getDiyId()+":"+fixPayInfo.getProductCode());
		}
	}
	
}
