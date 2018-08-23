package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class ManageLoginLog {
	private int mllId;
	private int userId;
	private String userName;
	private String loginIp;
	private String loginArea;
	private int loginResult;
	private Date logTime;
	private ShDate logTimeSh;
	
	public int getMllId() {
		return mllId;
	}
	public void setMllId(int mllId) {
		this.mllId = mllId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getLoginArea() {
		return loginArea;
	}
	public void setLoginArea(String loginArea) {
		this.loginArea = loginArea;
	}
	public int getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(int loginResult) {
		this.loginResult = loginResult;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = new ShDate(logTime);
	}
	public ShDate getLogTimeSh() {
		return logTimeSh;
	}
	public void setLogTimeSh(ShDate logTimeSh) {
		this.logTimeSh = logTimeSh;
	}
}
