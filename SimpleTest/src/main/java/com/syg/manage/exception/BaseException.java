package com.syg.manage.exception;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	private String code = "E";
	private String msg = "程序异常";
	
	public BaseException() {
		super();
	}
	
	public BaseException(String msgOut) {
		super(msgOut);
		this.msg = msgOut;
	}
	
	public BaseException(String msgOut ,String codeOut) {
		super(msgOut);
		msg = msgOut;
		code = codeOut;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
