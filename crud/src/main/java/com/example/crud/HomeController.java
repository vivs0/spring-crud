package com.example.crud;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.example.crud.entities.Employee;
import com.example.crud.entities.Gender;
import com.example.crud.entities.User;
import com.example.crud.form.EmployeeRegisterationForm;
import com.example.crud.interceptor.RegisterInterceptor;
import com.example.crud.other.GenderBinder;
import com.example.crud.other.SqlDateEditor;
import com.example.crud.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	private EmployeeService service;
	
	final private Logger logger = Logger.getLogger(HomeController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(java.sql.Date.class, new SqlDateEditor(sdf));
		binder.registerCustomEditor(Gender.class, new GenderBinder());
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping(value="/Add", method=RequestMethod.GET)
	public String index(Map<String, Object> model){
		EmployeeRegisterationForm form = new EmployeeRegisterationForm(new Employee(),new User());
		model.put("form", form);
		model.put("gen", Gender.values());
		logger.debug(model);
		return "home";
	}

	@RequestMapping(value="/Register", method=RequestMethod.POST)
	public String Register(@ModelAttribute("form")  @Valid EmployeeRegisterationForm employee, BindingResult result, Model model){
		String status="";
		if(result.hasErrors())
		{
			return "home";
		}
		try{
			service.Register(employee);
			status = "Data saved successfully";
			model.addAttribute("status", status);
		}
		catch(Exception e)
		{
			status = "Some error has occured try again later reached";
			model.addAttribute("status", status);
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public String Login()
	{
		return "Login";
	}
}

