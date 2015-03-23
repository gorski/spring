package com.trainings.basic;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("subtract")
public class ConcreteStrategySubtract implements CalculationStrategy {

  public int execute(int a, int b) {
    System.out.println("subtract");
    return a - b;
  }

}
