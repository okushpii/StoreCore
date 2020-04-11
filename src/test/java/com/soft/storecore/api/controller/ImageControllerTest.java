package com.soft.storecore.api.controller;

import com.soft.storecore.facade.media.ImageFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTest {

    private static final String MEDIA_GROUP = "p1-img";
    private static final String FORMAT = "730x560";

    @InjectMocks
    private ImageController testedInstance;

    @Mock
    private ImageFacade imageFacade;

    @Test
    public void shouldReturnImage(){
        byte[] image = new byte[10];

        when(imageFacade.findImage(MEDIA_GROUP, FORMAT)).thenReturn(image);
        byte[] result = testedInstance.getImage(MEDIA_GROUP, FORMAT);

        assertEquals(image, result);
    }

}