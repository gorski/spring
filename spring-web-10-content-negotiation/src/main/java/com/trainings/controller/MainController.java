package com.trainings.controller;

import com.trainings.basic.SystemInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private SystemInformation systemInformation;

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"}
    )
    public SystemInformation sayHello() {
        return systemInformation;
    }


}
