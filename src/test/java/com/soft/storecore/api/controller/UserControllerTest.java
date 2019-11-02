package com.soft.storecore.api.controller;

import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.user.facade.UserFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserFacade userFacade;

    @Test
    public void shouldAddUser() {
        UserData user = new UserData();

        userController.addUser(user);

        verify(userFacade).addUser(user);
    }
}
