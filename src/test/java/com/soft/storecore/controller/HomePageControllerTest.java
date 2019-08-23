package com.soft.storecore.controller;

import com.soft.storecore.facade.CategoryFacade;
import com.soft.storecore.facade.data.CategoryData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomePageControllerTest {

    private static final String CATEGORIES_ATTRIBUTE = "categories";
    private static final String HOME_PAGE = "pages/homePage";

    @InjectMocks
    private HomePageController testedEntry;

    @Mock
    private CategoryFacade categoryFacade;
    @Mock
    private Model model;

    @Test
    public void shouldGetHomePage() {
        List<CategoryData> categories = Collections.singletonList(new CategoryData());
        when(categoryFacade.findAll()).thenReturn(categories);
        String result = testedEntry.homePage(model);

        verify(model).addAttribute(CATEGORIES_ATTRIBUTE, categories);
        assertEquals(HOME_PAGE, result);
    }

}