package com.soft.storecore.core.config.service;

import com.soft.storecore.core.config.entity.Configuration;

import java.util.Optional;

public interface ConfigurationService {

    Optional<Configuration> findConfiguration(String key);
}
