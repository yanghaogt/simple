package com.syg.manage.thread;
/**
 * 单例模式  饿汗式
 * 节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能
 * 优点：比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费
 * 两种写法，静态常量写法和静态块写法
 * @author yanghao
 */
public class Singleton {
	//创建私有的对象
	private final static Singleton instance = new Singleton();
	//创建私有的构造函数
	private Singleton(){}
	//创建唯一一个可以获取对象的方法
	public static Singleton getInStance(){
		return instance;
	}
}
