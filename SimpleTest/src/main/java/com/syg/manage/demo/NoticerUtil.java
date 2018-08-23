package com.syg.manage.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticerUtil {
	
	private static Logger log = LoggerFactory.getLogger(NoticerUtil.class);
	
	/**
	 * 同步发送请求
	 */
	public static void syncCouponLog(String url, String parmas){
		try{
			ExecutorService executor = Executors.newSingleThreadExecutor();
			NoticerThread runnable = new NoticerThread(url, parmas);
			executor.submit(runnable);
			//条件下shutdown
			//executor.shutdown();
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		Long s1 = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			syncCouponLog("192.168.1.1",String.valueOf(i));
		}
		System.out.println("total use:"+(System.currentTimeMillis() - s1));
	}
	
}
