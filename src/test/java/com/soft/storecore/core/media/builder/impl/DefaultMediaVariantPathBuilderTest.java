package com.soft.storecore.core.media.builder.impl;

import com.soft.storecore.core.config.service.ConfigurationService;
import com.soft.storecore.core.media.entity.MediaVariant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMediaVariantPathBuilderTest {

    private static final String SYSTEM_PATH_MEDIA_KEY = "system.path.media";
    private static final String SYSTEM_PATH = "C:/storecore/media";
    private static final String EXPECTED_PATH = "C:/storecore/media/product/p1-img/p1-img-740x560";
    private static final String FOLDER_NAME = "product/p1-img";
    private static final String FILE_NAME = "p1-img-740x560";

    @InjectMocks
    private DefaultMediaVariantPathBuilder testedInstance;

    @Mock
    private ConfigurationService configurationService;
    @Mock
    private MediaVariant mediaVariant;

    @Before
    public void setUp(){
        when(mediaVariant.getFolderName()).thenReturn(FOLDER_NAME);
        when(mediaVariant.getFileName()).thenReturn(FILE_NAME);
    }

    @Test
    public void shouldReturnEmptyWhenSystemPathNotFound(){
        when(configurationService.findConfiguration(SYSTEM_PATH_MEDIA_KEY)).thenReturn(Optional.empty());
        Optional<String> result = testedInstance.buildPath(mediaVariant);

        assertEquals(Optional.empty(), result);
    }

    @Test
    public void shouldBuildPath(){
        when(configurationService.findConfiguration(SYSTEM_PATH_MEDIA_KEY))
                .thenReturn(Optional.of(SYSTEM_PATH));
        Optional<String> result = testedInstance.buildPath(mediaVariant);

        assertEquals(Optional.of(EXPECTED_PATH), result);
    }

}