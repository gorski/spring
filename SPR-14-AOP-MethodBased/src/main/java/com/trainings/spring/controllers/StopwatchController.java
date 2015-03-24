package com.trainings.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trainings.spring.web.Stopwatch;

@Controller
@RequestMapping(value = "/stopwatch")
public class StopwatchController {

    @Autowired @Qualifier("singletonStopwatch")  Stopwatch singletonStopwatch;
    @Autowired @Qualifier("prototypeStopwatch")  Stopwatch prototypeStopwatch;
    @Autowired @Qualifier("requestStopwatch")  Stopwatch requestStopwatch;
    @Autowired @Qualifier("sessionStopwatch")  Stopwatch sessionStopwatch;

    @Autowired @Qualifier("stopwatch")  Stopwatch appConfigStopwatch;
    @Autowired @Qualifier("componentStopwatch") Stopwatch componentStopwatch;

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listBeans() {

        ModelAndView mav = new ModelAndView("bean_list");
        mav.addObject("singleton", singletonStopwatch)
                .addObject("prototype", prototypeStopwatch)
                .addObject("request", requestStopwatch)
                .addObject("session", sessionStopwatch)
                .addObject("stopwatch", appConfigStopwatch)
                .addObject("componentStopwatch", componentStopwatch);


//        Utils.listCtx(ctx);
        return mav;
    }
}
