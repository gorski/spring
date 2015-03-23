package com.trainings.basic;

public class ConcreteStrategyMultiply implements CalculationStrategy {

    public int execute(int a, int b) {
        System.out.println("multiply");
        return a * b;
    }

}
