package com.soft.storecore.core.common.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFileServiceTest {

    private static final String PATH = "C:folder/media/product/p1/p1-img";

    @Spy
    @InjectMocks
    private DefaultFileService testedInstance;

    @Test
    public void shouldLoadFile(){
        byte[] file = new byte[10];

        doReturn(file).when(testedInstance).readFileToByteArray(PATH);
        byte[] result = testedInstance.loadFile(PATH);

        assertEquals(file, result);
    }

}