package com.bimal.feature.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "action")
    private String action; // e.g., "TOGGLED", "CREATED"

    @Column(name = "changed_by")
    private String changedBy; // Store user or system identifier

    @Column(name = "changed_at")
    private LocalDateTime changedAt;

    // Constructors, Getters and Setters
    public AuditLog() {
    }

    public AuditLog(String featureName, String action, String changedBy) {
        this.featureName = featureName;
        this.action = action;
        this.changedBy = changedBy;
        this.changedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}