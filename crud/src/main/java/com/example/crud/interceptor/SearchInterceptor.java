package com.example.crud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SearchInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = Logger.getLogger(SearchInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("reached search pre()");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("reached search pre()");
		String param = request.getParameter("searchtype");
		logger.debug(param);
		switch(param){
		case "id":
			break;
		case "name":
			logger.debug("reached name");
			break;
		case "email":
			break;
		case "contact":
			break;
		default:
			logger.debug("reached default");
			IllegalArgumentException ex = new IllegalArgumentException("Invalid search parameter");
			throw ex;
		}
		return true;
		
	}

}
