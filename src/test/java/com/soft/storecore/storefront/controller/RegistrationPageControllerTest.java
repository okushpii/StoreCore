package com.soft.storecore.storefront.controller;

import com.soft.storecore.facade.user.data.UserData;
import com.soft.storecore.facade.user.facade.UserFacade;
import com.soft.storecore.storefront.controller.page.RegistrationPageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationPageControllerTest {

    private static final String REGISTRATION_PAGE = "pages/registrationPage";
    private static final String REGISTRATION_MAPPING = "/register";
    private static final String REDIRECT_PREFIX = "redirect:";


    @InjectMocks
    private RegistrationPageController testedEntry;

    @Mock
    private UserFacade userFacade;

    @Mock
    private UserData userData;

    @Test
    public void shouldGetRegistration() {
        String result = testedEntry.registration();

        assertEquals(REGISTRATION_PAGE, result);
    }

    @Test
    public void shouldAddAccount() {
        String expected = REDIRECT_PREFIX + REGISTRATION_MAPPING;

        String result = testedEntry.addAccount(userData);

        verify(userFacade).addUser(userData);

        assertEquals(expected, result);

    }
}
