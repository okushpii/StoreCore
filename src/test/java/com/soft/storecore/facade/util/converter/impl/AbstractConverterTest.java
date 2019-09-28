package com.soft.storecore.facade.util.converter.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbstractConverterTest {

    @Spy
    private AbstractConverter<Object, Object> testedEntry;

    @Test
    public void shouldConvertAll(){
        Object source = new Object();
        Object target = new Object();

        when(testedEntry.convert(source)).thenReturn(target);
        List<Object> list = testedEntry.convertAll(Collections.singletonList(source));

        assertEquals(target, list.get(0));
    }

}
