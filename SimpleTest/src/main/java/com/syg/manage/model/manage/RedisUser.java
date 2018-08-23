package com.syg.manage.model.manage;

import java.util.Date;

public class RedisUser {
	private int infullAmount;	//总充值金额
	private Date regTime;		//注册时间
	private int onlineTime;		//总在线时间
	private int loginCount;		//登陆次数
	private int activeDay;		//连续活跃天数
	private int activeWeek;		//连续活跃周数
	private Date lastLoginTime;	//最近登陆时间
	private String lastLoginLogId;	//最近登陆的日志编号
	private Date lastLoginUpdateTime;//最近登陆更新的时间
	public int getInfullAmount() {
		return infullAmount;
	}
	public void setInfullAmount(int infullAmount) {
		this.infullAmount = infullAmount;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public int getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(int onlineTime) {
		this.onlineTime = onlineTime;
	}
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	public int getActiveDay() {
		return activeDay;
	}
	public void setActiveDay(int activeDay) {
		this.activeDay = activeDay;
	}
	public int getActiveWeek() {
		return activeWeek;
	}
	public void setActiveWeek(int activeWeek) {
		this.activeWeek = activeWeek;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginLogId() {
		return lastLoginLogId;
	}
	public void setLastLoginLogId(String lastLoginLogId) {
		this.lastLoginLogId = lastLoginLogId;
	}
	public Date getLastLoginUpdateTime() {
		return lastLoginUpdateTime;
	}
	public void setLastLoginUpdateTime(Date lastLoginUpdateTime) {
		this.lastLoginUpdateTime = lastLoginUpdateTime;
	}
	
	
}
