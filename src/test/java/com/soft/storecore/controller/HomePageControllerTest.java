package com.soft.storecore.controller;

import com.soft.storecore.facade.CategoryFacade;
import com.soft.storecore.model.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomePageControllerTest {

    @InjectMocks
    private HomePageController testedEntry;

    @Mock
    private CategoryFacade categoryFacade;
    @Mock
    private Category category;
    @Mock
    private Model model;

    @Test
    public void shouldGetHomePage(){
        List<Category> categories = Collections.singletonList(category);
        when(categoryFacade.findAll()).thenReturn(categories);
        String result = testedEntry.homePage(model);

        verify(model).addAttribute("categories", categories);
        assertEquals("pages/homePage", result);
    }

}