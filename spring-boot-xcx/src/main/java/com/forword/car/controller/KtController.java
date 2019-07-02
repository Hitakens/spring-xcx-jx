package com.forword.car.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @Title: bzt 
 * @Description: 必做题页面路径跳转
 * @param id
 * @param kmlx
 * @param mo
 * @return
 * @return: String
 */
	@RequestMapping(value = "bzt/{kmlx}/{id}", method = RequestMethod.GET)
	public String bzt(@PathVariable String id,@PathVariable String kmlx,Model mo){
		mo.addAttribute("ymcs", id);
		if(kmlx=="kmy" || "kmy".equals(kmlx)){
			return "xckmy/bztdt";
		}else if(kmlx=="kms" || "kms".equals(kmlx)){
			return "xckms/bztdt";
		}
		return null;
	}
	/**
	 * @Title: bzt 
	 * @Description: 选做题页面路径跳转
	 * @param id
	 * @param kmlx
	 * @param mo
	 * @return
	 * @return: String
	 */
		@RequestMapping(value = "xzt/{kmlx}/{id}", method = RequestMethod.GET)
		public String xzt(@PathVariable String id,@PathVariable String kmlx,Model mo){
			mo.addAttribute("ymcs", id);
			if(kmlx=="kmy" || "kmy".equals(kmlx)){
				return "xckmy/xztdt";
			}else if(kmlx=="kms" || "kms".equals(kmlx)){
				return "xckms/xztdt";
			}
			return null;
		}
	/**
	 * @Title: getKmydata 
	 * @Description:  题目展示
	 * @param pa
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	@RequestMapping(value = "getKmydata/{pa}/{tmlx}", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getKmydata(@PathVariable String pa,
			@PathVariable String tmlx,HttpServletRequest request){
		request.getSession().setAttribute("openid", "oveQN5Ex4tR2carpJaywzuMc3ymk");
		List<Map<String,Object>> listdate=null;
		try {
			listdate=ktService.getKmydata(pa,tmlx);
		} catch (Exception e) {
			log.error("请求"+pa+"出现异常", e.fillInStackTrace());
		}
		return listdate;
	}
	/**
	 * 
	 * @Title: scbt 
	 * @Description: 收藏本题
	 * @param sclx
	 * @param uuid
	 * @param re
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "scbt", method = RequestMethod.POST)
	@ResponseBody
	public String scbt(String sclx,Integer uuid,HttpServletRequest re){
		String rusel=null;
		try {
			String openid = (String) re.getSession().getAttribute("openid");
			rusel=ktService.scbt(sclx,uuid,openid);
		} catch (Exception e) {
			log.error("收藏"+sclx+"出现异常", e.fillInStackTrace());
		}
		return rusel;
	}
	/**
	 * @Title: btcw 
	 * @Description: 错误记录
	 * @param cwlx
	 * @param uuid
	 * @param re
	 * @return: String
	 */
	@RequestMapping(value = "btcw", method = RequestMethod.POST)
	@ResponseBody
	public String btcw(String cwlx,Integer uuid,HttpServletRequest re){
		String rusel=null;
		try {
			String openid = (String) re.getSession().getAttribute("openid");
			rusel=ktService.cwlx(cwlx,uuid,openid);
		} catch (Exception e) {
			log.error("收藏"+cwlx+"出现异常", e.fillInStackTrace());
		}
		return rusel;
	}
	/**
	 * 
	 * @Title: iftmsc 
	 * @Description: 判断题目是否收藏
	 * @param cwlx
	 * @param uuid
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "iftmsc", method = RequestMethod.GET)
	@ResponseBody
	public String iftmsc(String cwlx,Integer uuid,HttpServletRequest re){
		String openid = (String) re.getSession().getAttribute("openid");
		String rusel=null;
		try {
			rusel=ktService.iftmsc(cwlx,uuid,openid);
		} catch (Exception e) {
			log.error("收藏"+cwlx+"出现异常", e.fillInStackTrace());
		}
		return rusel;
	}
}
