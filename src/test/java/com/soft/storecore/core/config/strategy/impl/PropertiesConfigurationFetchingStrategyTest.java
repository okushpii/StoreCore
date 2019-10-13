package com.soft.storecore.core.config.strategy.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertiesConfigurationFetchingStrategyTest {

    private static final String PROPERTY_KEY = "key";
    private static final String PROPERTY_VALUE = "value";

    @InjectMocks
    private PropertiesConfigurationFetchingStrategy testedInstance;
    @Mock
    private Environment environment;

    @Test
    public void shouldReturnConfiguration(){
        when(environment.getProperty(PROPERTY_KEY)).thenReturn(PROPERTY_VALUE);
        Optional<String> result = testedInstance.fetchConfiguration(PROPERTY_KEY);

        assertEquals(Optional.of(PROPERTY_VALUE), result);
    }

}