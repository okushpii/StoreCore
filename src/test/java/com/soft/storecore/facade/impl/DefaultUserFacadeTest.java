package com.soft.storecore.facade.impl;

import com.soft.storecore.core.user.entity.User;
import com.soft.storecore.core.user.service.UserService;
import com.soft.storecore.facade.user.converter.UserReverseConverter;
import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.user.facade.DefaultUserFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserFacadeTest {

    @InjectMocks
    private DefaultUserFacade testedInstance;

    @Mock
    private UserService userService;

    @Mock
    private UserReverseConverter userReverseConverter;

    @Mock
    private UserData userData;

    @Mock
    private User user;

    @Test
    public void shouldAddAccount(){
        when(userReverseConverter.convert(userData)).thenReturn(user);
        testedInstance.addUser(userData);
        verify(userService).addUser(user);
    }
}
