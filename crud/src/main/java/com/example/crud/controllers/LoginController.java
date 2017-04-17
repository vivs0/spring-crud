package com.example.crud.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class);
	@RequestMapping(value="/login")
	public ModelAndView Login(@RequestParam(value="error",required=false)String error, @RequestParam(value="logout",required=false)String logout)
	{
		ModelAndView model = new ModelAndView();
		logger.debug("reached login controller");
		if(error != null){
			logger.debug("error");
			model.addObject("error", "Invalid Username and Password");
		}
		if(logout != null){
			model.addObject("logout", "You have been logout successfully");
		}
		model.setViewName("Login");
		return model;		
	}
}
