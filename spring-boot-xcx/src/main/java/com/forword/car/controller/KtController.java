package com.forword.car.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forword.car.service.KtService;
@Controller
@RequestMapping("kt")
public class KtController {
	public Logger log = Logger.getLogger(KtController.class);
	@Autowired
	private KtService ktService;
	
	@RequestMapping(value = "getKmydata/{pa}", method = RequestMethod.GET)
	public List<Map<String,Object>> getKmydata(@PathVariable String pa){
		ktService.getKmydata(pa);
		return null;
	}
}
