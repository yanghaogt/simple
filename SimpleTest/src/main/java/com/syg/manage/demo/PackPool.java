package com.syg.manage.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 打包
 * 使用 static 初始化线程
 * 设置 while true 一直检测，等待放入线程对象，然后执行线程进行打包
 * 使用 BlockingQueue(阻塞队列) 管理线程对象 
 * 利用cachedOrgThreadPool(线程池 ) 执行线程，防止线程浪费
 */

public class PackPool {
	/*
	1.线程池固定大小，假设为5.那么向线程池放入10个线程，运行效果如何？其他线程的状态？
	  a.线程池的概念就是它只能处理规定额度的线程，多余的线程都会在其中等待。
	  b.当其中一个线程处理完毕（业务执行完毕或退出while循环），线程池就会自动从等待的队列中取出一个，按照被放入的先后顺序来的。
	2.那么如何从线程池中移除某一个线程，确切说是使某一个线程成为空闲线程？
	    线程池无法获取其中某一个线程并杀掉他，因为使用线程池的主线程和主线程开启的线程是平级的。
	  a.主线程维护一个Hash表可以是一个HashMap。key值任意，但是要唯一，可以唯一标示一个线程。
	  b.所有放入线程池的线程，都要生成一个key值，然后存入这个HashMap中。
	  c.对于循环类的线程，如while(true)的线程。需要增加一个条件，每一轮循环校验这个线程的key是否存在于上面HashMap中。如果不存在则退出while循环。
	  d.对自己的HashMap进行put或是remove操作。到此，只要从HashMap中移除线程对应的Key值，这个线程在下次循环的时候就会自动退出了。
	*/
	private final static Logger logger = LoggerFactory.getLogger(PackPool.class);
	
	private static ExecutorService cachedOrgThreadPool = Executors.newCachedThreadPool();//母包线程池
	private static ExecutorService cachedPkgThreadPool = Executors.newCachedThreadPool();//打包线程池
	//母包处理
	private static BlockingQueue<PackOrgHandle> orgWaitingQueue = new ArrayBlockingQueue<>(100);//母包等待列队
	private static ConcurrentMap<Integer,PackOrgHandle> orgDoingMap = new ConcurrentHashMap<>();//母包处理池
	//打包处理
	private static BlockingQueue<PackHandle> packWaitingQueue =  new ArrayBlockingQueue<>(500);//打包等待列队
	private static ConcurrentMap<Integer, PackHandle> packDoingSimpleMap =  new ConcurrentHashMap<>();//打包处理池
	private static ConcurrentMap<Integer, ConcurrentMap<Integer,PackHandle>> packDoingMap =  new ConcurrentHashMap<>();

	private static ConcurrentMap<Integer,Future> orgRuningMap = new ConcurrentHashMap<>();//母包运行池
	private static ConcurrentMap<Integer, Future> packRuningMap =  new ConcurrentHashMap<>();//打包运行池
	
	static{
		final int  MAX_ORG_THREAD = 2;//母包最大线程
		final int  MAX_PACK_THREAD = 50;//打包最大线程
		final int  MAX_THREAD_ONE_GAME = 3;
		new Thread(
			new Runnable(){
				public void run() {
					//一直检测，等待母包队列放入数据，然后执行
					while (true) {
						PackOrgHandle one = null;
						try {
							if (orgDoingMap.size() >= MAX_ORG_THREAD) {
								Thread.sleep(500);
								continue;
							}
							//取出一个(为空进入等待状态，线程并没有结束)
							one = orgWaitingQueue.take();
							orgDoingMap.put(one.getAppId(),one);
							//使用线程池去执行,防止线程浪费
							Future of = cachedOrgThreadPool.submit(one);
							orgRuningMap.put(one.getAppId(), of);
							logger.info("母包Id[{}],母包等待队列({}),母包处理池({})",one.getAppId(),orgWaitingQueue.size(),orgDoingMap.size());
						} catch (Exception e) {
							logger.error("处理母包异常",e);
						}
					}
				}
			}
		).start();
		new Thread(
			new Runnable(){
				public void run() {
					//一直检测，等待打包队列放入数据，然后执行
					while (true) {
						PackHandle one = null;
						try {
							if (packDoingSimpleMap.size() >= MAX_PACK_THREAD) {
								Thread.sleep(500);
								continue;
							}
							if (packWaitingQueue.isEmpty()) {
								Thread.sleep(500);
								continue;
							}
							one = packWaitingQueue.element();
							int appId = one.getAppId();
							ConcurrentMap<Integer,PackHandle> gamePcMap = packDoingMap.get(appId);
							if (gamePcMap==null) {
								gamePcMap = new ConcurrentHashMap<>();
								packDoingMap.put(appId, gamePcMap);
							}else if (gamePcMap.size() >= MAX_THREAD_ONE_GAME) {
								continue;
							}
							one = packWaitingQueue.take();
							packDoingSimpleMap.put(appId,one);
							gamePcMap.put(appId, one);
							Future of = cachedPkgThreadPool.submit(one);
							packRuningMap.put(appId, of);
							logger.info("打包Id[{}],等待池({}),打包中({}),应用打包数量({})",appId,packWaitingQueue.size(),packDoingSimpleMap.size(),gamePcMap.size());
						} catch (Exception e) {
							logger.error("处理打包异常",e);
						}
					}
				}
			}
		).start();
	}
	public static void addOrgHandle(PackOrgHandle one) throws InterruptedException{
		orgWaitingQueue.put(one);
	}
	public static void addPkgHandle(PackHandle one) throws InterruptedException{
		packWaitingQueue.put(one);
	}
	public static void removeDoingOrg(int appId){
		orgDoingMap.remove(appId);
		orgRuningMap.remove(appId);
	}
	public static void removeDoingPack(int appId){
		packDoingSimpleMap.remove(appId);
		packDoingMap.remove(appId);
		packRuningMap.remove(appId);
	}
	public static String bulidState(){
		String str1="母包等待队列:"+orgWaitingQueue.size();
		String str2="母包处理池:"+orgDoingMap.size();
		String str3="打包等待队列:"+packWaitingQueue.size();
		String str4="打包处理池:"+packDoingMap.size();
		String str5="简单打包处理池:"+packDoingSimpleMap.size();
		String buildStatus = "<br/>"+str1+"<br/>"+str2+"<br/>"+str3+"<br/>"+str4+"<br/>"+str5;
		return buildStatus;
	}
}
