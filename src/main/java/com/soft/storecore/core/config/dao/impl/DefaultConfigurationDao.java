package com.soft.storecore.core.config.dao.impl;

import com.soft.storecore.core.config.dao.ConfigurationDao;
import com.soft.storecore.core.config.entity.Configuration;
import com.soft.storecore.core.dao.SessionProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

@Repository
public class DefaultConfigurationDao implements ConfigurationDao {

    private static final String FIND_BY_KEY_QUERY = "SELECT c FROM Configuration c WHERE c.key = :key";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public Optional<Configuration> findConfiguration(String key) {
        return Optional.ofNullable(sessionProvider.getSession().createQuery(FIND_BY_KEY_QUERY, Configuration.class)
                .setParameter("key", key)
                .uniqueResult());
    }
}
