package com.trainings.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntime(RuntimeException e, HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/error.jsp");
        mav.addObject("exceptionMessage", e.getMessage());

        // sets response code to 500
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        return mav;
    }
}
