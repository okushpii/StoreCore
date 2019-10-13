package com.soft.storecore.core.config.strategy;

import java.util.Optional;

public interface ConfigurationFetchingStrategy {

    Optional<String> fetchConfiguration(String key);
}
