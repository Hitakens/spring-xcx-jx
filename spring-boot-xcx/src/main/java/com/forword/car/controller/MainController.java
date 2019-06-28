package com.forword.car.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forword.car.service.MainService;
import com.forword.common.StringUtil;
import com.forword.main.BasController;

@Controller
@RequestMapping("main")
public class MainController extends BasController {

	public Logger log = Logger.getLogger(MainController.class);
	@Autowired
	private MainService carService;

	@RequestMapping(value = "/{id}/{id1}", method = RequestMethod.GET)
	public String yrsSerch(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id, @PathVariable String id1) {
		// this.writeJson(carService.selectmy_user(id), request, response);
		return id + "/" + id1;

	}

	@RequestMapping("/getOpenid")
	@ResponseBody
	public String getOpenid(HttpServletResponse response,String js_code,String avatarUrl,String nickName) {
		String result="";
		try {
			
			String openid = getOpenid(js_code);
			String oppenid = StringUtil.StringTojson("openid",openid);
			String pdopenid = pdopenid(oppenid);
			String yhxx=null;
			if(pdopenid!=null && !pdopenid.equals("")){
				yhxx= carService.updateYhxx(oppenid,avatarUrl,nickName,StringUtil.StringTojson("session_key",openid));
				result=yhxx;
			}else{
				result="0";
			}
		} catch (Exception e) {
			result="0";
			log.error("请求小程序openid发生错误");
		}
			
		return result;

	}

	/**
	 * @Title: getUserInfo 
	 * @Description: 判断用户是否存在
	 * @param openid
	 */
	public String pdopenid(String openid) {
		
		return carService.getopenidisnull(openid);
	}
	//getcz.html
@RequestMapping("/getcz.html")	
public String getcz(String js_code,String avatarUrl,String nickName,HttpServletRequest request) {
	
	return "all/bdhyk";
	}

public String getOpenid(String js_code){
	String result = "";
	String urlhttp = "https://api.weixin.qq.com/sns/jscode2session?secret=0c7c9c9939a6451ff28e85c3d55738ce"
			+ "&appid=wx132f1639dffc3d6d&grant_type=authorization_code&js_code=" + js_code;
	HttpURLConnection connection = null;
	BufferedReader reader = null;
	try {
		URL url = new URL(urlhttp);
		connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Type", "utf-8");
		connection.connect();
		reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String lines;
		StringBuffer sb = new StringBuffer("");
		sb.append("[");
		while ((lines = reader.readLine()) != null) {
			lines = new String(lines.getBytes(), "utf-8");
			sb.append(lines);
		}
		sb.append("]");	
		result=sb.toString();
	} catch (Exception e) {
		result="0";
		log.error("请求小程序openid发生错误");
	} finally {
		if (connection != null) {
			connection.disconnect();
		}
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	return result;
}
}
