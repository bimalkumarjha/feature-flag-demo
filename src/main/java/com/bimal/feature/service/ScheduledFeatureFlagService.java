package com.bimal.feature.service;

import com.bimal.feature.repo.FeatureFlagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduledFeatureFlagService {

    @Autowired
    private FeatureFlagRepository featureFlagRepository;

    // This method will run every minute. Adjust the cron expression as needed.
    @Scheduled(cron = "0 * * * * ?")
    public void updateFeatureFlags() {
        LocalDateTime now = LocalDateTime.now();
        featureFlagRepository.findAll().forEach(flag -> {
            // Check if the flag should be enabled/disabled based on your logic
            if (flag.getSchedule() != null && now.isAfter(flag.getSchedule())) {
                flag.setEnabled(flag.isScheduledState());
                featureFlagRepository.save(flag);
                // Optionally log the change
                System.out.println("Updated feature flag: " + flag.getName() + " to state: " + flag.isEnabled());
            }
        });
    }
}
