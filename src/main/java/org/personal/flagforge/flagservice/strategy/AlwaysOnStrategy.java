package org.personal.flagforge.flagservice.strategy;

public class AlwaysOnStrategy implements  RolloutStrategy{

    @Override
    public boolean isEnabled(String userId)
    {
        return true;
    }
}
