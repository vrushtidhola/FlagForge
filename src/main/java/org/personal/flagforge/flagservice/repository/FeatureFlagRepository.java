package org.personal.flagforge.flagservice.repository;

import org.personal.flagforge.flagservice.domain.FeatureFlag;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FeatureFlagRepository {
    FeatureFlag findByName(String FeatureName);
    void save(FeatureFlag flag);
    void delete(String Name);
    List<FeatureFlag> findAll();
}
