package com.soft.storecore.core.config.dao;

import com.soft.storecore.core.config.entity.Configuration;

import java.util.Optional;

public interface ConfigurationDao {

    Optional<Configuration> findConfiguration(String key);
}
