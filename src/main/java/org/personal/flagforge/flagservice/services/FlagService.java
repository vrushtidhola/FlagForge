package org.personal.flagforge.flagservice.services;

import org.personal.flagforge.flagservice.FlagFactory;
import org.personal.flagforge.flagservice.domain.CreateFlagRequest;
import org.personal.flagforge.flagservice.domain.FeatureFlag;
import org.personal.flagforge.flagservice.repository.FeatureFlagRepository;
import org.personal.flagforge.flagservice.repository.InMemoryCache;
import org.personal.flagforge.flagservice.strategy.RolloutStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlagService {

    private final FeatureFlagRepository featureFlagRepository;

    public FlagService(FeatureFlagRepository featureFlagRepository) {
        this.featureFlagRepository = featureFlagRepository;
    }
    public FeatureFlag createFeatureFlag(CreateFlagRequest createFlagRequest)
    {
        System.out.println("===== CREATE FLAG CALLED =====");
        System.out.println("REQ OBJ = " + createFlagRequest);
        System.out.println("STRATEGY = " + createFlagRequest.getStrategy());

        if (createFlagRequest == null) {
            throw new RuntimeException("CreateFlagRequest is NULL");
        }
        RolloutStrategy rolloutStrategy= FlagFactory.from(createFlagRequest.getStrategy());
        System.out.println(rolloutStrategy.isEnabled("user123"));
        FeatureFlag featureFlag= new FeatureFlag(
                createFlagRequest.getName(),
                createFlagRequest.isEnabled(),
                rolloutStrategy
        );
        featureFlagRepository.save(featureFlag);
        return  featureFlag;
    }
    public List<FeatureFlag> getFeatureFlags()
    {
        return featureFlagRepository.findAll();
    }
}
