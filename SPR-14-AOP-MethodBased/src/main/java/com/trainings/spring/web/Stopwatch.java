package com.trainings.spring.web;


import java.util.Date;

import org.springframework.stereotype.Component;

@Component("componentStopwatch")
public class Stopwatch {

    private Date creationTime;
    private String name;

    public Stopwatch() {
        this.creationTime = new Date();
        this.name = "unknown";
    }

    public Stopwatch(String name){
        this();
        System.out.println("Creating Stopwatch: "+name);
        this.name = name;
    }



    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Stopwatch{" +
                "creationTime=" + creationTime +
                ", name='" + name + '\'' +
                '}';
    }
}
