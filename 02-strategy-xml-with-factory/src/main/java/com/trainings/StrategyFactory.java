package com.trainings;

import com.trainings.basic.CalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 *
 */
public class StrategyFactory {

    @Autowired
    CalculationStrategy myStrategy;

    public StrategyExecutor createStrategy(){
        StrategyExecutor executor = new StrategyExecutor();
        executor.setY(20);
        executor.setX(324);
        executor.setCalculationStrategy(myStrategy);
        return executor;
    }
}
