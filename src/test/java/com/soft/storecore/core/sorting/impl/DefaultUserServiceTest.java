package com.soft.storecore.core.sorting.impl;

import com.soft.storecore.core.user.dao.UserDao;
import com.soft.storecore.core.user.entity.User;
import com.soft.storecore.core.user.service.DefaultUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserServiceTest {

    private static final String EMAIL = "email@gmail.com";

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

    @Test
    public void shouldReturnTrueWhenUserFound(){
        when(userDao.find(EMAIL)).thenReturn(Optional.of(user));
        boolean result = testedEntry.isExists(EMAIL);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenUserNotFound(){
        when(userDao.find(EMAIL)).thenReturn(Optional.empty());
        boolean result = testedEntry.isExists(EMAIL);

        assertFalse(result);
    }
}
