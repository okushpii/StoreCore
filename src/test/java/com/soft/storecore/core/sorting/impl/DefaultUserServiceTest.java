package com.soft.storecore.core.sorting.impl;

import com.soft.storecore.core.user.dao.UserDao;
import com.soft.storecore.core.user.entity.User;
import com.soft.storecore.core.user.service.DefaultUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserServiceTest {

    @InjectMocks
    private DefaultUserService testedEntry;

    @Mock
    private UserDao userDao;

    @Mock
    private User user;

    @Test
    public void shouldAddUser() {
        testedEntry.addUser(user);
        verify(userDao).addUser(user);
    }
}
