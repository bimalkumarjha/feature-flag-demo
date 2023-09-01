package com.bimal.feature.repo;

import com.bimal.feature.model.FeatureFlag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureFlagRepository extends JpaRepository<FeatureFlag, Long> {
    FeatureFlag findByName(String name);
}
