package com.soft.storecore.core.media.service.impl;

import com.soft.storecore.core.media.dao.MediaVariantDao;
import com.soft.storecore.core.media.entity.MediaVariant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMediaVariantServiceTest {

    private static final String MEDIA_GROUP = "p1-img";
    private static final String FORMAT = "730x560";

    @InjectMocks
    private DefaultMediaVariantService testedInstance;

    @Mock
    private MediaVariantDao mediaVariantDao;
    @Mock
    private MediaVariant mediaVariant;

    @Test
    public void shouldReturnMediaVariant(){
        when(mediaVariantDao.find(MEDIA_GROUP, FORMAT)).thenReturn(Optional.of(mediaVariant));
        Optional<MediaVariant> result = testedInstance.find(MEDIA_GROUP, FORMAT);

        assertEquals(Optional.of(mediaVariant), result);
    }

}