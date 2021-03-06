package com.trainings;

import com.trainings.basic.CalculationStrategy;
import com.trainings.basic.ConcreteStrategyAdd;
import com.trainings.config.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {



		ConfigurableApplicationContext xmlContext = new AnnotationConfigApplicationContext(AppConfig.class);

		xmlContext.getBean(StrategyExecutor.class).execute();
	}

}
