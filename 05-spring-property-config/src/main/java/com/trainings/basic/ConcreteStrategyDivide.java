package com.trainings.basic;

import org.springframework.stereotype.Component;

@Component("divideStrategy")
public class ConcreteStrategyDivide implements CalculationStrategy {

  public int execute(int a, int b) {
    System.out.println("divide");
    return a / b;
  }

}
