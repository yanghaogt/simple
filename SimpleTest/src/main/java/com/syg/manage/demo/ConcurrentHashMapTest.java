package com.syg.manage.demo;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	
	/**
	 * 写的时候会map整个加锁,线程多CPU会达到99%，引起死循环
	 */
	private static HashMap<String, String> map = new HashMap<String, String>(2);
	/**
	 * ConcurrentMap 是线程安全的map,写入的时候只会锁住对应的segment
	 * ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)
	 * concurrencyLevel这个参数就是控制segment数量的。
	 * 通过把整个Map分为N个Segment（类似HashTable），可以提供相同的线程安全，但是效率提升N倍，默认提升16倍
	 */
	private static ConcurrentHashMap<Integer, Integer> conMap = new ConcurrentHashMap<Integer, Integer>();
	
	public static void mapTest(){
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        for (int i = 0; i < 10000; i++) {
		            new Thread(new Runnable() {
		                @Override
		                public void run() {
		                	conMap.put(UUID.randomUUID().hashCode(), 1);
		                }
		            }, "ftf" + i).start();
		        }
		    }
		}, "ftf").start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(conMap.size());
	}
	
	public static void conMapTest(){
		new Thread("Thread1"){
          @Override  
          public void run() {
          	conMap.put(3, 33);  
          }  
       };  
        
       new Thread("Thread2"){
          @Override  
          public void run() {
          	conMap.put(4, 44);  
          }  
       };  
        
       new Thread("Thread3"){  
          @Override  
          public void run() {  
          	conMap.put(7, 77);  
          }  
       };  
       System.out.println(conMap);
	}
	
	public static void main(String[] args) {
		mapTest();
		conMapTest();
	}
}
