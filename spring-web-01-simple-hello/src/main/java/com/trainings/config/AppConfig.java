package com.trainings.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.trainings.basic")  // scan this package for beans
@ImportResource("classpath:spring.xml")               // allow bean in XML definitions as well
public class AppConfig {


}
