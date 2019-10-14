package com.soft.storecore.facade.media.impl;

import com.soft.storecore.core.media.entity.MediaVariant;
import com.soft.storecore.core.media.service.ImageService;
import com.soft.storecore.core.media.service.MediaVariantService;
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
public class DefaultImageFacadeTest {

    private static final String MEDIA_GROUP = "p1-img";
    private static final String FORMAT = "730x560";

    @InjectMocks
    private DefaultImageFacade testedInstance;

    @Mock
    private MediaVariantService mediaVariantService;
    @Mock
    private ImageService imageService;
    @Mock
    private MediaVariant mediaVariant;

    @Test
    public void shouldReturnNullWhenImageNotFound(){
        when(mediaVariantService.find(MEDIA_GROUP, FORMAT)).thenReturn(Optional.empty());
        byte[] result = testedInstance.findImage(MEDIA_GROUP, FORMAT);

        assertNull(result);
    }

    @Test
    public void shouldReturnImage(){
        byte[] image = new byte[10];

        when(mediaVariantService.find(MEDIA_GROUP, FORMAT)).thenReturn(Optional.of(mediaVariant));
        when(imageService.getImage(mediaVariant)).thenReturn(image);
        byte[] result = testedInstance.findImage(MEDIA_GROUP, FORMAT);

        assertEquals(image, result);
    }

}