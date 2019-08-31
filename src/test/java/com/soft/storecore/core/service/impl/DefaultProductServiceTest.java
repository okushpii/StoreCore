package com.soft.storecore.core.service.impl;

import com.soft.storecore.core.dao.ProductDao;
import com.soft.storecore.core.entity.Category;
import com.soft.storecore.core.entity.Product;
import com.soft.storecore.core.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultProductServiceTest {

    private static final long CATEGORY_ID = 23L;
    private static final long CHILD_CATEGORY_ID = 27L;
    @InjectMocks
    private DefaultProductService testedEntry;

    @Mock
    private ProductDao productDao;
    @Mock
    private Product product;
    @Mock
    private CategoryService categoryService;
    @Mock
    private Category category;
    @Mock
    private Category childCategory;

    @Before
    public void setUp(){
        when(categoryService.findById(CATEGORY_ID)).thenReturn(category);
        when(childCategory.getId()).thenReturn(CHILD_CATEGORY_ID);
    }

    @Test
    public void shouldFindAllByCategoryIdWhenNoChildCategoriesAbsent(){
        List<Product> expectedProducts = Collections.singletonList(product);

        when(category.getChildCategories()).thenReturn(Collections.emptyList());
        when(productDao.findAllByCategoryId(CATEGORY_ID)).thenReturn(expectedProducts);

        List<Product> products = testedEntry.findAllByCategoryId(CATEGORY_ID);
        assertEquals(expectedProducts, products);
    }

    @Test
    public void shouldFindAllByCategoryWhenChildCategoriesArePresent(){
        List<Product> expectedProducts = Collections.singletonList(product);

        when(category.getChildCategories()).thenReturn(Collections.singletonList(childCategory));
        when(productDao.findAllByCategoryId(CHILD_CATEGORY_ID)).thenReturn(expectedProducts);

        List<Product> products = testedEntry.findAllByCategoryId(CATEGORY_ID);
        assertEquals(expectedProducts, products);
    }
}
