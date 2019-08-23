package com.soft.storecore.facade;

import com.soft.storecore.facade.data.ProductData;

import java.util.List;

public interface ProductFacade {

    List<ProductData> findAllByCategoryId(Long categoryId);
}

