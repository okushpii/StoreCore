package com.soft.storecore.core.sorting.service.impl;

import com.soft.storecore.core.category.dao.CategoryDao;
import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.DefaultCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCategoryServiceTest {

    private static final String CATEGORY_CODE = "21";

    @InjectMocks
    private DefaultCategoryService testedEntry;

    @Mock
    private CategoryDao categoryDao;
    @Mock
    private Category category;

    @Test
    public void shouldFindAll() {
        List<Category> categories = Collections.singletonList(category);
        when(categoryDao.findAll()).thenReturn(categories);
        List<Category> result = testedEntry.findAll();

        assertEquals(categories, result);
    }

    @Test
    public void shouldFindById() {
        Optional<Category> expected = Optional.of(category);

        when(categoryDao.findById(CATEGORY_CODE)).thenReturn(expected);
        Optional<Category> result = testedEntry.findById(CATEGORY_CODE);

        assertEquals(expected, result);
    }
}
