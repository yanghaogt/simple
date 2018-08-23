package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class ManageUser {
	private int muId;
	private String userName;
	private String password;
	private Date regTime;
	private Date lastLoginTime;
	private int mrId;
	private String realName;
	
	private ShDate regTimeSh;
	private ShDate lastLoginTimeSh;
	
	private String headImg;
	
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public int getMuId() {
		return muId;
	}
	public void setMuId(int muId) {
		this.muId = muId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public int getMrId() {
		return mrId;
	}
	public void setMrId(int mrId) {
		this.mrId = mrId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public ShDate getRegTimeSh() {
		return regTimeSh;
	}
	public void setRegTimeSh(ShDate regTimeSh) {
		this.regTimeSh = regTimeSh;
	}
	public ShDate getLastLoginTimeSh() {
		return lastLoginTimeSh;
	}
	public void setLastLoginTimeSh(ShDate lastLoginTimeSh) {
		this.lastLoginTimeSh = lastLoginTimeSh;
	}
	
}
