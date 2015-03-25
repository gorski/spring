package com.trainings.controller;

import com.trainings.basic.service.WeatherService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView sayHello(@RequestHeader("User-Agent") String userAgent) {

        LOG.info("About to call service.");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/hello.jsp");

        return mav;
    }

    @RequestMapping(value = "/weather/{query}")
    public ModelAndView weather(@PathVariable("query") String query) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/weather.jsp");

        LOG.info("Querying weather for {} ", query);
        mav.addObject("weather", weatherService.getWeather(query));
        LOG.info("Weather fetched!");
        return mav;
    }


}
