package com.soft.storecore.core.product.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultPaginationServiceTest {

    private static final int ITEMS_COUNT_EVEN = 50;
    private static final int ITEMS_COUNT_ODD = 35;
    private static final int PAGE_SIZE = 10;
    private static final int PAGES_COUNT_EVEN = 5;
    private static final int PAGES_COUNT_ODD = 4;

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

    @Test
    public void shouldGetPagesCountIfItemsCountIsEven(){
        int result = testedEntry.getPagesCount(ITEMS_COUNT_EVEN, PAGE_SIZE);

        assertEquals(PAGES_COUNT_EVEN, result);
    }

    @Test
    public void shouldGetPagesCountIfItemsCountIsOdd(){
        int result = testedEntry.getPagesCount(ITEMS_COUNT_ODD, PAGE_SIZE);

        assertEquals(PAGES_COUNT_ODD, result);
    }

}