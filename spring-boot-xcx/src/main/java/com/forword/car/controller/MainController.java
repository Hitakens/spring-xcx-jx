package com.forword.car.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forword.car.service.MainService;
import com.forword.main.BasController;

@Controller
@RequestMapping("main")
public class MainController extends BasController {

	public Logger log = Logger.getLogger(MainController.class);
	@Autowired
	private MainService carService;
	@RequestMapping(value="/{id}/{id1}",method=RequestMethod.GET)
	public String yrsSerch(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id,@PathVariable String id1) {
//		this.writeJson(carService.selectmy_user(id), request, response);

			return id+"/"+id1;
		
	}
}
