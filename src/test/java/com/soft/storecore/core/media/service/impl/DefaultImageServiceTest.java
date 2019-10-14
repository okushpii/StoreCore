package com.soft.storecore.core.media.service.impl;

import com.soft.storecore.core.common.service.FileService;
import com.soft.storecore.core.media.builder.MediaVariantPathBuilder;
import com.soft.storecore.core.media.entity.MediaVariant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultImageServiceTest {

    private static final String PATH = "C:folder/media/product/p1/p1-img";

    @InjectMocks
    private DefaultImageService testedInstance;

    @Mock
    private MediaVariantPathBuilder mediaVariantPathBuilder;
    @Mock
    private MediaVariant mediaVariant;
    @Mock
    private FileService fileService;

    @Test
    public void shouldReturnNullWhenPathNotFound(){
        when(mediaVariantPathBuilder.buildPath(mediaVariant)).thenReturn(Optional.empty());
        byte[] result = testedInstance.getImage(mediaVariant);

        assertNull(result);
    }

    @Test
    public void shouldReturnImage(){
        byte[] image = new byte[10];

        when(mediaVariantPathBuilder.buildPath(mediaVariant)).thenReturn(Optional.of(PATH));
        when(fileService.loadFile(PATH)).thenReturn(image);
        byte[] result = testedInstance.getImage(mediaVariant);

        assertEquals(image, result);
    }

}