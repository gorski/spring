package com.trainings.basic.interceptors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Component("timeBasedAccessInterceptor")
public class BrowserInterceptor extends HandlerInterceptorAdapter {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(BrowserInterceptor.class);

    @Value("${nice.browser}")
    private String niceBrowser;


    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        String agent = request.getHeader("User-Agent");

        LOG.info("entering preHandle, your browser is: {} " + agent);

        boolean isNiceBrowser = agent.toLowerCase().contains(niceBrowser.toLowerCase());

        LOG.info("Is your browser nice one? ", isNiceBrowser ? "Yes!" : "No!");

        if (!isNiceBrowser){
            // link to download chrome :)
            response.sendRedirect("https://www.google.com/chrome/browser/desktop/");
        }

        return true;
    }
}
