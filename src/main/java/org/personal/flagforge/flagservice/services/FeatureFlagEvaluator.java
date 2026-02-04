package org.personal.flagforge.flagservice.services;

import org.personal.flagforge.flagservice.domain.FeatureFlag;
import org.personal.flagforge.flagservice.repository.FeatureFlagRepository;
import org.springframework.stereotype.Service;

@Service
public class FeatureFlagEvaluator {
    private FeatureFlagRepository featureFlagRepository;
    public FeatureFlagEvaluator(FeatureFlagRepository featureFlagRepository) {
        this.featureFlagRepository = featureFlagRepository;
    }

    public boolean evaluate(String flagName,String userId)
    {
        FeatureFlag flag = featureFlagRepository.findByName(flagName);
        return flag.isEnabledForUser(userId);
    }
}
