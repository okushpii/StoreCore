package com.soft.storecore.facade.validation;

import com.soft.storecore.facade.user.facade.UserFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailUniqueConstraintValidatorTest {

    private static final String EMAIL = "email@gmail.com";

    @InjectMocks
    private EmailUniqueConstraintValidator testedInstance;

    @Mock
    private UserFacade userFacade;

    @Test
    public void shouldReturnFalseWhenUserExist(){
        when(userFacade.isUserExist(EMAIL)).thenReturn(true);
        boolean result = testedInstance.isValid(EMAIL, null);

        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenUserNotExist(){
        when(userFacade.isUserExist(EMAIL)).thenReturn(false);
        boolean result = testedInstance.isValid(EMAIL, null);

        assertTrue(result);
    }
}
