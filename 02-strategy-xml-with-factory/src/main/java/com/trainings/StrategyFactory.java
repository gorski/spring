package com.trainings;

import com.trainings.basic.CalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 *
 */
public class StrategyFactory {

    private CalculationStrategy myStrategy;

    public StrategyFactory(CalculationStrategy myStrategy) {
        this.myStrategy = myStrategy;
    }



    public CalculationStrategy getMyStrategy() {
        return myStrategy;
    }

    public void setMyStrategy(CalculationStrategy myStrategy) {
        this.myStrategy = myStrategy;
    }

    public StrategyExecutor createStrategy(){
        StrategyExecutor executor = new StrategyExecutor();
        executor.setY(20);
        executor.setX(324);
        executor.setCalculationStrategy(myStrategy);
        return executor;
    }
}
