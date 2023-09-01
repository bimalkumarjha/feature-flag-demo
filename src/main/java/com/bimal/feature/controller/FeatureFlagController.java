package com.bimal.feature.controller;

import com.bimal.feature.model.FeatureFlag;
import com.bimal.feature.service.FeatureFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/feature-flags")
public class FeatureFlagController {

    @Autowired
    private FeatureFlagService featureFlagService;

    @GetMapping("/{name}")
    public FeatureFlag getFeatureFlag(@PathVariable String name) {
        return featureFlagService.getFeatureFlag(name);
    }

    @PostMapping("/{name}/toggle")
    public void toggleFeatureFlag(@PathVariable String name) {
        featureFlagService.toggleFeatureFlag(name);
    }

    @GetMapping
    public Map<String, FeatureFlag> getAllFeatureFlags() {
        return featureFlagService.getAllFeatureFlags();
    }

    @GetMapping("/{name}/status")
    public ResponseEntity<Boolean> getFeatureStatus(@PathVariable String name, @RequestParam List<String> userRoles) {
        boolean isEnabled = featureFlagService.isFeatureEnabled(name, userRoles);
        return ResponseEntity.ok(isEnabled);
    }

    @PostMapping
    public ResponseEntity<FeatureFlag> createFeatureFlag(@RequestBody FeatureFlag featureFlag) {
        FeatureFlag createdFlag = featureFlagService.createFeatureFlag(featureFlag);
        return ResponseEntity.status(201).body(createdFlag);
    }
}