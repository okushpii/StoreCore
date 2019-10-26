package com.soft.storecore.core.config;

import com.soft.storecore.core.config.strategy.ConfigurationFetchingStrategy;
import com.soft.storecore.core.sorting.pojo.SortingField;
import com.soft.storecore.core.sorting.pojo.SortingType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CoreBeanContext {

    @Resource
    private ConfigurationFetchingStrategy databaseConfigurationFetchingStrategy;
    @Resource
    private ConfigurationFetchingStrategy propertiesConfigurationFetchingStrategy;

    @Bean
    public Map<SortingField, String> daoSortingFieldMap(){
        Map<SortingField, String> map = new HashMap<>();
        map.put(SortingField.PRICE, "p.price");
        map.put(SortingField.PLACEMENT_DATE, "p.placementDate");
        return map;
    }

    @Bean
    public Map<SortingType, String> daoSortingTypeMap(){
        Map<SortingType, String> map = new HashMap<>();
        map.put(SortingType.ASC, "ASC");
        map.put(SortingType.DESC, "DESC");
        return map;
    }

    @Bean
    public List<ConfigurationFetchingStrategy> configurationFetchingStrategies(){
        List<ConfigurationFetchingStrategy> strategies = new ArrayList<>();
        strategies.add(databaseConfigurationFetchingStrategy);
        strategies.add(propertiesConfigurationFetchingStrategy);
        return strategies;
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
