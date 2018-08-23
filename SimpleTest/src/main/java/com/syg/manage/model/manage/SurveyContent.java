package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class SurveyContent {
	
	private int scId;
	private int stId;
	private String scTitle;
	private String scRemark;
	private String imageUrl;
	private int totalNumber;
	private String operator;
	private Date createTime;
	private Date updateTime;
	
	private ShDate createTimeSh;

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getScTitle() {
		return scTitle;
	}

	public void setScTitle(String scTitle) {
		this.scTitle = scTitle;
	}

	public String getScRemark() {
		return scRemark;
	}

	public void setScRemark(String scRemark) {
		this.scRemark = scRemark;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	
	
}
