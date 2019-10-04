package com.soft.storecore.core.config.strategy;

import com.soft.storecore.core.config.entity.Configuration;

import java.util.Optional;

public interface ConfigurationFetchingStrategy {

    Optional<Configuration> fetchConfiguration(String key);
}
