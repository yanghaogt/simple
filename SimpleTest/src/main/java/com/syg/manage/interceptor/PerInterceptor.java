package com.syg.manage.interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.syg.manage.annotation.TagPer;
import com.syg.manage.model.entity.SesUser;
import com.syg.manage.model.manage.ManageOperateLog;
import com.syg.manage.model.manage.ManagePer;
import com.syg.manage.svs.manage.IManageSvs;
import com.syg.manage.util.SesHelper;

/**
 * 登陆拦截器
 * 
 * @author hulinyun
 * 
 */
public class PerInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	private IManageSvs manageSvs;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		TagPer annotation = method.getAnnotation(TagPer.class);
		if (annotation != null) {

			if (!annotation.needLogin()) {
				return true;
			}
			SesUser user = SesHelper.getSimUser(request.getSession());
			if (user != null) {
				// 检查权限
				ManagePer currentPer = user.getPers().get(Integer.valueOf(annotation.value().getCode()));
				if (currentPer == null) {
					// 去提示没有权限
					// TODO 去提示没有权限
					request.setAttribute("tm_common_error_msg", "您没有此权限");
					request.setAttribute("tm_common_error_desc", "您没有权限["+annotation.value().getCode()+"]");
					request.getRequestDispatcher("/noPer").forward(request,response);
					return false;
				}

				request.getSession().setAttribute("currentPer", currentPer);
				ManageOperateLog example = new ManageOperateLog();
				example.setUserId(user.getManageUser().getMuId());
				example.setUserName(user.getManageUser().getUserName());
				example.setLogTime(new Date());
				example.setOperateName(currentPer.getPerName());
				String[] classNames = method.getDeclaringClass().getName().split("\\."); 
				example.setMethodName(classNames[classNames.length - 1] + "." + method.getName());
				manageSvs.addOperateLog(example);
			} else {
				// 去登陆界面
				request.getRequestDispatcher("/loginPage").forward(request,
						response);
				return false;
			}
		}
		return true;
	}

}
