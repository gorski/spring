package com.trainings;

import com.trainings.basic.CalculationStrategy;
import com.trainings.basic.ConcreteStrategyAdd;
import com.trainings.config.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		ConfigurableApplicationContext xmlContext = new AnnotationConfigApplicationContext(AppConfig.class);
		CalculationStrategy context = xmlContext.getBean(CalculationStrategy.class);
		System.out.println("Result (spring): " + context.execute(10, 30));

	}

}
