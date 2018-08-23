package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class ManageOperateLog {
	private int molId;
	private int userId;
	private String userName;
	private Date logTime;
	private ShDate logTimeSh;
	private String operateName;
	private String methodName;
	public int getMolId() {
		return molId;
	}
	public void setMolId(int molId) {
		this.molId = molId;
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
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public ShDate getLogTimeSh() {
		return logTimeSh;
	}
	public void setLogTimeSh(ShDate logTimeSh) {
		this.logTimeSh = logTimeSh;
	}
}
