package com.forword.car.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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

import com.forword.car.entity.ParaEntity;
import com.forword.car.service.KtService;
import com.forword.car.service.MainService;
import com.forword.common.StringUtil;
import com.forword.main.BasController;

@Controller
@RequestMapping("main")
public class MainController extends BasController {

	public Logger log = Logger.getLogger(MainController.class);
	@Autowired
	private MainService carService;
	@Autowired
	private KtService ktService;
	/**
	 * 
	 * @Title: yrsSerch 
	 * @Description: 测试接口，上线以后注释掉
	 * @param model
	 * @param request
	 * @param response
	 * @param id
	 * @param id1
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "/{id}/{id1}", method = RequestMethod.GET)
	public String yrsSerch(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id, @PathVariable String id1) {
		request.getSession().setAttribute("openid", "oveQN5Ex4tR2carpJaywzuMc3ymk");
		// this.writeJson(carService.selectmy_user(id), request, response);
		/*Map<String, Object> ctsc = ktService.ctsc("xc", "oveQN5Ex4tR2carpJaywzuMc3ymk");
		request.setAttribute("maps", ctsc);*/
		return id + "/" + id1;

	}
	/**
	 * 
	 * @Title: joinpage 
	 * @Description: 进入页面的第一个控制
	 * @param model
	 * @param request
	 * @param response
	 * @param sid
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "joinpage", method = RequestMethod.GET)
	public String joinpage(Model model, HttpServletRequest request, HttpServletResponse response,
			 String sid) {
		//通过sessionid查询openid
		Map<String,Object> ma=ktService.selectOpenidBysessionid(sid);
		if(ma.isEmpty()) {
			return "all/bdhyk";
		}
		
		request.getSession().setAttribute("openid", ma.get("openid"));
		// this.writeJson(carService.selectmy_user(id), request, response);
		//初始化页面的收藏题目数和错误的题目数
		Map<String, Object> ctsc = ktService.ctsc("xc", (String)ma.get("openid"));
		request.setAttribute("maps", ctsc);
		request.setAttribute("wxname", ma.get("wxname"));
		request.setAttribute("avatarurl", ma.get("avatarurl"));
		return "main/index";

	}
	/**
	 * @Title: getOpenid 
	 * @Description: 从微信端发出来的请求,把openid存入数据库
	 * @param response
	 * @param request
	 * @param js_code
	 * @param avatarUrl
	 * @param nickName
	 * @return
	 * @return: Map<String,Object>
	 */
	@RequestMapping("/getOpenid")
	@ResponseBody
	public Map<String,Object> getOpenid(HttpServletResponse response, HttpServletRequest request,
			String js_code,String avatarUrl,String nickName) {
		Map<String,Object> result=null;
		try {
			
			String res = getOpenid(js_code);
			String oppenid = StringUtil.StringTojson("openid",res);
			String pdopenid = pdopenid(oppenid);
			String yhxx=null;
			if(pdopenid!=null && !pdopenid.equals("")){
				yhxx= carService.updateYhxx(oppenid,avatarUrl,nickName,StringUtil.StringTojson("session_key",res));
				result=new HashMap<>();
				result.put("code", "1");
				result.put("stuid", yhxx);
			}else{
				yhxx=carService.insertYhxxyk(oppenid,avatarUrl,nickName,StringUtil.StringTojson("session_key",res));
				result=new HashMap<>();
				result.put("code", "0");
				result.put("stuid", yhxx);
			}
		} catch (Exception e) {
			log.error("请求小程序openid发生错误",e.fillInStackTrace());
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
/**
 * @Title: getcz 
 * @Description: 没有注册的用户，跳转到注册页面
 * @param stuid
 * @param imgurl
 * @param request
 * @return
 * @return: String
 */
@RequestMapping(value = "/getcz.html", method = RequestMethod.GET)
public String getcz(String stuid,String imgurl,HttpServletRequest request) {
	request.setAttribute("stuid", stuid);
	System.out.println(stuid);
	request.setAttribute("imgurl", imgurl);
	return "all/bdhyk";
	}
/**
 * @Title: insertkm 
 * @Description: 用户填写卡密成功后，把用户的信息存入数据库
 * @param pa
 * @return
 * @return: String
 */
@RequestMapping(value = "/insertyh", method = RequestMethod.GET)	
@ResponseBody
public String insertkm(ParaEntity pa) {
	String re=null;
	 try {
		 re= carService.insertkm(pa);
	} catch (Exception e) {
		// TODO: handle exception
	}
	 return re;
	}
/**
 * @Title: glyLogin 
 * @Description: 管理员登陆
 * @param pa
 * @return
 * @return: String
 */
@RequestMapping(value = "/admin.html", method = RequestMethod.POST)	
@ResponseBody
public String glyLogin(ParaEntity pa) {
	String re=null;
	 try {
		 re= carService.glyLogin(pa);
	} catch (Exception e) {
		log.error("管理员登陆失败",e.fillInStackTrace());
	}
	 return re;
	}
/**
 * @Title: kmsc 
 * @Description: 随机生成卡密
 * @param n
 * @param mo
 * @return
 * @return: String
 */
@RequestMapping(value = "admin/kmsc", method = RequestMethod.GET)	
public String kmsc(String uname,Model mo) {
	String re=null;
	 try {
		 re= carService.randomKm(1);
		 if(re!=null){
			 mo.addAttribute("cardmi", re);
			 mo.addAttribute("uname", uname);
		 }
	} catch (Exception e) {
		log.error("管理员登陆失败",e.fillInStackTrace());
	}
	 return "admin/kmsc";
	}
/**
 * @Title: kmsc 
 * @Description: 随机生成卡密ajax
 * @param n
 * @param mo
 * @return
 * @return: String
 */
@RequestMapping(value = "admin/ajaxkmsc", method = RequestMethod.GET)	
@ResponseBody
public String ajaxkmsc(int n,Model mo) {
	String re=null;
	 try {
		 re= carService.randomKm(n);
	} catch (Exception e) {
		log.error("管理员登陆失败",e.fillInStackTrace());
	}
	 return re;
	}
/**
 * @Title: submitinsert 
 * @Description: 生成的卡密往数据库里存
 * @param pa
 * @param mo
 * @return
 * @return: String
 */
@RequestMapping(value = "admin/submitinsert", method = RequestMethod.POST)	
@ResponseBody
public String submitinsert(ParaEntity pa,Model mo) {
	String re=null;
	 try {
		 re= carService.submitinsert(pa);
	} catch (Exception e) {
		log.error("管理员登陆失败",e.fillInStackTrace());
		re="卡密已经存在,请重新生成";
	}
	 return re;
	}
/**
 * @Title: getOpenid 
 * @Description: 通过js_code获取用户微信端的openid
 * @param js_code
 * @return
 * @return: String
 */
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
