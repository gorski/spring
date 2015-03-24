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

        try {
            // some time consuming operation , random 0 - 10 seconds
            Thread.sleep(new Random().nextInt(10)*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return new ModelAndView("/WEB-INF/jsp/hello.jsp");
    }


}
