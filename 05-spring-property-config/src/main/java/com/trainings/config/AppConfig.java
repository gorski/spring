package com.trainings.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.trainings.basic")
@PropertySource("classpath:app.properties")
public class AppConfig {


}
