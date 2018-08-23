package com.syg.manage.exception;


public class ParamException extends BaseException {
	public ParamException() {
		super();
		setMsg("请求参数错误");
	}
	
	public ParamException(String msg){
		super(msg);
	}
	public ParamException(String msg,String code){
		super(msg,code);
	}
}
