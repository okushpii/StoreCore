package com.soft.storecore.facade.util.populator;

import com.soft.storecore.core.common.service.IdGenarationService;
import com.soft.storecore.core.user.entity.User;
import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.user.populator.UserPopulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserPopulatorTest {

    private static final String USER_CODE = "p35";
    private static final String USER_FIRST_NAME = "firstName";
    private static final String USER_LAST_NAME = "lastName";
    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password";

    @InjectMocks
    private UserPopulator testedInstance;

    @Mock
    private UserData userData;

    @Mock
    private IdGenarationService idGenarationService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void shouldPopulateUser(){
        User user = new User();

        prepareUserData();
        testedInstance.populate(userData, user);

        assertEquals(USER_CODE, user.getCode());
        assertEquals(USER_FIRST_NAME, user.getFirstName());
        assertEquals(USER_LAST_NAME, user.getLastName());
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(USER_PASSWORD, user.getPassword());
    }

    private void prepareUserData(){
        when(idGenarationService.generate()).thenReturn(USER_CODE);
        when(userData.getFirstName()).thenReturn(USER_FIRST_NAME);
        when(userData.getLastName()).thenReturn(USER_LAST_NAME);
        when(userData.getEmail()).thenReturn(USER_EMAIL);
        when(passwordEncoder.encode(userData.getPassword())).thenReturn(USER_PASSWORD);
    }
}
