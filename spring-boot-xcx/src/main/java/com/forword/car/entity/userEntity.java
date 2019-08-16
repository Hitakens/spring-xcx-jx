package com.forword.car.entity;

import java.io.Serializable;
import java.util.Date;

public class userEntity implements Serializable{
private String username;
private String userpass;
private String yxbz;
private String glybz;
private String bz;
private Date sjsj;


public Date getSjsj() {
	return sjsj;
}
public void setSjsj(Date sjsj) {
	this.sjsj = sjsj;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpass() {
	return userpass;
}
public void setUserpass(String userpass) {
	this.userpass = userpass;
}

public String getYxbz() {
	return yxbz;
}
public void setYxbz(String yxbz) {
	this.yxbz = yxbz;
}
public String getGlybz() {
	return glybz;
}
public void setGlybz(String glybz) {
	this.glybz = glybz;
}
public String getBz() {
	return bz;
}
public void setBz(String bz) {
	this.bz = bz;
}


}
