package com.forword.car.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forword.car.service.MainService;
import com.forword.main.BasController;

@Controller
@RequestMapping("main")
public class MainController extends BasController {

	public Logger log = Logger.getLogger(MainController.class);
	@Autowired
	private MainService carService;
	@RequestMapping("index")
	public String mianIndex(){
		
		return "/main/index";
	}
}
