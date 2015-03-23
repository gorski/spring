package com.trainings;

import com.trainings.basic.CalculationStrategy;

/**
 *
 */
public class StrategyExecutor {

    private CalculationStrategy calculationStrategy;
    private int x;
    private int y;

    public void execute() {
        System.out.println(calculationStrategy.execute(x, y));
    }

    public CalculationStrategy getCalculationStrategy() {
        return calculationStrategy;
    }

    public void setCalculationStrategy(CalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
