package com.soft.storecore.core.sorting.impl;

import com.soft.storecore.core.category.dao.CategoryDao;
import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.DefaultCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCategoryServiceTest {

    private static final long CATEGORY_ID = 23L;

    @InjectMocks
    private DefaultCategoryService testedEntry;

    @Mock
    private CategoryDao categoryDao;
    @Mock
    private Category category;
    @Mock
    private Category superCategory;

    @Test
    public void shouldFindAll() {
        List<Category> categories = Collections.singletonList(category);
        when(categoryDao.findAll()).thenReturn(categories);
        List<Category> result = testedEntry.findAll();

        assertEquals(categories, result);
    }

    @Test
    public void shouldFindSuperCategoriesWhenPresent() {
        List<Category> expected = new ArrayList<>();
        expected.add(category);
        expected.add(superCategory);

        when(category.getSuperCategory()).thenReturn(superCategory);
        List<Category> result = testedEntry.findSupercategories(category);

        assertEquals(expected, result);
    }

    @Test
    public void shouldFindSuperCategoriesWhenAbsent() {
        List<Category> expected = new ArrayList<>();
        expected.add(category);

        when(category.getSuperCategory()).thenReturn(null);
        List<Category> result = testedEntry.findSupercategories(category);

        assertEquals(expected, result);

    }

    @Test
    public void shouldFindById() {
        Optional<Category> expected = Optional.of(category);

        when(categoryDao.findById(CATEGORY_ID)).thenReturn(expected);
        Optional<Category> result = testedEntry.findById(CATEGORY_ID);

        assertEquals(expected, result);
    }
}
