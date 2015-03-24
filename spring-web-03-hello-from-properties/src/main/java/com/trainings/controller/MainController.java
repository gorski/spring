package com.trainings.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainController.class);

    // one way to inject properties
    @Value("${hello.message}")
    private String hello;

    // second way to do the same (more generic)
    @Autowired
    private Environment environment;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView sayHello() {

        LOG.info("Entering controller method");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/hello.jsp");
        mav.addObject("hello", hello);

        String property = environment.getProperty("not exisitng");
        if (property == null){
            LOG.info("property indeed does not exist");
        }


        return mav;
    }


}
