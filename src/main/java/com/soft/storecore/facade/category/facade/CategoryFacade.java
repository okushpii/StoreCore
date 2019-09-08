package com.soft.storecore.facade.category.facade;

import com.soft.storecore.facade.category.data.CategoryData;

import java.util.List;

public interface CategoryFacade {

    List<CategoryData> findAll();
}
