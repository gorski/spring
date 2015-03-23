package com.trainings.basic;

public class ConcreteStrategySubtract implements CalculationStrategy {

  public int execute(int a, int b) {
    System.out.println("subtract");
    return a - b;
  }

}
