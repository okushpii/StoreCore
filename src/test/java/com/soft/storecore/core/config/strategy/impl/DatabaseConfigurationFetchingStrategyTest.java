package com.soft.storecore.core.config.strategy.impl;

import com.soft.storecore.core.config.dao.ConfigurationDao;
import com.soft.storecore.core.config.entity.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseConfigurationFetchingStrategyTest {

    private static final String KEY = "testKey";

    @InjectMocks
    private DatabaseConfigurationFetchingStrategy testedInstance;
    @Mock
    private ConfigurationDao configurationDao;
    @Mock
    private Configuration configuration;

    @Test
    public void shouldReturnConfiguration(){
        when(configurationDao.findConfiguration(KEY)).thenReturn(Optional.of(configuration));
        Optional<Configuration> result = testedInstance.fetchConfiguration(KEY);

        assertEquals(Optional.of(configuration), result);
    }

}