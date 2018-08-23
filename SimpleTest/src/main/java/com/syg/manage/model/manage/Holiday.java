package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class Holiday {
	
	private Integer id;
	private Date 	logDate;
	private String 	name;
	private ShDate 	logDateSh;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ShDate getLogDateSh() {
		return logDateSh;
	}
	public void setLogDateSh(ShDate logDateSh) {
		this.logDateSh = logDateSh;
	}
}
