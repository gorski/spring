package com.trainings.basic.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository
public class WeatherService {

    final String URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public WeatherResponse getWeather(String query){

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = restTemplate.getForObject(URL + query, WeatherResponse.class);
//        Weather weather = response.getWeather();

//        Map main = (Map) restTemplate.getForObject(URL + query, Map.class).get("main");

        return response;
    }


}
