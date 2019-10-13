package com.soft.storecore.core.config.service.impl;

import com.soft.storecore.core.config.strategy.ConfigurationFetchingStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultConfigurationServiceTest {

    private static final String CONFIGURATION_KEY = "key";
    private static final String CONFIGURATION_VALUE = "value";

    @InjectMocks
    private DefaultConfigurationService testedInstance;
    @Mock
    private ConfigurationFetchingStrategy firstStrategy;
    @Mock
    private ConfigurationFetchingStrategy secondStrategy;

    @Before
    public void setUp(){
        testedInstance.setConfigurationFetchingStrategies(List.of(firstStrategy, secondStrategy));
    }


    @Test
    public void shouldReturnFirstStrategyConfigurationWhenFound(){
        when(firstStrategy.fetchConfiguration(CONFIGURATION_KEY)).thenReturn(Optional.of(CONFIGURATION_VALUE));
        Optional<String> result = testedInstance.findConfiguration(CONFIGURATION_KEY);

        assertEquals(Optional.of(CONFIGURATION_VALUE), result);
        verify(secondStrategy, never()).fetchConfiguration(CONFIGURATION_KEY);
    }

    @Test
    public void shouldReturnSecondStrategyWhenFound(){
        when(secondStrategy.fetchConfiguration(CONFIGURATION_KEY)).thenReturn(Optional.of(CONFIGURATION_VALUE));
        Optional<String> result = testedInstance.findConfiguration(CONFIGURATION_KEY);

        assertEquals(Optional.of(CONFIGURATION_VALUE), result);
        verify(firstStrategy).fetchConfiguration(CONFIGURATION_KEY);
    }

    @Test
    public void shouldReturnEmptyWhenNoConfigurationFound(){
        Optional<String> result = testedInstance.findConfiguration(CONFIGURATION_KEY);

        assertEquals(Optional.empty(), result);
    }

}