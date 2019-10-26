package com.soft.storecore.facade.util.converter.impl;

import com.soft.storecore.core.user.entity.User;
import com.soft.storecore.facade.user.converter.UserReverseConverter;
import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.user.populator.UserPopulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class UserReverseConverterTest {

    @InjectMocks
    private UserReverseConverter testedInstance;

    @Mock
    private UserData userData;

    @Mock
    private UserPopulator userPopulator;

    @Test
    public void shouldConvertUser(){
        User result = testedInstance.convert(userData);
        verify(userPopulator).populate(userData, result);
    }
}
