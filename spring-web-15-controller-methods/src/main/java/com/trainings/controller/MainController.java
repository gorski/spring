package com.trainings.controller;

import com.trainings.basic.FakeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public ModelAndView userInfo(@RequestParam("userId") Long userId) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/user.jsp");
        mav.addObject("userId", userId);
        mav.addObject("userName", fakeRepository.findUserById(userId));
        return mav;
    }


    @RequestMapping("/headerInfo")
    public ModelAndView displayHeaderInfo(
            @RequestHeader("Accept-Encoding") String encoding,
            @RequestHeader("User-Agent") String userAgent) {


        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/headers.jsp");
        mav.addObject("encoding", encoding);
        mav.addObject("userAgent", userAgent);
        return mav;
    }


}
