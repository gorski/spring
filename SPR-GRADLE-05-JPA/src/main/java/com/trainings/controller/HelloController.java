package com.trainings.controller;

import com.trainings.beans.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(HelloController.class);

    @Autowired
    @Qualifier("pc")
    Computer computer;


    @RequestMapping("hello")
    public ModelAndView loadHomePage() {
        LOG.info("Hello");
        final ModelAndView mav = new ModelAndView("hello");

        mav.addObject("computer", computer);
        mav.addObject("name", "Spring User!");

        return mav;
    }
}
