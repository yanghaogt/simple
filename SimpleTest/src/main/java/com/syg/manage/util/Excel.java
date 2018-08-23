package com.syg.manage.util;

import java.io.Serializable;
import java.lang.reflect.Method;

public class Excel implements Serializable {

	private int index;
	
	private int width = 10;

	private String field = "";
	
	private String title = "";
	
	private String methodName;
	
	public Excel(int index, int width, String field, String title ,String methodName) {
		this.field = field;
		this.index = index;
		this.methodName = methodName;
		this.title = title;
		this.width = width;
	}
	
	public Excel(int index, int width, String field, String title) {
		this.field = field;
		this.index = index;
		this.title = title;
		this.width = width;
	}

	public Excel() {
		super();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getWidth() {
		return width;
	}

	public int setWidth(int width) {
		this.width = width;
		return width;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public String setTitle(String title) {
		this.title = title;
		return this.title;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String toString(){
		return StringUtils.objectToString(this);
	}
	
}
