package com.syg.manage.model.manage;

import java.util.Date;

public class SurveyRecord {
	
	private int srId;
	private int stId;
	private int scId;
	private int duId;
	private Date createTime;
	
	public int getSrId() {
		return srId;
	}
	public void setSrId(int srId) {
		this.srId = srId;
	}
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public int getDuId() {
		return duId;
	}
	public void setDuId(int duId) {
		this.duId = duId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
