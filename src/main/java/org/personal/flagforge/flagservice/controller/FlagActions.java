package org.personal.flagforge.flagservice.controller;

import org.personal.flagforge.flagservice.domain.CreateFlagRequest;
import org.personal.flagforge.flagservice.domain.FeatureFlag;
import org.personal.flagforge.flagservice.repository.FeatureFlagRepository;
import org.personal.flagforge.flagservice.services.FeatureFlagEvaluator;
import org.personal.flagforge.flagservice.services.FlagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FlagActions {



    private final FlagService service;
    private final FeatureFlagEvaluator featureFlagEvaluator;


    public FlagActions(FlagService service, FeatureFlagEvaluator evaluator) {
        this.service = service;
        this.featureFlagEvaluator=evaluator;
    }

    @PostMapping("/flags")
    public FeatureFlag createFeatureFlag(@RequestBody CreateFlagRequest createFlagRequest)
    {
        System.out.println("CONTROLLER STRATEGY = " + createFlagRequest.getStrategy());
        return service.createFeatureFlag(createFlagRequest);
    }

    @GetMapping("/getflags")
    public List<FeatureFlag> getFeatureFlags()
    {
        return service.getFeatureFlags();
    }

    @GetMapping("/flags/{flagName}")
    public boolean evaluate(        @PathVariable String flagName,
                                    @RequestParam String userId
    )
    {
        return featureFlagEvaluator.evaluate(flagName,userId);
    }
}
