package com.example.crud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class RegisterInterceptor extends HandlerInterceptorAdapter{
	private Logger logger = Logger.getLogger(RegisterInterceptor.class);
	
	private BindingResult result;
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("after completetion");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("post completetion");
		String key = BindingResult.MODEL_KEY_PREFIX+"users";
		BindingResult br = (BindingResult)modelAndView.getModel().get(key);
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("pre completetion");
		return super.preHandle(request, response, handler);
	}
	
	public void getBindingResult()
	{
		System.out.println("Post handle called");
		String key = BindingResult.MODEL_KEY_PREFIX+"users";
		//BindingResult br = (BindingResult)modelAndView.getModel().get(key);	
		
	}
}

