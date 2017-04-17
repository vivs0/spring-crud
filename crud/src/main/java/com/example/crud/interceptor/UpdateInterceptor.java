package com.example.crud.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class UpdateInterceptor extends HandlerInterceptorAdapter{
	private Logger logger = Logger.getLogger(UpdateInterceptor.class);
//	ViewUpdateForm [employee=Users [ID=0, First_Name=null, Last_Name=null, Contact=null, Email=null, DateOfBirth=null, DateOfJoining=null, Salary=null], user=User [ID=0, Password=null, status=null, employee=null], status=Status [id=0, statusName=null]]
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("after");
		logger.debug("after completetion");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("after");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			logger.debug("post handle");
			System.out.println("post");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("update pre handle");
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			String param = (String)e.nextElement();
			String val = request.getParameter(param);
			logger.debug(param+" > " +val);
		}
		return super.preHandle(request, response, handler);
	}

}
