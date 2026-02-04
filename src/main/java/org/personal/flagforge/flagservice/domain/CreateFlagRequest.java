package org.personal.flagforge.flagservice.domain;

public class CreateFlagRequest {

    private String name;
    private boolean enabled;
    private StrategyRequest strategy;

    public CreateFlagRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public StrategyRequest getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyRequest strategy) {
        this.strategy = strategy;
    }
}
