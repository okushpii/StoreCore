package com.soft.storecore.facade;

import com.soft.storecore.model.entity.Category;

import java.util.List;

public interface CategoryFacade {

    List<Category> findAll();
}
