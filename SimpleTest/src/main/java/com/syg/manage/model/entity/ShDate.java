package com.syg.manage.model.entity;

import java.util.Date;

public class ShDate extends Date {
	private static final long serialVersionUID = -5833498424435735967L;
	
	
	private Date begin;
	private Date end;
	
	public ShDate(){
		super();
	}
	
	public ShDate(Date data) {
		super(data.getTime());
	}
	
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		if (begin instanceof ShDate) {
			this.begin = new Date(begin.getTime());
		}else{
			this.begin = begin;
		}
		
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		if (end instanceof ShDate) {
			this.end = new Date(end.getTime());
		}else{
			this.end = end;
		}
	}
	
}
