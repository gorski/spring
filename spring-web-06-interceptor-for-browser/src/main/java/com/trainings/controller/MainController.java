package com.trainings.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class MainController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainController.class);


    @RequestMapping(value = "/", method = RequestMethod.GET)
     public ModelAndView sayHello() {

        LOG.info("Entering controller method");
        return new ModelAndView("/WEB-INF/jsp/hello.jsp");
    }


    @RequestMapping(value = "/forNiceBrowsersOnly", method = RequestMethod.GET)
    public ModelAndView forNiceBrowsersOnly() {
        LOG.info("Entering controller method for nice browser only :)");
        return new ModelAndView("/WEB-INF/jsp/nice.jsp");
    }



}
