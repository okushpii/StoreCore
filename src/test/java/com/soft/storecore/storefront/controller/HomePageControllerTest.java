package com.soft.storecore.storefront.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HomePageControllerTest {

    private static final String HOME_PAGE = "pages/homePage";

    @InjectMocks
    private HomePageController testedEntry;

    @Mock
    private Model model;

    @Test
    public void shouldGetHomePage() {
        String result = testedEntry.homePage(model);

        assertEquals(HOME_PAGE, result);
    }
}
