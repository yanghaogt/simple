package com.syg.manage.model.manage;

import java.util.ArrayList;
import java.util.List;

public class ManagePer {
	private int mpId;
	private String perName;
	private int fatherMpId;
	private String pageUrl;
	private String simDesc;
	private ManagePer fatherPer;
	private List<ManagePer> subList=new ArrayList<>();
	
	
	public int getMpId() {
		return mpId;
	}
	public void setMpId(int mpId) {
		this.mpId = mpId;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public int getFatherMpId() {
		return fatherMpId;
	}
	public void setFatherMpId(int fatherMpId) {
		this.fatherMpId = fatherMpId;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setSimDesc(String simDesc) {
		this.simDesc = simDesc;
	}
	public String getSimDesc() {
		return simDesc;
	}
	public void setSubList(List<ManagePer> subList) {
		this.subList = subList;
	}
	public List<ManagePer> getSubList() {
		return subList;
	}
	public void setFatherPer(ManagePer fatherPer) {
		this.fatherPer = fatherPer;
	}
	public ManagePer getFatherPer() {
		return fatherPer;
	}

}
