package com.forword.car.entity;



public class Msg {

	private boolean success = true;
	private String msg;
	private Object fxxx;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg=msg==null?"没有相关信息":msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getFxxx() {
		
		return fxxx=fxxx==null?"[]":fxxx;
	}
	public void setFxxx(Object fxxx) {
		this.fxxx = fxxx;
	}
}
