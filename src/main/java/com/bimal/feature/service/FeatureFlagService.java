package com.bimal.feature.service;

import com.bimal.feature.model.FeatureFlag;
import com.bimal.feature.repo.FeatureFlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeatureFlagService {
    @Autowired
    private FeatureFlagRepository featureFlagRepository;
    private final Map<String, FeatureFlag> featureFlags = new HashMap<>();
    public boolean isFeatureEnabled(String name, List<String> userRoles) {
        FeatureFlag flag = featureFlagRepository.findByName(name);
        if (flag == null) {
            return false; // Feature flag does not exist
        }
        // Check if the feature is enabled and if user roles match
        return flag.isEnabled() && (flag.getRoles().isEmpty() || userRoles.stream().anyMatch(flag.getRoles()::contains));
    }

    public FeatureFlag createFeatureFlag(FeatureFlag featureFlag) {
        return featureFlagRepository.save(featureFlag);
    }
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