package com.forword.car.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forword.car.entity.Layui;
import com.forword.car.entity.ParaEntity;
import com.forword.car.entity.kmtmEntity;
import com.forword.car.service.tmxgService;
import com.forword.main.BasController;

@Controller
@RequestMapping("tm")
public class tmxgController extends BasController {
	public Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private tmxgService tmxgService;

	@RequestMapping("/selectTMall")
	@ResponseBody
	public Layui selectTMall(ParaEntity pa, Integer limit, Integer page) {
		Layui selecttm=null;
		try {
			selecttm=tmxgService.selectTMall(pa,limit,page);
		} catch (Exception e) {
			log.error("查询题目错误", e.fillInStackTrace());
		}
		return selecttm;
	}
	//insertKm
	@RequestMapping("/insertKm")
	@ResponseBody
	public String insertKm(kmtmEntity pa) {
		String selecttm=null;
		try {
			selecttm=tmxgService.insertKm(pa);
		} catch (Exception e) {
			log.error("修改错误", e.fillInStackTrace());
		}
		return selecttm;
	}
}
