package com.syg.manage.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConver {

	private static void listToArray() {
		List<String> tmp = new ArrayList<String>();
		tmp.add("4");tmp.add("1");tmp.add("3");
		String[] params = tmp.toArray(new String[0]);
		System.out.println(params[0]+""+params[1]+""+params[2]);
	}
	
	private static void arrayToList() {
		String[] arr = new String[] {"1", "2"};
		List<String> list = Arrays.asList(arr);
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	private static void removeNullArray(){
		String[] params = new String[] {"1", "", "", ""};
		List<String> tmp = new ArrayList<String>();
        for(String str:params){
            if(str!=null && str.length()!=0){
                tmp.add(str);
            }
        }
        params = tmp.toArray(new String[0]);
	}
	
	
	
	public static void main(String[] args) {
		listToArray();
		arrayToList();
		removeNullArray();
	}
}
