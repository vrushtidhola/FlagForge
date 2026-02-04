package org.personal.flagforge.flagservice;

import org.personal.flagforge.flagservice.domain.StrategyRequest;
import org.personal.flagforge.flagservice.strategy.AlwaysOnStrategy;
import org.personal.flagforge.flagservice.strategy.PercentageStrategy;
import org.personal.flagforge.flagservice.strategy.RolloutStrategy;

public class FlagFactory {

    public static RolloutStrategy from(StrategyRequest request)
    {
        if (request == null) {
            throw new IllegalArgumentException("Strategy config is required");
        }
        if("PERCENTAGE".equals(request.getType()))
        {
            return new PercentageStrategy(request.getValue());
        }
        else if("ALWAYSON".equals(request.getType()))
        {
            return new AlwaysOnStrategy();
        }
        throw new IllegalArgumentException("Unknown strategy");
    }
}
