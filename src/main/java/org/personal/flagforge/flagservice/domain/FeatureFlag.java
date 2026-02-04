package org.personal.flagforge.flagservice.domain;

import org.personal.flagforge.flagservice.strategy.RolloutStrategy;

import java.util.Objects;

public class FeatureFlag {

    private final String name;
    private final boolean enabled;
    private final RolloutStrategy rolloutStrategy;

    public FeatureFlag(String name, boolean enabled, RolloutStrategy rolloutStrategy) {


        this.name = name;
        this.enabled = enabled;
        this.rolloutStrategy = Objects.requireNonNull(
                rolloutStrategy,
                "rolloutStrategy cannot be null"
        );
    }

    public boolean isEnabledForUser(String userId) {
        if (!enabled) {
            return false;
        }
        return rolloutStrategy.isEnabled(userId);
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
