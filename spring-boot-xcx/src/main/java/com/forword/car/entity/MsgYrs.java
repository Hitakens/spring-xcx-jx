package com.forword.car.entity;



public class MsgYrs {

	private boolean success = true;
	private String msg;
	private Object sbxx;
	private Object nsxx;
	private Object fpdk;
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
	public Object getSbxx() {
		
		return sbxx=sbxx==null?"[]":sbxx;
	}
	public void setSbxx(Object sbxx) {
		this.sbxx = sbxx;
	}
	public Object getNsxx() {
		return nsxx=nsxx==null?"[]":nsxx;
	}
	public void setNsxx(Object nsxx) {
		this.nsxx = nsxx;
	}
	public Object getFpdk() {
		return fpdk=fpdk==null?"[]":fpdk;
	}
	public void setFpdk(Object fpdk) {
		this.fpdk = fpdk;
	}

	
	
}
