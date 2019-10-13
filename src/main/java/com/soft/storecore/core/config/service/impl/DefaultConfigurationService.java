package com.soft.storecore.core.config.service.impl;

import com.soft.storecore.core.config.service.ConfigurationService;
import com.soft.storecore.core.config.strategy.ConfigurationFetchingStrategy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultConfigurationService implements ConfigurationService {

    @Resource
    private List<ConfigurationFetchingStrategy> configurationFetchingStrategies;

    @Override
    public Optional<String> findConfiguration(String key) {
        return configurationFetchingStrategies.stream()
                .flatMap(st -> st.fetchConfiguration(key).stream())
                .findFirst();
    }

    @Override
    public String findConfiguration(String key, String defaultValue) {
        return findConfiguration(key).orElse(defaultValue);
    }


    public void setConfigurationFetchingStrategies(List<ConfigurationFetchingStrategy>
                                                           configurationFetchingStrategies) {
        this.configurationFetchingStrategies = configurationFetchingStrategies;
    }
}
