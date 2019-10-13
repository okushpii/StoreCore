package com.soft.storecore.core.config.service;

import java.util.Optional;

public interface ConfigurationService {

    Optional<String> findConfiguration(String key);

    String findConfiguration(String key, String defaultValue);
}
