package com.bimal.feature.service;

import com.bimal.feature.model.FeatureFlag;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FeatureFlagService {
    private final Map<String, FeatureFlag> featureFlags = new HashMap<>();

    public FeatureFlagService() {
        // Initialize some feature flags
        featureFlags.put("newFeature", new FeatureFlag("newFeature", false));
        featureFlags.put("betaFeature", new FeatureFlag("betaFeature", true));
    }

    public FeatureFlag getFeatureFlag(String name) {
        return featureFlags.get(name);
    }

    public void toggleFeatureFlag(String name) {
        FeatureFlag featureFlag = featureFlags.get(name);
        if (featureFlag != null) {
            featureFlag.setEnabled(!featureFlag.isEnabled());
        }
    }

    public Map<String, FeatureFlag> getAllFeatureFlags() {
        return featureFlags;
    }
}