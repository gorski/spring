package com.trainings.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Value("${hello.message}")
    private String hello;

    // system property accessor
    @Value("#{ systemProperties['os.name'] }")
    private String osName;

    // spring expression language
    @Value("#{ 2 < -5.0} ")
    private Boolean isTwoSmaller;

    @Value("#{ myBean.x * 2}")
    private Integer multipliedX;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView sayHello() {

        LOG.info("Entering controller method");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/hello.jsp");
        mav.addObject("hello", hello);
        mav.addObject("osName", osName);
        mav.addObject("isTwoSmaller", isTwoSmaller);

        mav.addObject("multipliedX", multipliedX);

        return mav;
    }


}
