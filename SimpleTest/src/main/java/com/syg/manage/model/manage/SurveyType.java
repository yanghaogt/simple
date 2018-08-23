package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class SurveyType {
	
	private int stId;
	private String stTitle;
	private String imageUrl;
	private String operator;
	private Integer stStatus;
	private Date createTime;
	private String stDetail;
	private int scId;
	private Date updateTime;
	private int stDkp;
	private Date beginTime;
	private Date endTime;
	
	private ShDate createTimeSh;
	
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStTitle() {
		return stTitle;
	}
	public void setStTitle(String stTitle) {
		this.stTitle = stTitle;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Integer getStStatus() {
		return stStatus;
	}
	public void setStStatus(Integer stStatus) {
		this.stStatus = stStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStDetail() {
		return stDetail;
	}
	public void setStDetail(String stDetail) {
		this.stDetail = stDetail;
	}
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public ShDate getCreateTimeSh() {
		return createTimeSh;
	}
	public void setCreateTimeSh(ShDate createTimeSh) {
		this.createTimeSh = createTimeSh;
	}
	public int getStDkp() {
		return stDkp;
	}
	public void setStDkp(int stDkp) {
		this.stDkp = stDkp;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}
