package com.trainings.basic;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("myStrategy")
@Profile("default")    // this is default profile !
public class ConcreteStrategyMultiply implements CalculationStrategy {

    public int execute(int a, int b) {
        System.out.println("multiply");
        return a * b;
    }

}
