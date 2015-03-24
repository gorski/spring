package com.trainings.controller;

import com.trainings.basic.FakeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private FakeRepository fakeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView sayHello() {

        LOG.info("Entering controller method");
        return new ModelAndView("/WEB-INF/jsp/hello.jsp");
    }

    @RequestMapping(value = {"/userInfo/{id}"})
    public ModelAndView userInfo2(@PathVariable() Long id) { // default path name same as variable

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/user.jsp");
        mav.addObject("userId", id);
        mav.addObject("userName", fakeRepository.findUserById(id)); // this will throw Nullpointer
        return mav;
    }






}
