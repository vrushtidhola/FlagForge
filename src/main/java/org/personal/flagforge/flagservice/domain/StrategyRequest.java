package org.personal.flagforge.flagservice.domain;

public class StrategyRequest {

    private String type;
    private int value;

    public StrategyRequest() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
