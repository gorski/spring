package com.trainings.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.trainings.controller"})
@EnableWebMvc
public class WebConfig {

}
