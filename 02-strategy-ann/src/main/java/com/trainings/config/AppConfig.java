package com.trainings.config;

import com.trainings.StrategyExecutor;
import com.trainings.basic.CalculationStrategy;
import com.trainings.basic.ConcreteStrategyAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired CalculationStrategy calculationStrategy;

    @Bean(name = "myStrategy")
    // default bean name same as method below
    public CalculationStrategy myStrategy(){
        return new ConcreteStrategyAdd();
    }

    @Bean
    public StrategyExecutor executor(){
        StrategyExecutor se = new StrategyExecutor();
        se.setCalculationStrategy(calculationStrategy);
        se.setX(15);
        se.setY(3);
        return se;
    }

}
