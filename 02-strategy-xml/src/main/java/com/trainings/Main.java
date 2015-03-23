package com.trainings;

import com.trainings.basic.ConcreteStrategyAdd;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext xmlContext = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        ConcreteStrategyAdd context = (ConcreteStrategyAdd) xmlContext.getBean("myStrategy");
        System.out.println("Result (spring): " + context.execute(10, 20));
    }

}

