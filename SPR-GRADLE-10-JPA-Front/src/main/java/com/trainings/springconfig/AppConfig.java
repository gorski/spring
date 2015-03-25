package com.trainings.springconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ComponentScan(basePackages = {"com.trainings.beans"})
@ImportResource("classpath:spring.xml")
public class AppConfig {



}
