package com.syg.manage.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoticerThread implements Runnable{
	private static Logger log = LoggerFactory.getLogger(NoticerThread.class);
	private String url;
	private String parmas;

	
	public NoticerThread(String url, String parmas) {
		this.url = url;
		this.parmas = parmas;
	}
	
	@Override
	public void run() {
		Long l1 = System.currentTimeMillis();
		try {
			log.info("run:"+parmas);
			log.info("url:"+url);
			log.info("parmas:"+parmas);
			Thread.sleep(5000);
			log.info("use :"+(System.currentTimeMillis() - l1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParmas() {
		return parmas;
	}

	public void setParmas(String parmas) {
		this.parmas = parmas;
	}
	
}
