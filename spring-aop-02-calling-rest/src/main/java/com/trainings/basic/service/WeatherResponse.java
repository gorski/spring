package com.trainings.basic.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true) // does not throw exception when empty response
@XmlRootElement
public class WeatherResponse {
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String
    toString() {
        return "WeatherResponse{" +
                "main=" + main +
                '}';
    }
}
