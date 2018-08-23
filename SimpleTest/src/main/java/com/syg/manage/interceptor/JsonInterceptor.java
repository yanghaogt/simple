package com.syg.manage.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.syg.manage.annotation.TagJson;

/**
 * 登陆拦截器
 * 
 * @author hulinyun
 * 
 */
public class JsonInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (handler==null || !(handler instanceof HandlerMethod)) {
			super.postHandle(request, response, handler, modelAndView);
			return;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		TagJson jsonAnno = method.getAnnotation(TagJson.class);
		if (jsonAnno!=null) {
			if (jsonAnno.isStr()) {
//				String orgValue = modelAndView.getViewName();
				modelAndView.setViewName("common/json/json_str");
//				modelAndView.addObject("json", orgValue);
			}
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
