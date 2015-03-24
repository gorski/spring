package com.trainings.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *
 */
@Component(value =  "myBean")
public class TestBean {

    @Value("${x}")
    private Integer x;


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @PostConstruct
    public void postConstruct(){

        // fetch Euro rate (i.e. from webservice)
        int rate = 4;

        x *= rate;


    }
}
