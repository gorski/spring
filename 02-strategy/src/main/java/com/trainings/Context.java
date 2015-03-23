package com.trainings;


import com.trainings.basic.CalculationStrategy;

public class Context {

    private final CalculationStrategy strategy;

    public Context(CalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }

}
