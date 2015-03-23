package com.trainings.config;

import com.trainings.basic.CalculationStrategy;
import com.trainings.basic.ConcreteStrategyAdd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CalculationStrategy myStrategy(){
        return new ConcreteStrategyAdd();
    }

}
