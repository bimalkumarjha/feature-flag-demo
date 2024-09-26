package com.bimal.feature.model;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.List;

public class FeatureFlag {
    private String name;
    private boolean enabled;

    public boolean isScheduledState() {
        return scheduledState;
    }

    public void setScheduledState(boolean scheduledState) {
        this.scheduledState = scheduledState;
    }

    @Column(name = "scheduled_state")
    private boolean scheduledState; // What state to set when the scheduled time is reached


    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    @Column(name = "schedule")
    private LocalDateTime schedule; // When to update the flag
    private List<String> roles; // Roles allowed to access this feature

    // Getters and setters
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public FeatureFlag(String name, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
