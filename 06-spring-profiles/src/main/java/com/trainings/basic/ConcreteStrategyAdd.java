package com.trainings.basic;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("add")
public class ConcreteStrategyAdd implements CalculationStrategy {

  public int execute(int a, int b) {
    System.out.println("add");
    return a + b;
  }

}
