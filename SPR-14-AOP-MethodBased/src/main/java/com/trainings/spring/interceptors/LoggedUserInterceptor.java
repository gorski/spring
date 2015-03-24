package com.trainings.spring.interceptors;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("loggedUserInterceptor")
public class LoggedUserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		Authentication auth = SecurityContextHolder
				.getContext()
				.getAuthentication();
		
//		  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = auth.getName() + " Roles: "; 
		Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
		for (GrantedAuthority grantedAuthority : roles) {
			name += " ";
			name += grantedAuthority.getAuthority().toString();
		}
		modelAndView.addObject("loggedUser", name);

	}

}
