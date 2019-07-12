package com.forword.car.controller;

import java.util.List;
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

import com.alibaba.fastjson.JSONObject;
import com.forword.car.entity.ParaEntity;
import com.forword.car.service.xcService;
import com.forword.main.BasController;
@Controller
@RequestMapping("xc")
public class xcController extends BasController{
	public Logger log = Logger.getLogger(xcController.class);
	@Autowired
	private xcService ktService;
	
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
	 * @Description:  科目一题目展示
	 * @param pa
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	@RequestMapping(value = "getKmydata/{pa}/{tmlx}", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getKmydata(@PathVariable String pa,
			@PathVariable String tmlx,HttpServletRequest request){
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
	/**
	 * @Description: 算出某个科目下的收藏和错误的题目数
	 * @param cwlx
	 * @param re
	 * @return
	 */
	@RequestMapping(value = "ctsc/{clx}", method = RequestMethod.GET)
	public void ctsc(@PathVariable String clx,HttpServletRequest re,HttpServletResponse rs){
		String openid = (String) re.getSession().getAttribute("openid");
		Map<String,Object> rusel=null;
		try {
			rusel=ktService.ctsc(clx,openid);
		} catch (Exception e) {
			log.error("算出某个科目下的收藏和错误的题目数出现异常", e.fillInStackTrace());
		}
		this.writeJson(rusel, re, rs);
	}
	/**
	 * @Title: kmMnks 
	 * @Description: 跳入模拟考试的页面，初始化页面数据
	 * @param kmj
	 * @param mo
	 * @return
	 * @return: String
	 */
	@RequestMapping(value="kmMnks/{kmj}")
	public String kmMnks(@PathVariable String kmj,Model mo){
	List<Map<String,Object>> datas=null;
	String pathres=null;
	try {
		datas=ktService.kmMnks(kmj);
		if(kmj=="xckmy" || "xckmy".equals(kmj)){
			pathres="xckmy/mnks";
		}else if(kmj=="xckms" || "xckms".equals(kmj)){
			pathres="xckms/mnks";
		}
        mo.addAttribute("datas", JSONObject.toJSONString(datas));
	} catch (Exception e) {
		log.error("初始化考试页面数据发生错误", e.fillInStackTrace());
	}
		return pathres;
	}
	/**
	 * @Title: carkmdycs 
	 * @Description: 科目一单元测试
	 * @param tmlx
	 * @param ymcs
	 * @param mo
	 * @return
	 * @return: String
	 */
	@RequestMapping(value="kmyMnks/{tmlx}/{ymcs}")
	public String carkmdycs(@PathVariable String tmlx,@PathVariable String ymcs,
			Model mo){
	List<Map<String,Object>> datas=null;
	try {
		datas=ktService.carkmdycs(tmlx,ymcs);
        mo.addAttribute("dycsdata", JSONObject.toJSONString(datas));
	} catch (Exception e) {
		log.error("初始化考试页面数据发生错误", e.fillInStackTrace());
	}
		return "xckmy/dycsdt";
	}
	/**
	 * @Title: showcwsc 
	 * @Description: 展示我的收藏和错误
	 * @param lx
	 * @param mo
	 * @return
	 * @return: String
	 */
	@RequestMapping(value="cwsc/{lx}/{kmj}")
	public String showcwsc(@PathVariable String lx,@PathVariable String kmj,
			Model mo,HttpServletRequest re){
	List<Map<String,Object>> datas=null;
	String ymparam="";
	String openid = (String) re.getSession().getAttribute("openid");
	try {
		if(lx=="sc" || "sc".equals(lx)){
			mo.addAttribute("cwsc", "我的收藏");
		}else if(lx=="cw" || "cw".equals(lx)){
			mo.addAttribute("cwsc", "我的错误");
		}
		if(kmj=="kmy" || "kmy".equals(kmj)){
			mo.addAttribute("palx", "A");
			datas=ktService.showcwsc(lx,openid,"A");
			ymparam="xckmy/cwscdt";
		}else if(kmj=="kms" || "kms".equals(kmj)){
			mo.addAttribute("palx", "A1");
			datas=ktService.showcwsc(lx,openid,"A1");
			ymparam="xckms/cwscdt";
		}
		if(datas.isEmpty()){
			ymparam="main/index";
		}
		mo.addAttribute("lx", lx);
        mo.addAttribute("cwscdata", JSONObject.toJSONString(datas));
	} catch (Exception e) {
		log.error("初始化考试页面数据发生错误", e.fillInStackTrace());
	}
		return ymparam;
	}
	/**
	 * @Title: deletebt 
	 * @Description: 删除收藏或者错误
	 * @param re
	 * @param pa
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "deletebt", method = RequestMethod.POST)
	@ResponseBody
	public String deletebt(HttpServletRequest re,ParaEntity pa){
		String openid = (String) re.getSession().getAttribute("openid");
		String rusel=null;
		try {
			if(pa!=null){
				pa.setStr4(openid);
				rusel=ktService.deletebt(pa);
			}else{
				rusel="201";	
			}
		} catch (Exception e) {
			rusel="201";
			log.error("算出某个科目下的收藏和错误的题目数出现异常", e.fillInStackTrace());
		}
		return rusel;
	}
}
