package com.forword.car.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forword.car.service.KtService;
@Controller
@RequestMapping("kt")
public class KtController {
	public Logger log = Logger.getLogger(KtController.class);
	@Autowired
	private KtService ktService;
	/**
	 * @Title: getKmydata 
	 * @Description:  题目展示
	 * @param pa
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	@RequestMapping(value = "getKmydata/{pa}", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getKmydata(@PathVariable String pa){
		List<Map<String,Object>> listdate=null;
		try {
			listdate=ktService.getKmydata(pa);
		} catch (Exception e) {
			log.error("请求"+pa+"出现异常", e.fillInStackTrace());
		}
		return listdate;
	}
	
	@RequestMapping(value = "scbt", method = RequestMethod.POST)
	@ResponseBody
	public String getKmydata(String sclx,Integer uuid,HttpServletRequest re){
		String rusel=null;
		try {
			String openid = (String) re.getSession().getAttribute("openid");
			rusel=ktService.scbt(sclx,uuid,openid);
		} catch (Exception e) {
			log.error("收藏"+sclx+"出现异常", e.fillInStackTrace());
		}
		return rusel;
	}
}
