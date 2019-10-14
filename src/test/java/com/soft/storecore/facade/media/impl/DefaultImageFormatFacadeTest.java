package com.soft.storecore.facade.media.impl;

import com.soft.storecore.core.config.service.ConfigurationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultImageFormatFacadeTest {

    private static final String KEY = "anyKey";
    private static final String DEFAULT_VALUE = "anyDefaultValue";
    private static final String FORMAT = "740x456";
    @InjectMocks
    private DefaultImageFormatFacade testedInstance;

    @Mock
    private ConfigurationService configurationService;

    @Test
    public void shouldReturnFormat(){
        when(configurationService.findConfiguration(KEY, DEFAULT_VALUE)).thenReturn(FORMAT);
        String result = testedInstance.getFormat(KEY, DEFAULT_VALUE);

        assertEquals(FORMAT, result);
    }
}
