package com.syg.manage.demo;

import java.util.Date;

public class OrgVersion {
	private int ovId;
	private int appId;
	private String ovName;
	private int verCode;
	private String verName;
	private String fileSavePath;
	private String fileName;
	private String fileDownPath;
	private Date lastUpdateTime;
	
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getOvId() {
		return ovId;
	}
	public void setOvId(int ovId) {
		this.ovId = ovId;
	}
	public String getOvName() {
		return ovName;
	}
	public void setOvName(String ovName) {
		this.ovName = ovName;
	}
	public int getVerCode() {
		return verCode;
	}
	public void setVerCode(int verCode) {
		this.verCode = verCode;
	}
	public String getVerName() {
		return verName;
	}
	public void setVerName(String verName) {
		this.verName = verName;
	}
	public String getFileSavePath() {
		return fileSavePath;
	}
	public void setFileSavePath(String fileSavePath) {
		this.fileSavePath = fileSavePath;
	}
	public String getFileDownPath() {
		return fileDownPath;
	}
	public void setFileDownPath(String fileDownPath) {
		this.fileDownPath = fileDownPath;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
