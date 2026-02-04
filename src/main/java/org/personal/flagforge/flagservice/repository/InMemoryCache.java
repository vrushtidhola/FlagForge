package org.personal.flagforge.flagservice.repository;

import org.personal.flagforge.flagservice.domain.FeatureFlag;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class InMemoryCache implements FeatureFlagRepository {
    private  final ConcurrentHashMap<String, FeatureFlag>flagStore = new ConcurrentHashMap<>();

    @Override
    public void save(FeatureFlag flag) {
        flagStore.put(flag.getName(), flag);
    }

    @Override
    public FeatureFlag findByName(String name) {
        return flagStore.get(name);
    }

    @Override
    public void delete(String name) {
        flagStore.remove(name);
    }

    @Override
    public List<FeatureFlag> findAll() {
        return List.copyOf(flagStore.values());
    }

}
