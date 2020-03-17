package com.soft.storecore.core.product.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultPaginationServiceTest {

    private static final int PAGE_SIZE = 10;

    private DefaultPaginationService testedEntry = new DefaultPaginationService();

    @Test
    public void shouldReturnZeroForFirstPage(){
        int result = testedEntry.getStart(1, PAGE_SIZE);

        assertEquals(0, result);
    }

    @Test
    public void shouldReturnTenForSecondPage(){
        int result = testedEntry.getStart(2, PAGE_SIZE);

        assertEquals(10, result);
    }

}