package com.bimal.feature.service;

import com.bimal.feature.model.AuditLog;
import com.bimal.feature.repo.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void logChange(String featureName, String action, String changedBy) {
        AuditLog auditLog = new AuditLog(featureName, action, changedBy);
        auditLogRepository.save(auditLog);
    }
}
