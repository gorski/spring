package com.trainings.controller;

import com.trainings.basic.SystemInformation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Produces;

@Controller
public class MainController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private SystemInformation systemInformation;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ResponseBody
    public SystemInformation sayHello() {
        return  systemInformation;
    }


}
