package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.util.DateUtil;



public class SummaryNewAddUser extends DataParameters{
	
	private Integer newAddUser;//新增用户数
	private Integer newAddAccount;//新增账户数
	private Integer searchType;//搜索类型
	
	private String dateStr;
	private String date;
	private Date logTime;//记录时间
	public Integer getNewAddUser() {
		return newAddUser;
	}
	public void setNewAddUser(Integer newAddUser) {
		this.newAddUser = newAddUser;
	}
	public Integer getNewAddAccount() {
		return newAddAccount;
	}
	public void setNewAddAccount(Integer newAddAccount) {
		this.newAddAccount = newAddAccount;
	}
	public Integer getSearchType() {
		return searchType;
	}
	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}
	public String getDateStr() {
		return DateUtil.dateFormatString(getLogTime());
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
}
