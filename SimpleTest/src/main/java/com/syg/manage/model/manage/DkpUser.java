package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class DkpUser {
	
	private int duId;
	private String userName;
	private String passWord;
	private int userDkp;
	private Date createTime;
	
	private ShDate createTimeSh;
	
	public int getDuId() {
		return duId;
	}
	public void setDuId(int duId) {
		this.duId = duId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getUserDkp() {
		return userDkp;
	}
	public void setUserDkp(int userDkp) {
		this.userDkp = userDkp;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public ShDate getCreateTimeSh() {
		return createTimeSh;
	}
	public void setCreateTimeSh(ShDate createTimeSh) {
		this.createTimeSh = createTimeSh;
	}
	
}
