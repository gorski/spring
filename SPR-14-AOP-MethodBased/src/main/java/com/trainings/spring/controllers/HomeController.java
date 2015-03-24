package com.trainings.spring.controllers;

import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static final Logger LOG = Logger.getLogger(HomeController.class);
	
    @Autowired
    private ApplicationContext ctx;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homeGet(
			@RequestParam(value = "id", required = false, defaultValue = "x") String id,
			@RequestHeader("User-agent") String userAgent,
			Locale locale
			) {

		LOG.info("Opened /home");
		LOG.debug("User agent:" + userAgent);

		ModelAndView mav = new ModelAndView("home");
		mav.setViewName("home");
		mav.addObject("today", new Date());
        mav.addObject("userAgent", userAgent);
        mav.addObject("locale", locale);

		return mav;
	}

	@RequestMapping(value = "/home/{id}", method = RequestMethod.POST)
	public ModelAndView homePost(@PathVariable String id) {
		LOG.info("Opened /home   (POST)");
		
		ModelAndView mav = new ModelAndView("home");
		mav.setViewName("home");
		mav.addObject("today", new Date());
		return mav;
	}

}
