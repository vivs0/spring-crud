package com.example.crud.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.crud.dao.EmployeeDaoImpl;
import com.example.crud.entities.Employee;
import com.example.crud.entities.Status;
import com.example.crud.entities.User;
import com.example.crud.form.ViewUpdateForm;
import com.example.crud.other.SqlDateEditor;
import com.example.crud.user.services.UserTaskService;
import com.google.gson.Gson;

@Controller
public class AdminUser {

	final private Logger logger = Logger.getLogger(AdminUser.class);
	private String user;
	
	@Autowired
	private UserTaskService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(java.sql.Date.class, new SqlDateEditor(sdf));
	}
	@RequestMapping(value="/Admin/",method=RequestMethod.GET)
	public String afterlogin()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		user = auth.getName();
		return "Admin/home";
	}
	@RequestMapping(value="/Admin/{userpage}/",method=RequestMethod.GET)
	public String admin()
	{
		return "Admin/home";
	}
	
	@RequestMapping(value="/Admin/{userpage}/ViewUpdate",method=RequestMethod.POST)
	public String ViewOrUpdate(Model model)
	{
		ViewUpdateForm form = new ViewUpdateForm(new Employee(), new User(), new Status());
		model.addAttribute("employeelist", (List<Employee>)this.service.getAllUser());
		model.addAttribute("user", form);
		return "Admin/ViewUpdate";
	}
	
	@RequestMapping(value="/Admin/{userpage}/Update",method=RequestMethod.POST)
	public String Update(@ModelAttribute("user") @Valid ViewUpdateForm form, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			logger.debug("Some error" + result.getAllErrors());
			return null;
		}
		service.Update(form);
		return "Admin/home";
	}
	
	@RequestMapping(value="/Admin/{userpage}/search",method=RequestMethod.GET,params="searchtype=name")
	public String FindEmployeeByName(@RequestParam(name="searchParam") String name, Model model)
	{
		logger.debug("Reached search by name method");
		logger.debug(name);
		ViewUpdateForm form = new ViewUpdateForm(new Employee(), new User(), new Status());
		model.addAttribute("employeelist", (service.findByName(name)));
		model.addAttribute("user", form);
		logger.debug(model);
		logger.debug(form);
		return "Admin/ViewUpdate";
	}
	@RequestMapping(value="/Admin/{userpage}/search",method=RequestMethod.GET,params="searchtype=id")
	public String FindEmployeeById()
	{
		logger.debug("Reached search by Id method");
		
/*		service.findByName(name)
		ViewUpdateForm form = new ViewUpdateForm(new Employee(), new User(), new Status());
		model.addAttribute("employeelist", (List<Employee>)this.service.getAllUser());
		model.addAttribute("user", form);
		logger.debug(model);
		logger.debug(form);*/
		return "Admin/ViewUpdate";
	}

	@RequestMapping(value="/Admin/{userpage}/search",method=RequestMethod.GET)
	public String FindEmployeeInvalid()
	{
		logger.debug("Reached search by default");
		
/*		service.findByName(name)
		ViewUpdateForm form = new ViewUpdateForm(new Employee(), new User(), new Status());
		model.addAttribute("employeelist", (List<Employee>)this.service.getAllUser());
		model.addAttribute("user", form);
		logger.debug(model);
		logger.debug(form);*/
		return "Admin/ViewUpdate";
	}
}
