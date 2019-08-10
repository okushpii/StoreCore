package com.soft.storecore.facade;

import com.soft.storecore.facade.data.CategoryData;

import java.util.List;

public interface CategoryFacade {

    List<CategoryData> findAll();
}
