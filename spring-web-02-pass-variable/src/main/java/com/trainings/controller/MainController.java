package com.trainings.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView sayHello() {

        LOG.info("Entering controller method");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/hello.jsp");
        mav.addObject("hello", "Hello from the backend application!");

        return mav;
    }


}
