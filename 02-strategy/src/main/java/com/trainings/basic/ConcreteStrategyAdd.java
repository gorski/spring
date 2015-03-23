package com.trainings.basic;

public class ConcreteStrategyAdd implements CalculationStrategy {

  public int execute(int a, int b) {
    System.out.println("add");
    return a + b;
  }

}
