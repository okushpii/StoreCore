package com.soft.storecore.core.config.strategy.impl;

import com.soft.storecore.core.config.dao.ConfigurationDao;
import com.soft.storecore.core.config.entity.Configuration;
import com.soft.storecore.core.config.strategy.ConfigurationFetchingStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class DatabaseConfigurationFetchingStrategy implements ConfigurationFetchingStrategy {

    @Resource
    private ConfigurationDao configurationDao;

    @Override
    public Optional<String> fetchConfiguration(String key) {
        return configurationDao.findConfiguration(key)
                .map(Configuration::getValue);
    }
}
