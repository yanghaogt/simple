package com.syg.manage.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xalan.xsltc.runtime.Hashtable;

import com.alibaba.fastjson.JSONObject;
/**
	Map:{3=c, 2=b, 1=a}
	List:[1, 2, 3]
	Json:{"3":"c","2":"b","1":"a"}
	Json数组:[{"3":"c"},{"3":"b"},{"3":"a"}]
	二维数组:[[1111,111,111],[121,121,121]]
*/
public class DataType {
	
	private static void json(){
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(6);
		//覆盖(同map);可以用来修改数组中对应的数据
		JSONObject json = new JSONObject();
		json.put("1", "a");
		json.put("2", "b");
		json.put("3", "c");
		json.put("1",list);
		System.out.println(json);
	};
	
	private static void list(){
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.add(4);
		list1.add(5);
		list1.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);
		list.addAll(list1);
		list.addAll(list2);
		System.out.println(list);
	};
	
	private static void map(){
		Map<Integer, String> retMap = new HashMap<>();
		retMap.put(1, "新易联 网银");
		retMap.put(2, "支付宝");
		retMap.put(3, "微信");
		retMap.put(4, "财付通");
		System.out.println(retMap.get(4));
		//map遍历方法
		for (String serverUrl : retMap.values()) {  
		    System.out.println("name : " + serverUrl);
		}
		for (Integer key : retMap.keySet()) {
			if (key != -1) {
				System.out.println("name : " + retMap.get(key));  
			}
		}
		
		Hashtable ret2Map = new Hashtable();
	};
	
	public static void strCode() {
		String str = "16小时";
		str=str.trim();
		String str2="";
		if(str != null && !"".equals(str)){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>=48 && str.charAt(i)<=57){
				str2+=str.charAt(i);
				}
			}
		}
		System.out.println(str2);
	}
	
	public static void isEqual() {
		Integer a = 100;
		Integer b = 100;
		System.out.println(a==b);
		Integer c = 1000;
		Integer d = 1000;
		System.out.println(c==d);
	}
	
	public static void main(String[] args) {
		isEqual();
		strCode();
		json();
		list();
		map();
	}
}
