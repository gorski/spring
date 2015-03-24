package com.trainings.basic.interceptors;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("executeTimeInterceptor")
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ExecuteTimeInterceptor.class);

    // Before the actual controller will be executed.

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object handler) {

        LOG.info("entering preHandle");
        request.setAttribute("processingStartTime", System.currentTimeMillis());
        return true;
    }

    // After the controller is executed

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response,
                           final Object handler, final ModelAndView modelAndView) {
        LOG.info("entering postHandle");



        final long startTime = (Long) request.getAttribute("processingStartTime");
        final long endTime = System.currentTimeMillis();
        final long duration = endTime - startTime;


        LOG.info("Executed in {} seconds ", duration);

        modelAndView.addObject("executionTime", duration);
    }

}
