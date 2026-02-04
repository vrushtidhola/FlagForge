package org.personal.flagforge.flagservice.strategy;


public class PercentageStrategy implements RolloutStrategy{

    private final int percent;
    public PercentageStrategy(int p) {
        this.percent=p;
    }
    @Override
    public boolean isEnabled(String userId)
    {
        int hash= Math.abs(userId.hashCode()% 100);
        return hash<percent;
    }
}
