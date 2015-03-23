package com.trainings.config;

import com.trainings.basic.CalculationStrategy;
import com.trainings.basic.ConcreteStrategyAdd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.trainings.basic")
public class AppConfig {


}
