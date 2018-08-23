package com.syg.manage.util;

import java.math.BigDecimal;

import com.syg.manage.model.entity.ShDate;

public class MbValid {
	private static MbValid instance;
	public static MbValid instance() {
		if (instance==null) {
			instance = new MbValid(); 
		}
		return instance;
	}
	public static boolean str(String str){
		if (str==null || str.trim().length()<=0) {
			return false;
		}
		return true;
	}
	
	public static boolean shDateBegin(ShDate shDate){
		if (shDate==null || shDate.getBegin()==null) {
			return false;
		}
		return true;
	}
	
	public static boolean shDateEnd(ShDate shDate){
		if (shDate==null || shDate.getEnd()==null) {
			return false;
		}
		return true;
	}
	
	public static boolean noZero(Integer integer){
		if (integer==null || integer==0) {
			return false;
		}
		return true;
	}
	
	public static boolean noZero(BigDecimal bigDecimal){
		if (bigDecimal==null || bigDecimal.compareTo(new BigDecimal("0"))==0) {
			return false;
		}
		return true;
	}
	
	public static boolean isBool(Integer integer){
		if (integer==null || integer<0) {
			return false;
		}
		return true;
	}
	
}
