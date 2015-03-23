package com.trainings.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary  // one way to make bean injected
@Component("addStrategy")
public class ConcreteStrategyAdd implements CalculationStrategy {

  public int execute(int a, int b) {
    System.out.println("add");
    return a + b;
  }

}
