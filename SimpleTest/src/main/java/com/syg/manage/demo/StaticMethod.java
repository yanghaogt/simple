package com.syg.manage.demo;

import java.util.HashMap;
import java.util.Map;

public class StaticMethod {

	private static Map<Integer,String> map = new HashMap<>();
	
	static {//静态块
		System.out.println("static block "+map.size());
    }
	
	public static void addPkgHandle(int one,String name) {
		map.put(one, name);
	}
	
}
