package com.soft.storecore.facade.category.facade;

import com.soft.storecore.facade.category.data.CategoryData;

import java.util.List;
import java.util.Optional;

public interface CategoryFacade {

    List<CategoryData> findAll();

    Optional<CategoryData> find(String code);
}
