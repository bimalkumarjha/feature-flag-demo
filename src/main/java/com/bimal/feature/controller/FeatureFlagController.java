package com.bimal.feature.controller;

import com.bimal.feature.model.FeatureFlag;
import com.bimal.feature.service.AuditLogService;
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

    @Autowired
    private AuditLogService auditLogService;

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

    @PostMapping("/{name}/toggle")
    public ResponseEntity<String> toggleFeature(@PathVariable String name, @RequestParam String changedBy) {
        featureFlagService.toggleFeatureFlag(name);
        auditLogService.logChange(name, "TOGGLED", changedBy);
        return ResponseEntity.ok("Feature toggled");
    }

    @PostMapping
    public ResponseEntity<String> createFeatureFlag(@RequestBody FeatureFlag featureFlag) {
        featureFlagService.createFeatureFlag(featureFlag);
        auditLogService.logChange(featureFlag.getName(), "CREATED", "SYSTEM"); // Adjust the changedBy value as needed
        return ResponseEntity.ok("Feature flag created");
    }
}