/**
 * 
 */
package com.syg.manage.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

/**
 * session 缓存类 
 * 1.用于保存已登录用户的session，在用户多地登录时只能一处在线
 * 2.保存不频繁更改的数据
 */
public class SessionCache {
	private static SessionCache sessionCache;

	/**
	 * 缓存在线用户session
	 */
	private Map<String, HttpSession> onlineUsers = new ConcurrentHashMap<>();
	
	private SessionCache() {
	}
	
	public static synchronized SessionCache getInstance(){
		if(sessionCache == null) sessionCache = new SessionCache();
		return sessionCache;
	}
	
	/**
	 * 登录成功，保存session
	 * @param userId+loginType
	 * @param sess
	 * @author Jarry
	 * @createtime 2015-7-6 下午3:24:52
	 */
	public void addOnEmp(String key, HttpSession sess){
		onlineUsers.put(key, sess);
	}
	
	public HttpSession getOnEmp(Integer empId, String loginType){
		return onlineUsers.get(loginType+empId);
	}
	
	
}
