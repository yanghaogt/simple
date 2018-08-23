package com.syg.manage.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DateDistinct {

	//1.set集合去重，不打乱顺序
	public static void distSet(){
		 List<String> list  =   new  ArrayList<String>(); 
         list.add("aaa");
         list.add("bbb");
         list.add("aaa");
         list.add("aba");
         list.add("aaa");
         Set set = new  HashSet(); 
         List newList = new  ArrayList(); 
         for (String cd:list) {
            if(set.add(cd)){
                newList.add(cd);
            }
        }
        System.out.println( "去重后的集合： " + newList); 
	}
	
	//2.list集合判断去重
	public static void distList(){
		 List<String> list  =   new  ArrayList<String>(); 
         list.add("aaa");
         list.add("bbb");
         list.add("aaa");
         list.add("aba");
         list.add("aaa");
         List<String> newList = new  ArrayList<String>(); 
         for (String cd:list) {
            if(!newList.contains(cd)){
                newList.add(cd);
            }
        }
         System.out.println( "去重后的集合： " + newList); 
	}
	
	//3.set去重(无序)
	public static void distSetDisd(){
		List<String> list  =   new  ArrayList<String>(); 
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("aba");
        list.add("aaa");
        Set set = new  HashSet();
        List newList = new  ArrayList(); 
        set.addAll(list);
        newList.addAll(set);
        System.out.println( "去重后的集合： " + newList); 
	}
	
	//4.set去重(最简)
	public static void distSetSip(){
		List<String> list  =   new  ArrayList<String>(); 
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("aba");
        list.add("aaa");
        List newList = new ArrayList(new HashSet(list));
        System.out.println( "去重后的集合： " + newList);
	}
	
	public static void main(String[] args) {
		distSet();
		distList();
		distSetDisd();
		distSetSip();
	}
}
