package com.soft.storecore.core.config.strategy.impl;

import com.soft.storecore.core.config.entity.Configuration;
import com.soft.storecore.core.config.strategy.ConfigurationFetchingStrategy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class PropertiesConfigurationFetchingStrategy implements ConfigurationFetchingStrategy {

    @Resource
    private Environment environment;

    @Override
    public Optional<Configuration> fetchConfiguration(String key) {
        Optional<String> property = Optional.ofNullable(environment.getProperty(key));
        return property.flatMap(s -> createConfiguration(key, s));
    }

    private Optional<Configuration> createConfiguration(String key, String property) {
        Configuration configuration = new Configuration();
        configuration.setKey(key);
        configuration.setValue(property);
        return Optional.of(configuration);
    }
}
