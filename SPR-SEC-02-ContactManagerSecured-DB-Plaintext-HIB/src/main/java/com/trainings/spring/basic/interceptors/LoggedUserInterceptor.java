package com.trainings.spring.basic.interceptors;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("loggedUserInterceptor")
public class LoggedUserInterceptor extends HandlerInterceptorAdapter {

  // Before the actual controller will be executed.

  @Override
  public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
      final Object handler) {

    return true;
  }

  // After the controller is executed

  @Override
  public void postHandle(final HttpServletRequest request, final HttpServletResponse response,
      final Object handler, final ModelAndView modelAndView) {

    // 1st way

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();


    String name = auth.getName(); //get logged in username
    Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
    for (GrantedAuthority grantedAuthority : roles) {
      name += " ";
      name += grantedAuthority.getAuthority().toString();
    }
    modelAndView.addObject("loggedUser", name);

    // 2nd way

    // watch out for class casting!

//    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    if (principal instanceof User){
//      // ... user logged in
//    } else if (principal instanceof  String) {
//      // anonymous login, i.e. String "anonymous"
//    } else {
//      // sth else
//    }

//    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    String username = user.getUsername(); //get logged in username
//    Collection<? extends GrantedAuthority> rolez = user.getAuthorities();
//    for (GrantedAuthority grantedAuthority : rolez) {
//      username += " ";
//      username += grantedAuthority.getAuthority().toString();
//    }
//    modelAndView.addObject("loggedUserB", username);

  }

}
