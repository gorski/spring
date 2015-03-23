package com.trainings.config;

import com.trainings.basic.CalculationStrategy;
import com.trainings.basic.ConcreteStrategyAdd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.trainings.basic")
// TODO: property source
public class AppConfig {


}
