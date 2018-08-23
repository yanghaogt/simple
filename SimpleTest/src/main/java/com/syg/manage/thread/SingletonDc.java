package com.syg.manage.thread;

/**
 * 单例模式  双重检查 (多线程首选效率较高)
 * @author yanghao
 * 优点：线程安全；延迟加载；效率较高。
 */
public class SingletonDc {

	private static volatile SingletonDc singleton;
	
	private SingletonDc(){}
	
	public static SingletonDc getInstance(){
		if (singleton == null) {
			synchronized (SingletonDc.class) {
				if (singleton == null) {
					singleton = new SingletonDc();
				}
			}
		}
		return singleton;
	}
	
}
