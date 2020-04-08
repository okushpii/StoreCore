package com.soft.storecore.api.controller;

import com.soft.storecore.core.product.service.PaginationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaginationControllerTest {

    private static final int ITEMS_COUNT = 30;
    private static final int PAGE_SIZE = 5;
    private static final int PAGES_COUNT = 6;

    @InjectMocks
    private PaginationController testedInstance;

    @Mock
    private PaginationService paginationService;

    @Test
    public void shouldGetCountOfPages(){
        when(paginationService.getPagesCount(ITEMS_COUNT, PAGE_SIZE)).thenReturn(PAGES_COUNT);

        int result = testedInstance.getCountOfPages(ITEMS_COUNT, PAGE_SIZE);

        assertEquals(PAGES_COUNT, result);
    }
}