package com.trainings.basic.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "weather")
public class Main {

    private Double temp;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                '}';
    }
}
