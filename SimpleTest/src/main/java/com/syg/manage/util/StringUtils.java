package com.syg.manage.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringUtils {

	private static final String split = " , ";

	private static final String equal = "=";
	
	private static final String left_bracket = "[";
	
	private static final String right_bracket = "]";
	
	public static String objectToString(Object object){
		Class clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		if(fields == null || fields.length < 1){
			throw new RuntimeException(object + " no field .");
		}
		StringBuffer toString = new StringBuffer(left_bracket);
		for (Field field : fields) {
			try {
				Method method = clazz.getDeclaredMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
				method.setAccessible(true);
				toString.append(field.getName()).append(equal).append(method.invoke(object)).append(split);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		toString.append(right_bracket);
		return toString.toString().replace(" , ]", "]");
	}
	
	
	public static String parseString(Object o){
		if(o == null) return "";
		return String.valueOf(o);
	}

	public static boolean checkNull(String str){
		if(str == null) return true;
		if(str.trim().length() == 0) return true;
		return false;
	}
	public static String parseString(String s){
		if(s == null || "".equals(s)) return "0";
		return s;
	}
}
