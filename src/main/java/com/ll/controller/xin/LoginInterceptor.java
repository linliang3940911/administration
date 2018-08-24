package com.ll.controller.xin;

import com.ll.pojo.caoxin.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author songxj
 *
 */

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		// 登录不做拦截
		User user = (User) request.getSession().getAttribute("loginUser");
		ServletContext application = request.getSession().getServletContext();
		HttpSession session = request.getSession();

		if (request.getRequestURI().equals("/caoxin/denglu") || request.getRequestURI().equals("/caoxin/queryUser")|| request.getRequestURI().equals("/xin/denglu")) {
			return  true;
		}
			if (user == null) {
				response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/caoxin/denglu");
				return false;
		}else{
			String attribute =(String)application.getAttribute(user.getUserid());
		if(session.getId().equals(attribute)){
			return  true;
		}
		}
		return  true;
	}

	/**
	 * 该方法将在Controller执行之后，返回视图之前执行，modelAndView表示请求Controller处理之后返回的Model和View对象，所以可以在
	 * 这个方法中修改modelAndView的属性，从而达到改变返回的模型和视图的效果。
	 */
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
						   ModelAndView modelAndView) throws Exception {

	}


	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
								Object o, Exception e) throws Exception {

	}

	public String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}


}
