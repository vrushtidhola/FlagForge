package org.personal.flagforge.flagservice.strategy;


public interface RolloutStrategy {
    public boolean isEnabled(String userId);
}
