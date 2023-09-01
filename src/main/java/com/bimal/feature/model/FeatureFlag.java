package com.bimal.feature.model;

import java.util.List;

public class FeatureFlag {
    private String name;
    private boolean enabled;
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

