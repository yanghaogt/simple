package com.syg.manage.model.entity;

import java.util.Map;

import com.syg.manage.model.manage.ManagePer;
import com.syg.manage.model.manage.ManageRole;
import com.syg.manage.model.manage.ManageUser;

public class SesUser {
	private ManageUser manageUser;
	private Map<Integer,ManagePer> pers;
	private ManageRole manageRole;
	private ManagePer rootPer;
	private ManagePer subPer;
	private Progress progress;
	
	public ManageUser getManageUser() {
		return manageUser;
	}
	public void setManageUser(ManageUser manageUser) {
		this.manageUser = manageUser;
	}
	public ManageRole getManageRole() {
		return manageRole;
	}
	public void setManageRole(ManageRole manageRole) {
		this.manageRole = manageRole;
	}
	public ManagePer getRootPer() {
		return rootPer;
	}
	public void setRootPer(ManagePer rootPer) {
		this.rootPer = rootPer;
	}
	public void setPers(Map<Integer, ManagePer> pers) {
		this.pers = pers;
	}
	public Map<Integer, ManagePer> getPers() {
		return pers;
	}
	public ManagePer getSubPer() {
		return subPer;
	}
	public void setSubPer(ManagePer subPer) {
		this.subPer = subPer;
	}
	public Progress getProgress() {
		return progress;
	}
	public void setProgress(Progress progress) {
		this.progress = progress;
	}
	
	
}
